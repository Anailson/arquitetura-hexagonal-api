package br.hexagonal.acesso.api.core.ports;

import br.hexagonal.acesso.api.core.domain.Morador;


public interface MoradorRepositoryPort {

    public Morador create(Morador morador);

    public Morador obterByCpf(String cpf);

}



/**
 * Pra fazer recursos externos
 */
