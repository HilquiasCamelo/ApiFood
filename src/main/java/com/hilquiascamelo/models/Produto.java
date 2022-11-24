package com.hilquiascamelo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
    private List<Categoria> categorias = new ArrayList<>();

    private String nome;

    private Double preco;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataFabricacao;

    private Date validade;

    private long codigo;

    private double peso;

    private String descricao;

    public Produto() {
    }


    public Produto(Integer id, String nome, Double preco, Date dataFabricacao, Date validade, long codigo, double
            peso, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataFabricacao = dataFabricacao;
        this.validade = validade;
        this.codigo = codigo;
        this.peso = peso;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
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

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Produto)) return false;
        if (!super.equals(object)) return false;
        Produto produto = (Produto) object;
        return codigo == produto.codigo && java.lang.Double.compare(produto.peso, peso) == 0 &&
                java.util.Objects.equals(id, produto.id) && java.util.Objects.equals(categorias, produto.categorias)
                && java.util.Objects.equals(nome, produto.nome) && java.util.Objects.equals(preco, produto.preco) &&
                java.util.Objects.equals(dataFabricacao, produto.dataFabricacao) && java.util.Objects.equals(validade,
                produto.validade);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
