package com.hilquiascamelo.services;

import com.hilquiascamelo.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.hilquiascamelo.dao.UserRepository;
import com.hilquiascamelo.dto.UserNewDTO;
import com.hilquiascamelo.models.Users;

import com.hilquiascamelo.models.enums.UserType;
import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;


@Service
public class UserService implements UserServiceInterface {
    	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Override
	public Users find(Integer id) {
		
		Optional<Users> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName()));
	}
	
	@Override
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete because there are related users");
		}
	}

	
	@Override
	public Page<Users> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
    @Override
	public Users insert(Users obj) {
		return repo.save(obj);
	}
	@Override
	public Users fromDTO(UserNewDTO objDto) {
		return new Users(null, objDto.getNome(), pe.encode(objDto.getPassword()), objDto.getEmail(), UserType.toEnum(objDto.getTipo()), 
		objDto.getSituation() );
	}	
	@Override
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
