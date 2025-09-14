package br.unitins.tp1.service.auth;

import br.unitins.tp1.model.usuario.Usuario;

public interface AuthService {

    void changeRole(Usuario usuario, Integer idPerfil);

}