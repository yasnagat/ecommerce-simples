package com.comercio_digital.comercio.repository;

import com.comercio_digital.comercio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// a anotacao repository é opcional, porque a nossa interface já extende o componente do JpaRepository
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
