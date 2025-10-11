package br.unitins.tp1.repository.endereco;

import br.unitins.tp1.model.endereco.Estado;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

    @ApplicationScoped
    public class EstadoRepository implements PanacheRepository<Estado> {

  
    public Estado findBySigla(String sigla) {
        return find("SELECT e FROM Estado e WHERE e.sigla = ?1 ", sigla).firstResult();
    }

    public PanacheQuery<Estado> findByNome(String nome) {
        return find("SELECT e FROM Estado e WHERE e.nome LIKE ?1 ", "%"+nome+"%");
    }

    @Override
    public PanacheQuery<Estado> findAll() {
       return find("SELECT e FROM Estado e ORDER BY e.nome");
    }

}