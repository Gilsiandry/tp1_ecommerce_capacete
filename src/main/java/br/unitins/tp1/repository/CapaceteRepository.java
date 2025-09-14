package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.model.capacete.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CapaceteRepository implements PanacheRepository<Capacete> {

    public List<Capacete> findByNome(String nome) {
        return find("select c from Capacete w WHERE c.nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Capacete> findByCor(String cor) {
        return find("select c from Capacete w WHERE c.cor LIKE ?1", "%" + cor + "%").list();
    }

    public List<Capacete> findByTamanho(int tamanho) {
        return find("select c from Capacete w WHERE c.tamanho LIKE ?1", "%" + tamanho + "%").list();
    }

    public List<Capacete> findByPreco(Double preco) {
        return find("select c from Capacete c WHERE c.preco <= ?1 ", preco).list();
    }

    public List<Capacete> findByPrecoMinAndMax(Double precoMin, Double precoMax) {
        return find("preco BETWEEN ?1 AND ?2", precoMin, precoMax).list();
    }


    public List<Capacete> findByMarca(Marca marca) {
        return find("marcaCapacete = ?1", marca).list();
    }

    //Outra forma com Parameters With
    public List<Capacete> findByMarca(String marca) {
        String marcaFormat = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();
        return find("marca.nome LIKE :marca", Parameters.with("marca", "%" + marcaFormat + "%")).list();
    }

    public List<Capacete> findMostRatedCapacete() {
        return find("ORDER BY nota DESC").list();
    }

}