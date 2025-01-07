package com.comercio_digital.comercio.resource;


import com.comercio_digital.comercio.entities.Pedido;
import com.comercio_digital.comercio.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")

public class PedidoResource {

    @Autowired
    private PedidoService servico;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> pedidos = servico.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

     // a requisicao aceita um id dentro da URL
    @GetMapping(value = "/{id}")

    // @PathVariable para o spring aceitar o id
    public ResponseEntity<Pedido> buscaPeloId(@PathVariable Long id) {
        Pedido obj = servico.buscaPeloId(id);
        return ResponseEntity.ok().body(obj);
    }
}
