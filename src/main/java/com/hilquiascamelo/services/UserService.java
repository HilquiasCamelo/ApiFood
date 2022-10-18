package com.hilquiascamelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.hilquiascamelo.dao.UserRepository;
import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.User;

import com.hilquiascamelo.models.enums.UserType;
import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;


@Service
public class UserService {
    	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	

	public User find(Integer id) {
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
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
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
    public User insert(User obj) {
		return repo.save(obj);
	}
	public User fromDTO(UserNewDTO objDto) {
		return new User(null, objDto.getNome(), pe.encode(objDto.getSenha()), objDto.getEmail(), UserType.toEnum(objDto.getTipo()));
	}	
	public User update(User obj) {
		User newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(pe.encode(obj.getSenha()));
	}
}
