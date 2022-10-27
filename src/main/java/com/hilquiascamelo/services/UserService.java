package com.hilquiascamelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.hilquiascamelo.dao.UserRepository;
import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.Users;

import com.hilquiascamelo.models.enums.UserType;
import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;


@Service
public class UserService {
    	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	

	public Users find(Integer id) {
		
		Optional<Users> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName()));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are related users");
		}
	}
	
	public List<Users> findAll() {
		return repo.findAll();
	}
	
    public Users insert(Users obj) {
		return repo.save(obj);
	}
	public Users fromDTO(UserNewDTO objDto) {
		return new Users(null, objDto.getNome(), pe.encode(objDto.getSenha()), objDto.getEmail(), UserType.toEnum(objDto.getTipo()), 
		objDto.getSituation() );
	}	
	public Users update(Users obj) {
		Users newObj = find(obj.getIdUsers());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Users newObj, Users obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(pe.encode(obj.getPassword()));
	}
}
