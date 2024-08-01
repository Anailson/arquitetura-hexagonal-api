package br.hexagonal.acesso.api.core.services;

import br.hexagonal.acesso.api.core.domain.Usuario;
import br.hexagonal.acesso.api.core.ports.UsuarioRepositoryPort;
import br.hexagonal.acesso.api.core.ports.UsuarioServicePort;


public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;  //chamar o contrato que consta a implementação

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositoryPort.obterByEmail((usuario.getEmail()));
        if (usuarioExistente != null){
            throw new IllegalArgumentException("Usuário já existe!");
        }
        return usuarioRepositoryPort.create(usuario);
    }


}
