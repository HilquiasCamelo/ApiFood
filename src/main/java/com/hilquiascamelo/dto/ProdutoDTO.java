package com.hilquiascamelo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id ;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome ;

    private Double preco ;
    private Date validade;
    private Date dataFabricacao;
    private long codigo;
    private double peso;
    private String descricao ;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String nome, Double preco, Date validade, Date dataFabricacao, long codigo,
                      double peso, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.dataFabricacao = dataFabricacao;
        this.codigo = codigo;
        this.peso = peso;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
