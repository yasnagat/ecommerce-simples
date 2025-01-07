package com.comercio_digital.comercio.services;

import com.comercio_digital.comercio.entities.Pedido;
import com.comercio_digital.comercio.entities.Usuario;
import com.comercio_digital.comercio.repository.PedidoRepository;
import com.comercio_digital.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    // dependencia injetada automaticamente pelo autowired
    @Autowired
    private PedidoRepository repositorioPedido;

    // retorna todos os usuarios cadastrados
    public List<Pedido> findAll() {
        return repositorioPedido.findAll();
    }

    // endpoint pra buscar o usuario pelo id
    public Pedido buscaPeloId(Long id) {
        Optional<Pedido> obj = repositorioPedido.findById(id);
        return obj.get();

    }




}
