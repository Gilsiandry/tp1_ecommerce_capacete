package br.unitins.tp1.repository.capacete;

import java.util.List;

import br.unitins.tp1.model.capacete.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public List<Marca> findByFabricante(Long idFabricante) {
        return list("fabricante.id = ?1", idFabricante);
    }
}