package com.hilquiascamelo.services;

import com.hilquiascamelo.dao.ProdutoRepository;
import com.hilquiascamelo.interfaces.ProdutoServiceInterface;
import com.hilquiascamelo.models.Produto;
import com.hilquiascamelo.services.execeptions.DataIntegrityException;
import com.hilquiascamelo.services.execeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class ProdutoService implements ProdutoServiceInterface {

	@Autowired
	private ProdutoRepository repo;

	@Override
	public Page<Produto> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	@Override
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	@Override
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	@Override
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	@Override
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
