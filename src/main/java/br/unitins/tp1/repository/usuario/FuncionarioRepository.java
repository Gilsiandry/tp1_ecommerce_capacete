package br.unitins.tp1.repository.usuario;

import java.util.List;

import br.unitins.tp1.model.usuario.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {

    public List<Funcionario> findFuncionarioByNome(String nome) {
        return find("pessoaFisica.nome LIKE ?1", "%" + nome + "%").list();
    }

    public Funcionario findFuncionarioByUsername(String username) {
        return find("pessoaFisica.usuario.username = ?1 ", username).firstResult();
    }

    public Funcionario findFuncionarioByCpf(String cpf) {
        return find("pessoaFisica.cpf = ?1 ", cpf).firstResult();
    }

    public Funcionario findFuncionarioByEmail(String email) {
        return find("pessoaFisica.email = ?1 ", email).firstResult();
    }

    public Funcionario existsByPessoaFisica(Long idPessoaFisica) {
        return find("pessoaFisica.id = ?1", idPessoaFisica).firstResult();
    }

    
}