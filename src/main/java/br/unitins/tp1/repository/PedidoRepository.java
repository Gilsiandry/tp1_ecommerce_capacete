package br.unitins.tp1.repository;

import br.unitins.tp1.model.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    public List<Pedido> findByUsuario(Long idUsuario) {
        return list("usuario.id = ?1", idUsuario);
    }

}