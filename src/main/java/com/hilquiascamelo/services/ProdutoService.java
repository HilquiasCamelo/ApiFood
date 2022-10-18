package com.hilquiascamelo.services;

import com.hilquiascamelo.dao.ProdutoRepository;
import com.hilquiascamelo.models.Produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Produto que possui produtos");
		}
	}
	private void updateData(Produto newObj, Produto obj) {
		newObj.setNome(obj.getNome());
	}
}
