package br.hexagonal.acesso.api.infra;

import br.hexagonal.acesso.api.core.ports.MoradorRepositoryPort;
import br.hexagonal.acesso.api.core.ports.MoradorServicePort;
import br.hexagonal.acesso.api.core.ports.UsuarioRepositoryPort;
import br.hexagonal.acesso.api.core.ports.UsuarioServicePort;
import br.hexagonal.acesso.api.core.services.MoradorService;
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

    @Bean
    public MoradorServicePort moradorServiceImpl(MoradorRepositoryPort moradorRepositoryPort){
        return new MoradorService(moradorRepositoryPort);
    }

}

/**  https://www.youtube.com/watch?v=9N35oeUS8bk   min23
 * Beans vai devolver as ports - UsuarioServicePort etc
 */