package com.hilquiascamelo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hilquiascamelo.models.enums.UserType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUsers;

    private String nome;

    @JsonIgnore
    private String senha;

    private String email;

    private Integer tipo;

    public Users() {
    }

    public Users(Integer id, String nome, String senha, String email, UserType tipo) {
        this.idUsers = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipo = (tipo == null)? null : tipo.getCod();
    }

    public Integer getId() {
        return idUsers;
    }

    public void setId(Integer id) {
        this.idUsers = id;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

  
}
