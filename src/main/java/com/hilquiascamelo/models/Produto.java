package com.hilquiascamelo.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


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

    @Column(nullable = false, columnDefinition = "TEXT", length = 100)
    private String nome;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String preco;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date dataFabricacao;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date validade;

    @Column(nullable = false, columnDefinition = "NUMERIC")
    private long codigo;

    @Column(nullable = true, columnDefinition = "NUMERIC")
    private double peso;

    @Column(nullable = true, columnDefinition = "TEXT" ,length = 1000)
    private String descricao;

    public Produto() {
    }


    public Produto(Integer id, String nome, String preco, Date dataFabricacao, Date validade, long codigo, double
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
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
