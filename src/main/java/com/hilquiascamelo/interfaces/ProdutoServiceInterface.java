package com.hilquiascamelo.interfaces;

import com.hilquiascamelo.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoServiceInterface {

    Page<Produto> findAll(Pageable pageable);

    Produto find(Integer id);

    Produto insert(Produto obj);

    Produto update(Produto obj);

    void delete(Integer id);
}
