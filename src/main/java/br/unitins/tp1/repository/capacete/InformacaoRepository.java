package br.unitins.tp1.repository.capacete;

import java.util.List;

import br.unitins.tp1.model.Informacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InformacaoRepository implements PanacheRepository<Informacao> {



    public List<Informacao> findByDescricao(String descricao) {
        return find("SELECT p FROM Informacao p WHERE UPPER(p.descricao) LIKE ?1 ", "%" + descricao.toUpperCase() + "%").list();
    }

    public List<Informacao> findByAnoLancamento(Integer anoLancamento) {
        return find("SELECT p FROM Informacao WHERE p.tamanho LIKE ?1 ", anoLancamento).list();
    }
}