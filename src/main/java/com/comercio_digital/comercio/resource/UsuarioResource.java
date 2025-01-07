package com.comercio_digital.comercio.resource;


import com.comercio_digital.comercio.entities.Usuario;
import com.comercio_digital.comercio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")

public class UsuarioResource {

    @Autowired
    private UsuarioService servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = servico.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

     // a requisicao aceita um id dentro da URL
    @GetMapping(value = "/{id}")

    // @PathVariable para o spring aceitar o id
    public ResponseEntity<Usuario> buscaPeloId(@PathVariable Long id) {
        Usuario obj = servico.buscaPeloId(id);
        return ResponseEntity.ok().body(obj);
    }
}
