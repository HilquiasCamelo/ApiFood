package com.hilquiascamelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hilquiascamelo.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
