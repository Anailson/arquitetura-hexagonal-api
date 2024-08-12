package br.hexagonal.acesso.api.adapter.controllers;

import br.hexagonal.acesso.api.adapter.converters.UsuarioConverter;
import br.hexagonal.acesso.api.adapter.dtos.UsuarioDto;
import br.hexagonal.acesso.api.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor  //criar o construtor
public class UsuarioController {

    private final  UsuarioServicePort usuarioServicePort;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){
       return usuarioConverter
               .toDto(usuarioServicePort.createUsuario(usuarioConverter.toTomain(usuarioDto)));//convert objeto para domonio(domain)
    }


}
