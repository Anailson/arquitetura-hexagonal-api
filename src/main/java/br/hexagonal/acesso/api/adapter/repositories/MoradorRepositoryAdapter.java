package br.hexagonal.acesso.api.adapter.repositories;

import br.hexagonal.acesso.api.adapter.entities.MoradorEntity;
import br.hexagonal.acesso.api.adapter.entities.UsuarioEntity;
import br.hexagonal.acesso.api.core.domain.Morador;
import br.hexagonal.acesso.api.core.ports.MoradorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoradorRepositoryAdapter implements MoradorRepositoryPort {

    private final MoradorRepository moradorRepository;
    private final ModelMapper modelMapper;
    private final PessoaRepositoryAdapter pessoaRepository;


    @Override
    public Morador create(Morador morador) {

        UsuarioEntity moradorByCpf = moradorRepository.findByCpf(morador.getCpf());

        if(moradorByCpf != null){
            throw  new IllegalArgumentException(("Morador já existe"));
        }

        MoradorEntity entity = modelMapper.map(morador, MoradorEntity.class);
        entity.setPessoaEntity(pessoaRepository.createPessoa(morador.getPessoa()));
        MoradorEntity novoMorador = moradorRepository.save(entity);
        return modelMapper.map(novoMorador, Morador.class);
    }

    @Override
    public Morador obterByCpf(String cpf) {
        return null;
    }

}
//https://www.youtube.com/watch?v=9N35oeUS8bk&t=1371s 29m

/**
 * mapper - Mapeadores para converter entre entidades de domínio e DTOs
 */
