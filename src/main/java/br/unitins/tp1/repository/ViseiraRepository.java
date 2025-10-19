package br.unitins.tp1.repository;

import br.unitins.tp1.model.capacete.Viseira;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ViseiraRepository implements PanacheRepository<Viseira> {

    public Viseira findByMarca(String marca) {
        return find("LOWER(marca) = ?1", marca.toLowerCase()).firstResult();
    }
}