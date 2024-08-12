package br.hexagonal.acesso.api.core.ports;

import br.hexagonal.acesso.api.core.domain.Morador;


public interface MoradorServicePort {

    Morador creatMorador(Morador morador);

}


/**
 * Porta de entrada - aonde consta a logica da aplicação - contrato
 * As requisições que vem para dentro da aplicação
 */