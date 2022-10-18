package com.hilquiascamelo.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;

	public UserNewDTO() {
	}

	//Creating a constructor with arguments makes it easier to instantiate classes

	public UserNewDTO(String nome, String email, Integer tipo, String senha, String logradouro, String numero) {
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
		this.senha = senha;
		this.logradouro = logradouro;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (!(object instanceof UserNewDTO)) return false;
		if (!super.equals(object)) return false;
		UserNewDTO that = (UserNewDTO) object;
		return java.util.Objects.equals(nome, that.nome) && java.util.Objects.equals(email, that.email) && java.util.Objects.equals(tipo, that.tipo) && java.util.Objects.equals(senha, that.senha) && java.util.Objects.equals(logradouro, that.logradouro) && java.util.Objects.equals(numero, that.numero);
	}

	public int hashCode() {
		return Objects.hash(super.hashCode(), nome, email, tipo, senha, logradouro, numero);
	}
}
