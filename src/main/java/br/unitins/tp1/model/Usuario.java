package br.unitins.tp1.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {
        @Column(unique = true)
        private String email;
        private String senha;

        @Enumerated(EnumType.STRING)
        private Perfil perfil;

        @OneToOne(cascade = CascadeType.ALL)
        private Pessoa pessoa;

        
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }

         public Perfil getPerfil() {
            return perfil;
        }
        public void setPerfil(Perfil perfil) {
            this.perfil = perfil;
        }

         public Pessoa getPessoa() {
            return pessoa;
        }
        public void setPessoa(Pessoa Pessoa) {
            this.pessoa = Pessoa;
        }
}