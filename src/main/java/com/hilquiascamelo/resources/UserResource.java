package com.hilquiascamelo.resources;

import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.Users;
import com.hilquiascamelo.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Lists all registered user by id")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Users> find(@PathVariable Integer id) {
		Users obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Lists all registered user ")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Users>>findAll(Pageable pageable) {
		Page<Users> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create new user")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody UserNewDTO objDto) {
	    Users obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdUsers()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Update registered user")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Users obj, @PathVariable Integer id) {
		obj.setIdUsers(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation(value = "Delete registered user")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
