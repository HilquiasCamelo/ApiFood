package com.hilquiascamelo.interfaces;

import com.hilquiascamelo.models.Produto;

import java.util.List;

public interface ProdutoServiceInterface {
    List<Produto> findAll();

    Produto find(Integer id);

    Produto insert(Produto obj);

    Produto update(Produto obj);

    void delete(Integer id);
}
