package br.hexagonal.acesso.api.adapter.repositories;

import br.hexagonal.acesso.api.adapter.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long > {
}

