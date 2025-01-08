package com.comercio_digital.comercio.entities;

import com.comercio_digital.comercio.entities.pk.QuantItensPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.context.annotation.EnableMBeanExport;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ITENS_PEDIDO")
public class ItemPedido implements Serializable {
    @Serial
    static final long serialVersionUID = 1L;

    // usamos a classe PK
    @EmbeddedId
    private QuantItensPK id;

    private Integer quantidade;
    private Double preco;

    public ItemPedido() {}
    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        // pegamos o id da classe de associacao
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }
    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }
    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}