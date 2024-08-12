package br.hexagonal.acesso.api.adapter.repositories;

import br.hexagonal.acesso.api.adapter.entities.MoradorEntity;
import br.hexagonal.acesso.api.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {
    MoradorEntity findByCpf(String cpf);}
