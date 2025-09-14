// package br.unitins.tp1.model.capacete;

// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonFormat.Shape;

// import br.unitins.tp1.validation.EntidadeNotFoundException;

// @JsonFormat(shape = Shape.OBJECT)
// public enum TipoCapacete {

//         MOTO(1, "Moto"), BIKE(2, "Bicicleta");

//     private final Integer id;
//     private final String label;

//     private TipoCapacete(Integer id, String label) {
//         this.id = id;
//         this.label = label;
//     }

//     public Integer getId() {
//         return id;
//     }

//     public String getLabel() {
//         return label;
//     }

//     public static TipoCapacete valueOf(Integer id) {
//         if (id.equals(null))
//             return null;
//         for (TipoCapacete tipo : values()) {
//             if (tipo.getId().equals(id))
//                 return tipo;
//         }

//         throw new EntidadeNotFoundException("idTipoCapacete", "Tipo de capacete não encontrado!");
//     }

// }