package br.unitins.tp1.repository;

import br.unitins.tp1.model.pedido.Estoque;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstoqueRepository implements PanacheRepository<Estoque> {

    // Vai dar buxa, pois cada empresa possui seu codigo de Estoque. Logo, precisamos
    // transformar esse código em unico, Adicionar id, nome , algo do tipo
    public Estoque findByCodigo(String codigo) {
        return find("codigo LIKE ?1", "%" + codigo + "%").firstResult();
    }

    /**
     * 
     * @param id
     * @return retorna o Capacete com o Estoque mais antigo e com quantidade em estoque
     *         (maior que 0)
     */

    public Estoque findByCapacete(Long idCapacete) {
        StringBuffer jpql = new StringBuffer();
        jpql.append("SELECT ");
        jpql.append(" l ");
        jpql.append(" FROM ");
        jpql.append(" Estoque l ");
        jpql.append(" WHERE ");
        jpql.append(" l.Capacete.id = ?1 ");
        jpql.append(" AND l.quantidade > 0 ");
        jpql.append(" ORDER BY l.dataFabricacao ");
        return find(jpql.toString(), idCapacete).firstResult();
    }

    // Esse método retorna o total em estoque de determinado Capacete
    public Integer findByIdCapaceteQtdeTotal(Long idCapacete) {
        Object result = find("SELECT SUM(l.quantidade) " +
                             "FROM Estoque l " +
                             "WHERE l.Capacete.id = ?1 " +
                             "AND l.quantidade > 0", idCapacete)
                        .firstResult();
        return result != null ? ((Number) result).intValue() : 0;
    }
    

}