package com.comercio_digital.comercio.repository;

import com.comercio_digital.comercio.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// a anotacao repository é opcional, porque a nossa interface já extende o componente do JpaRepository
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
