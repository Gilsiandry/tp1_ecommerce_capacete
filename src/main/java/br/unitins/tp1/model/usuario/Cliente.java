// package br.unitins.tp1.model.usuario;

// import java.util.List;

// import br.unitins.tp1.model.DefaultEntity;
// import br.unitins.tp1.model.capacete.Capacete;
// import br.unitins.tp1.model.pagamento.Cartao;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;

// @Entity
// public class Cliente extends DefaultEntity {

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "id_pessoaFisica", unique = true)
//     private PessoaFisica pessoaFisica;

//     @ManyToMany(fetch = FetchType.EAGER)
//     @JoinTable(name = "lista_desejo", joinColumns = @JoinColumn(name = "id_cliente"), inverseJoinColumns = @JoinColumn(name = "id_capacete"))
//     private List<Capacete> listaDesejos;

//     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//     @JoinColumn(name = "id_cliente")
//     private List<Cartao> cartoes;

//     public PessoaFisica getPessoaFisica() {
//         return pessoaFisica;
//     }

//     public void setPessoaFisica(PessoaFisica pessoaFisica) {
//         this.pessoaFisica = pessoaFisica;
//     }

//     public List<Capacete> getListaDesejos() {
//         return listaDesejos;
//     }

//     public void setListaDesejos(List<Capacete> listaDesejos) {
//         this.listaDesejos = listaDesejos;
//     }

//     public List<Cartao> getCartoes() {
//         return cartoes;
//     }

//     public void setCartoes(List<Cartao> cartoes) {
//         this.cartoes = cartoes;
//     }

// }