package com.comercio_digital.comercio.entities;

import com.comercio_digital.comercio.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // a partir do Java 8, usamos Instant em vez de Date
    // formatacao da data no padrao ISO
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instante;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Usuario cliente;

    public Pedido() {}
    public Pedido(Long id, Instant instante, PedidoStatus status, Usuario cliente) {
        this.id = id;
        this.instante = instante;
        setStatus(status);
        this.cliente = cliente;
    }

    private PedidoStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public PedidoStatus getStatus() {
        return PedidoStatus.valueOf(String.valueOf(status));
    }

    public void setStatus(PedidoStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
