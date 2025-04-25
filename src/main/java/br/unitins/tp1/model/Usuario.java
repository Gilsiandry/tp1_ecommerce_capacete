package br.unitins.tp1.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity {
        @Column(unique = true)
        private String email;
        private String senha;
        private Perfil perfil;
        private TipoPessoa tipoPessoa;

        
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

         public TipoPessoa getTipoPessoa() {
            return tipoPessoa;
        }
        public void setTipoPessoa(TipoPessoa tipoPessoa) {
            this.tipoPessoa = tipoPessoa;
        }
}