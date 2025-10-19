// package br.unitins.tp1.repository;

// import br.unitins.tp1.model.capacete.Fabricante;
// import io.quarkus.hibernate.orm.panache.PanacheRepository;
// import jakarta.enterprise.context.ApplicationScoped;

// public class FabricanteRepository implements PanacheRepository<Object><Fabricante> {

//     public Fabricante findByNome(String nome) {
//         return find("LOWER(nome) = ?1", nome.toLowerCase()).firstResult();
//     }
// }
