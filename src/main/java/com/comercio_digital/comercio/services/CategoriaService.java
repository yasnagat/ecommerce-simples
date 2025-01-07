package com.comercio_digital.comercio.services;

import com.comercio_digital.comercio.entities.Categoria;
import com.comercio_digital.comercio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    // dependencia injetada automaticamente pelo autowired
    @Autowired
    private CategoriaRepository repositorioCategoria;

    // retorna todos os usuarios cadastrados
    public List<Categoria> findAll() {
        return repositorioCategoria.findAll();
    }

    // endpoint pra buscar o usuario pelo id
    public Categoria buscaPeloId(Long id) {
        Optional<Categoria> obj = repositorioCategoria.findById(id);
        return obj.get();

    }




}
