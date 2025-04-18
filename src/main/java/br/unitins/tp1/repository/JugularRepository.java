package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Jugular;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JugularRepository implements PanacheRepository<Jugular> {

 public List<Capacete> findByNome(String nome) {
        return find("SELECT p FROM Capacete p WHERE UPPER(p.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
        

}