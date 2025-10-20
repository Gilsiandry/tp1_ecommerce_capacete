package br.unitins.tp1.repository.endereco;

import br.unitins.tp1.model.endereco.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

    @ApplicationScoped
    public class MunicipioRepository implements PanacheRepository<Municipio> {

    public PanacheQuery<Municipio> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<Municipio> findAll2() {
        return find("SELECT c FROM Municipio c ORDER BY c.nome ");
    }

}