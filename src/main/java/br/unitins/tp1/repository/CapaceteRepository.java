package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Capacete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CapaceteRepository implements PanacheRepository<Capacete> {

// return find("SELECT e FROM Estado e WHERE e.sigla = ?1 ", sigla).firstResult();


    public List<Capacete> findByNome(String nome) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Capacete> findByMarca(String marca) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.marca) LIKE ?1 ", "%" + marca.toUpperCase() + "%").list();
    }

    public List<Capacete> findByCategoria(String categoria) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.categoria) LIKE ?1 ", "%" + categoria.toUpperCase() + "%").list();
    }

    public List<Capacete> findByModelo(String modelo) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.modelo) LIKE ?1 ", "%" + modelo.toUpperCase() + "%").list();
    }

    public List<Capacete> findByCor(String cor) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.cor) LIKE ?1 ", "%" + cor.toUpperCase() + "%").list();
    }

    public List<Capacete> findByTamanho(int tamanho) {
        return find("SELECT p FROM Capacete p WHERE p.tamanho LIKE ?1 ", "%" + tamanho + "%").list();
    }

   /* public List<Capacete> findByPreco(Double preco) {
        return find("SELECT p FROM Capacete p WHERE p.preco LIKE ?1 ", "%" + preco + "%").list();
    } */

}