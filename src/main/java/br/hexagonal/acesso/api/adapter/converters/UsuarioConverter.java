package br.hexagonal.acesso.api.adapter.converters;

import br.hexagonal.acesso.api.adapter.dtos.UsuarioDto;
import br.hexagonal.acesso.api.core.domain.Pessoa;
import br.hexagonal.acesso.api.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    //converte usuario para DTO para objeto de dominio(domain0
    public Usuario toTomain(UsuarioDto usuarioDto){
        return new Usuario(usuarioDto.getId(),
                usuarioDto.getEmail(),
                usuarioDto.getSenha(),
                usuarioDto.getAdministrador(),
        new Pessoa(null, usuarioDto.getNome()));
    }

    public UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(usuario.getId(),usuario.getPessoa().getNome(), usuario.getEmail(),usuario.getSenha(),usuario.getAdministrador());
    }

}

