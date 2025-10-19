// package br.unitins.tp1.repository;

// import br.unitins.tp1.model.pedido.Lote;
// import io.quarkus.hibernate.orm.panache.PanacheRepository;
// import jakarta.enterprise.context.ApplicationScoped;

// @ApplicationScoped
// public class LoteRepository implements PanacheRepository<Lote> {

//     public Lote findByCodigo(String codigo) {
//         return find("codigo LIKE ?1", "%" + codigo + "%").firstResult();
//     }

//     /**
//      @param id
//      @return retorna o capacete com o lote mais antigo e com a quantidade em estoque (maior que 0)
//      */

//     public Lote findByCapacete(Long idCapacete) {
//         StringBuffer jpql = new StringBuffer();
//         jpql.append("SELECT ");
//         jpql.append(" l ");
//         jpql.append(" FROM ");
//         jpql.append(" Lote l ");
//         jpql.append(" WHERE ");
//         jpql.append(" l.capacete.id = ?1 ");
//         jpql.append(" AND l.quantidade > 0 ");
//         jpql.append(" ORDER BY l.dataFabricacao ");
//         return find(jpql.toString(), idCapacete).firstResult();
//     }

//     // retorna o total em estoque de determinado capacete
//     public Integer findByIdCapaceteQtdeTotal(Long idCapacete) {
//         Object result = find("SELECT SUM(l.quantidade) " +
//                              "FROM Lote l " +
//                              "WHERE l.capacete.id = ?1 " +
//                              "AND l.quantidade > 0", idCapacete)
//                         .firstResult();
//         return result != null ? ((Number) result).intValue() : 0;
//     }
    

// //outra forma
//     public Lote findByCodigo(String codigo) {
//         return find("codigo", codigo).firstResult();
//     }

// }
    
