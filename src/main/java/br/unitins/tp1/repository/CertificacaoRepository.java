package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Certificacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CertificacaoRepository implements PanacheRepository<Certificacao> {



    public List<Certificacao> findByNome(String nome) {
        return find("SELECT p FROM Certificacao p WHERE UPPER(p.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Certificacao> findByPais(String pais) {
        return find("SELECT p FROM Certificacao p WHERE UPPER(p.pais) LIKE ?1 ", "%" + pais.toUpperCase() + "%").list();
    }

    public List<Certificacao> findByDescricao(String descricao) {
        return find("SELECT p FROM Certificacao p WHERE UPPER(p.descricao) LIKE ?1 ", "%" + descricao.toUpperCase() + "%").list();
    }
}