package com.comercio_digital.comercio.resource;


import com.comercio_digital.comercio.entities.Categoria;
import com.comercio_digital.comercio.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")

public class CategoriaResource {

    @Autowired
    private CategoriaService servico;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> Categorias = servico.findAll();
        return ResponseEntity.ok().body(Categorias);
    }

     // a requisicao aceita um id dentro da URL
    @GetMapping(value = "/{id}")

    // @PathVariable para o spring aceitar o id
    public ResponseEntity<Categoria> buscaPeloId(@PathVariable Long id) {
        Categoria obj = servico.buscaPeloId(id);
        return ResponseEntity.ok().body(obj);
    }
}
