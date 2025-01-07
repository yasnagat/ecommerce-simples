package com.comercio_digital.comercio.config;

import com.comercio_digital.comercio.entities.Categoria;
import com.comercio_digital.comercio.entities.Pedido;
import com.comercio_digital.comercio.entities.Produto;
import com.comercio_digital.comercio.entities.Usuario;
import com.comercio_digital.comercio.enums.PedidoStatus;
import com.comercio_digital.comercio.repository.CategoriaRepository;
import com.comercio_digital.comercio.repository.PedidoRepository;
import com.comercio_digital.comercio.repository.ProdutoRepository;
import com.comercio_digital.comercio.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto prod1 = new Produto(null, "Oceano no fim do caminho", "Neil Gaiman", 39.90, "img");
        Produto prod2 = new Produto(null, "Samsung s23", "smartphone", 2500.00, "img");
        Produto prod3 = new Produto(null, "Zephyrus G14 ASUS", "notebook gamer", 15000.00, "img");

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Usuario u3 = new Usuario(null, "Olaf Green", "olaf@gmail.com", "0392121213", "123456");

        // Z ao final da data: UTC - greenwinch
        Pedido p1 = new Pedido(null, Instant.parse("2024-01-02T09:12:03Z"), PedidoStatus.CANCELADO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2024-01-01T19:14:04Z"), PedidoStatus.PAGO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2024-01-02T12:20:02Z"), PedidoStatus.ENVIADO, u1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        repositorioUsuario.saveAll(Arrays.asList(u1, u2, u3));

        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));




    }
}