package br.hexagonal.acesso.api.infra;

import br.hexagonal.acesso.api.core.ports.UsuarioRepositoryPort;
import br.hexagonal.acesso.api.core.ports.UsuarioServicePort;
import br.hexagonal.acesso.api.core.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UsuarioServicePort usuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort){
        return new UsuarioService(usuarioRepositoryPort);
    }

}

/**
 * Beans vai devolver as ports - UsuarioServicePort etc
 */