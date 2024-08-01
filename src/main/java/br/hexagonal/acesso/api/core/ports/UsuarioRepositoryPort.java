package br.hexagonal.acesso.api.core.ports;

import br.hexagonal.acesso.api.core.domain.Usuario;


public interface UsuarioRepositoryPort {

    public Usuario create(Usuario usuario);

    public Usuario obterByEmail(String email);

}



/**
 * Pra fazer recursos externos
 */
