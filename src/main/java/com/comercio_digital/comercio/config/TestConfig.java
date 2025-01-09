package com.comercio_digital.comercio.config;

import com.comercio_digital.comercio.entities.*;
import com.comercio_digital.comercio.enums.PedidoStatus;
import com.comercio_digital.comercio.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto prod1 = new Produto(null, "Oceano no fim do caminho", "Neil Gaiman", 39.90, "img");
        Produto prod2 = new Produto(null, "Samsung s23", "smartphone", 2500.00, "img");
        Produto prod3 = new Produto(null, "Zephyrus G14 ASUS", "notebook gamer", 15000.00, "img");
        Produto prod4 = new Produto(null, "Bem vindos à livraria hyunam-dong", "livro", 40.00, "img");


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // vamos relacionar os produtos às categorias - relacao manytomany
        prod1.getCategoria().add(cat2);
        prod2.getCategoria().add(cat1);
        prod3.getCategoria().add(cat3);
        prod4.getCategoria().add(cat2);

        // salvar as associações que fizemos em memoria
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));


        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Usuario u3 = new Usuario(null, "Olaf Green", "olaf@gmail.com", "0392121213", "123456");

        // Z ao final da data: UTC - greenwinch
        repositorioUsuario.saveAll(Arrays.asList(u1, u2, u3));
        Pedido p1 = new Pedido(null, Instant.parse("2024-01-02T09:12:03Z"), PedidoStatus.CANCELADO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2024-01-01T19:14:04Z"), PedidoStatus.PAGO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2024-01-02T12:20:02Z"), PedidoStatus.ENVIADO, u1);

        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

        ItemPedido itp1 = new ItemPedido(p1, prod1, 2, prod1.getPreco());
        ItemPedido itp2 = new ItemPedido(p1, prod3, 1, prod3.getPreco());
        ItemPedido itp3 = new ItemPedido(p2, prod3, 2, prod3.getPreco());
        ItemPedido itp4 = new ItemPedido(p3, prod4, 2, prod4.getPreco());


        itemPedidoRepository.saveAll(Arrays.asList(itp1, itp2, itp3, itp4));

        Pagamento pag1 = new Pagamento(null, Instant.parse("2024-01-01T19:14:04Z"), p2);
        p2.setPagamento(pag1);

        pedidoRepository.save(p2);


    }
}