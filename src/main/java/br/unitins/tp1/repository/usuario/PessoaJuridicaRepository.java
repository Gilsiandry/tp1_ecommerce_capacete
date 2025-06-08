package br.unitins.tp1.repository.usuario;

import java.util.List;

import br.unitins.tp1.model.PessoaJuridica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaJuridicaRepository implements PanacheRepository<PessoaJuridica> {

    public List<PessoaJuridica> findByNome(String nome) {
        return find("nome LIKE ?1 ", "%" + nome + "%").list();
    }

    public PessoaJuridica findByCnpj(String cnpj) {
        return find("cnpj = ?1 ", cnpj).firstResult();
    }

}