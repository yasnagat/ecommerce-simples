package com.comercio_digital.comercio.services;

import com.comercio_digital.comercio.entities.Produto;
import com.comercio_digital.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    // dependencia injetada automaticamente pelo autowired
    @Autowired
    private ProdutoRepository repositorioProduto;

    // retorna todos os usuarios cadastrados
    public List<Produto> findAll() {
        return repositorioProduto.findAll();
    }

    // endpoint pra buscar o usuario pelo id
    public Produto buscaPeloId(Long id) {
        Optional<Produto> obj = repositorioProduto.findById(id);
        return obj.get();

    }




}
