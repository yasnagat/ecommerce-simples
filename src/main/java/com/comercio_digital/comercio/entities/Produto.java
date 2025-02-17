package com.comercio_digital.comercio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imgURL;

    // garante que nao teremos um produto com uma categoria repetida
    @ManyToMany
    @JoinTable(name = "CATEGORIA_PRODUTO",
            joinColumns = @JoinColumn(name = "id_produto"),
            // define a chave estrangeira da outra entidade
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonIgnore
    public Set<Pedido> getPedidos() {
        Set<Pedido> set = new HashSet<>();
        for (ItemPedido item : itens) {
            set.add(item.getPedido());
        }
        return set;
    }

    public Produto() {}
    public Produto(Long id, String nome, String descricao, Double preco, String imgURL) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgURL = imgURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Set<Categoria> getCategoria() {
        return categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
