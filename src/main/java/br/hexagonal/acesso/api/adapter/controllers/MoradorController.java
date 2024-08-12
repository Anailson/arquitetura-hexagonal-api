package br.hexagonal.acesso.api.adapter.controllers;

import br.hexagonal.acesso.api.adapter.converters.MoradorConverter;
import br.hexagonal.acesso.api.adapter.dtos.MoradorDto;
import br.hexagonal.acesso.api.core.domain.Morador;
import br.hexagonal.acesso.api.core.ports.MoradorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/moradores")
@RequiredArgsConstructor  //criar o construtor
public class MoradorController {

    private final MoradorServicePort moradorServicePort;
    private final MoradorConverter moradorConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDto create(@RequestBody MoradorDto moradorDto){
        Morador novoMorador = moradorServicePort.creatMorador(moradorConverter.toTomain(moradorDto));
        return moradorConverter.toDto(novoMorador);

    }
}

