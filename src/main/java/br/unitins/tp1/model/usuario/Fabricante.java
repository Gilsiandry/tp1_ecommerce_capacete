package br.unitins.tp1.model.usuario;

import br.unitins.tp1.model.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Fabricante extends DefaultEntity {

    @OneToOne
    @JoinColumn(name = "id_pessoaJuridica", unique = true)
    private PessoaJuridica pessoaJuridica;

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

}
