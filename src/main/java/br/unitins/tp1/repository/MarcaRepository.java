package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.capacete.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public List<Marca> findByNome(String nome){
        return find("select m from Marca m WHERE m.nome LIKE ?1" , "%" + nome + "%").list();
    }

    public List<Marca> findByModelo(String modelo){
        return find("select m from Marca m WHERE m.modelo LIKE ?1" , "%" + modelo + "%").list();
    }
}