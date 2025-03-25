package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

    public List<Produto> findByNome(String nome) {
        return find("SELECT p FROM Municipio p WHERE p.nome LIKE ?1 ", "%" + nome + "%").list();
    }

    public List<Produto> findByMarca(String marca) {
        return find("SELECT m FROM Municipio m WHERE m.marca LIKE ?1 ", "%" + marca + "%").list();
    }

    public List<Produto> findByModelo(String modelo) {
        return find("SELECT md FROM Municipio md WHERE md.modelo LIKE ?1 ", "%" + modelo + "%").list();
    }

    public List<Produto> findByCor(String cor) {
        return find("SELECT c FROM Municipio c WHERE c.cor LIKE ?1 ", "%" + cor + "%").list();
    }

    public List<Produto> findByTamanho(int tamanho) {
        return find("SELECT t FROM Municipio t WHERE t.tamanho LIKE ?1 ", "%" + tamanho + "%").list();
    }

   /* public List<Produto> findByPreco(Double preco) {
        return find("SELECT p FROM Municipio p WHERE p.preco LIKE ?1 ", "%" + preco + "%").list();
    } */

}