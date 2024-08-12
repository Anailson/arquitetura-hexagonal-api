package br.hexagonal.acesso.api.core.services;


import br.hexagonal.acesso.api.core.domain.Morador;
import br.hexagonal.acesso.api.core.ports.MoradorRepositoryPort;
import br.hexagonal.acesso.api.core.ports.MoradorServicePort;


public class MoradorService implements MoradorServicePort {

    private final MoradorRepositoryPort moradorRepositoryPort;

    public MoradorService(MoradorRepositoryPort moradorRepositoryPort) {
        this.moradorRepositoryPort = moradorRepositoryPort;
    }

    @Override
    public Morador creatMorador(Morador morador) {
        return moradorRepositoryPort.create(morador);
    }
}
