package com.hilquiascamelo.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hilquiascamelo.dao.CategoriaRepository;
import com.hilquiascamelo.dao.ProdutoRepository;
import com.hilquiascamelo.dao.UserRepository;
import com.hilquiascamelo.models.Categoria;
import com.hilquiascamelo.models.Produto;
import com.hilquiascamelo.models.Users;
import com.hilquiascamelo.models.enums.UserType;

@Service
public class BancoSeedService {

    @Autowired
	private BCryptPasswordEncoder pe;

    @Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * @throws ParseException
     */
    public void instantiateTestDatabase() throws ParseException {
		
		Categoria categoria1 = new Categoria(null, "Pizzas");
		Categoria categoria2 = new Categoria(null, "Pastéis");
		Categoria categoria3 = new Categoria(null, "Sushis");
		Categoria categoria4 = new Categoria(null, "Petiscos");
		Categoria categoria5 = new Categoria(null, "Bebidas");
		Categoria categoria6 = new Categoria(null, "Mercado");
		Categoria categoria7 = new Categoria(null, "Açái");
    	Categoria categoria8 = new Categoria(null, "Doces e Bolos");
        Categoria categoria9 = new Categoria(null, "Padarias");
        Categoria categoria10 = new Categoria(null, "Sorvetes");
        Categoria categoria11 = new Categoria(null, "Vergana");
        Categoria categoria12 = new Categoria(null, "HotDogs");
        Categoria categoria13 = new Categoria(null, "Regional");
        Categoria categoria14 = new Categoria(null, "Italiana");
        Categoria categoria15 = new Categoria(null, "Frutos do Mar");
        Categoria categoria16 = new Categoria(null, "Espetinhos");
        Categoria categoria17 = new Categoria(null, "Frangos");
        Categoria categoria18 = new Categoria(null, "Congelador");
        Categoria categoria19 = new Categoria(null, "Carnes");
        Categoria categoria20 = new Categoria(null, "Lanches");

        Produto produto = new Produto(null,"Napoli", 52.20,null, 
        null , 1, 500.00, "Pizza deliciosa" );

        Produto produto1 = new Produto(null,"Calabresa", 52.20,null, 
        null , 1, 500.00, "Pizza deliciosa" );

        Users users = new Users(null, "Hilquias", pe.encode("123"), "hilquiaswpc10@outlook.com", UserType.DIRETOR);

        produto1.getCategorias().add(categoria1);
        produto.getCategorias().add(categoria1);
        
        categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2,categoria3, categoria4, categoria5, categoria6, categoria7,
        categoria8, categoria9, categoria10, categoria11, categoria12 ,categoria13, categoria14 , categoria15, categoria16, categoria17, categoria18, categoria19, categoria20));

        produtoRepository.saveAll(Arrays.asList(produto, produto1));

        userRepository.saveAll(Arrays.asList(users));

    }

}
