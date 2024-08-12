package br.hexagonal.acesso.api.adapter.converters;

import br.hexagonal.acesso.api.adapter.dtos.MoradorDto;
import br.hexagonal.acesso.api.core.domain.Morador;
import br.hexagonal.acesso.api.core.domain.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class MoradorConverter {

       public Morador toTomain(MoradorDto moradorDto){
        return new Morador(moradorDto.getId(),
                moradorDto.getCpf(),
                moradorDto.getEndereco(),
                moradorDto.getCelular(),
                new Pessoa(null, moradorDto.getNome()));
    }

    public MoradorDto toDto(Morador morador){
        return new MoradorDto(morador.getId(),
                    morador.getPessoa().getNome(),
                    morador.getCpf(),
                    morador.getEndereco(),
                    morador.getCelular());
    }

}
//https://www.youtube.com/watch?v=9N35oeUS8bk 7min

