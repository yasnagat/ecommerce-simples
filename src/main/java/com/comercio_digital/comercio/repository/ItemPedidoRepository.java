package com.comercio_digital.comercio.repository;

import com.comercio_digital.comercio.entities.ItemPedido;
import com.comercio_digital.comercio.entities.pk.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
