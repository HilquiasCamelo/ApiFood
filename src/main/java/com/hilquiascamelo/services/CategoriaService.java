package com.hilquiascamelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilquiascamelo.dao.CategoriaRepository;
import com.hilquiascamelo.models.Categoria;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;

import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	public List<Categoria> findAll() {
		return repo.findAll();
	}

}
