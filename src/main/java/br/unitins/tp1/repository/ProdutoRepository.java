package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

// return find("SELECT e FROM Estado e WHERE e.sigla = ?1 ", sigla).firstResult();


    public List<Produto> findByNome(String nome) {
        return find("SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Produto> findByMarca(String marca) {
        return find("SELECT p FROM Produto p WHERE UPPER(p.marca) LIKE ?1 ", "%" + marca.toUpperCase() + "%").list();
    }

    public List<Produto> findByModelo(String modelo) {
        return find("SELECT p FROM Produto p WHERE UPPER(p.modelo) LIKE ?1 ", "%" + modelo.toUpperCase() + "%").list();
    }

    public List<Produto> findByCor(String cor) {
        return find("SELECT p FROM Produto p WHERE UPPER(p.cor) LIKE ?1 ", "%" + cor.toUpperCase() + "%").list();
    }

    public List<Produto> findByTamanho(int tamanho) {
        return find("SELECT p FROM Produto p WHERE p.tamanho LIKE ?1 ", "%" + tamanho + "%").list();
    }

   /* public List<Produto> findByPreco(Double preco) {
        return find("SELECT p FROM Produto p WHERE p.preco LIKE ?1 ", "%" + preco + "%").list();
    } */

}