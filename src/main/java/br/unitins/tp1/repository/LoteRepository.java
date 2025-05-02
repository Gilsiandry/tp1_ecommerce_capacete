package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Lote;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

@ApplicationScoped
public class LoteRepository implements PanacheRepository<Lote> {



    public List<Lote> findByCodigo(String codigo) {
        return find("SELECT p FROM Lote p WHERE UPPER(p.codigo) LIKE ?1 ", "%" + codigo.toUpperCase() + "%").list();
    }

    public List<Lote> findByDataFabricacao(LocalDate dataFabricacao) {
    return find("SELECT p FROM Lote p WHERE p.dataFabricacao = ?1", dataFabricacao).list();
}

}