package com.hilquiascamelo.interfaces;

import com.hilquiascamelo.dto.CategoriaDTO;
import com.hilquiascamelo.models.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaServiceInterface {

    Page<Categoria> findAll(Pageable pageable);

    Categoria find(Integer id);

    Categoria insert(Categoria obj);

    Categoria update(Categoria obj);

    void delete(Integer id);

    Categoria fromDTO(CategoriaDTO objDto);
}
