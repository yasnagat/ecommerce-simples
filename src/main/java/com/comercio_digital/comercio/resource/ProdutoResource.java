package com.comercio_digital.comercio.resource;


import com.comercio_digital.comercio.entities.Produto;
import com.comercio_digital.comercio.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")

public class ProdutoResource {

    @Autowired
    private ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> Produtos = servico.findAll();
        return ResponseEntity.ok().body(Produtos);
    }

     // a requisicao aceita um id dentro da URL
    @GetMapping(value = "/{id}")

    // @PathVariable para o spring aceitar o id
    public ResponseEntity<Produto> buscaPeloId(@PathVariable Long id) {
        Produto obj = servico.buscaPeloId(id);
        return ResponseEntity.ok().body(obj);
    }
}
