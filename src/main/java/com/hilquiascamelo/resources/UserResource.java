package com.hilquiascamelo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.User;
import com.hilquiascamelo.services.UserService;

import io.swagger.annotations.ApiOperation;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value="/user")
public class UserResource {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Lists all registered user by id")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Integer id) {
		User obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Lists all registered user ")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create new user")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody UserNewDTO objDto) {
	    User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Update registered user")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody User obj, @PathVariable Integer id) {
		obj.setId(id);
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
