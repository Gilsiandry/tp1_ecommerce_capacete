package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Jugular;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JugularRepository implements PanacheRepository<Jugular> {

    public List<Jugular> findByTipoFechamento(String tipoFechamento) {
        return find("SELECT m FROM Jugular m WHERE m.tipoFechamento LIKE ?1 ", "%" + tipoFechamento + "%").list();
    }

    /*public List<Jugular> findByCapacete(Long idCapacete) {
        return find("SELECT m FROM Jugular m WHERE m.capacete.id = ?1", idCapacete).list();
    }*/

}