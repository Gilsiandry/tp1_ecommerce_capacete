package br.unitins.tp1.repository;

import br.unitins.tp1.model.pagamento.DadosCartao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DadosCartaoRepository implements PanacheRepository<DadosCartao> {
    
}