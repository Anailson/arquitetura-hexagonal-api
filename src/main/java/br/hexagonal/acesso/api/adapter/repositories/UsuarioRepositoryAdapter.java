package br.hexagonal.acesso.api.adapter.repositories;

import br.hexagonal.acesso.api.adapter.entities.PessoaEntity;
import br.hexagonal.acesso.api.adapter.entities.UsuarioEntity;
import br.hexagonal.acesso.api.core.domain.Pessoa;
import br.hexagonal.acesso.api.core.domain.Usuario;
import br.hexagonal.acesso.api.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PessoaRepositoryAdapter pessoaRepository;
    @Override
    public Usuario create(Usuario usuario) {

        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setPessoaEntity(pessoaRepository.createPessoa(usuario.getPessoa()));
        UsuarioEntity novoUsuario = usuarioRepository.save(usuarioEntity);
        return modelMapper.map(novoUsuario, Usuario.class);
    }

    @Override
    public Usuario obterByEmail(String email) {

        UsuarioEntity usuarioByEmail = usuarioRepository
                .findByEmail(email);
        if(usuarioByEmail == null){
            return null;
        }
         return modelMapper.map(usuarioByEmail, Usuario.class);
    }


}


/**
 * mapper - Mapeadores para converter entre entidades de domínio e DTOs
 */
