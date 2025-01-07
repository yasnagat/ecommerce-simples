package com.comercio_digital.comercio.services;

import com.comercio_digital.comercio.entities.Usuario;
import com.comercio_digital.comercio.repository.UsuarioRepository;
import com.comercio_digital.comercio.resource.UsuarioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    // dependencia injetada automaticamente pelo autowired
    @Autowired
    private UsuarioRepository usuarioRepository;

    // retorna todos os usuarios cadastrados
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // endpoint pra buscar o usuario pelo id
    public Usuario buscaPeloId(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.get();

    }




}
