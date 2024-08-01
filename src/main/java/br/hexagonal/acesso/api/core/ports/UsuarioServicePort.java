package br.hexagonal.acesso.api.core.ports;

import br.hexagonal.acesso.api.adapter.dtos.UsuarioDto;
import br.hexagonal.acesso.api.core.domain.Usuario;

import java.util.List;

public interface UsuarioServicePort {

    Usuario createUsuario(Usuario usuario);


}


/**
 * Porta de entrada - aonde consta a logica da aplicação - contrato
 * As requisições que vem para dentro da aplicação
 */