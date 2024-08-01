package br.hexagonal.acesso.api.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String senha;
    private Boolean administrador;

    @OneToOne  //1 - usuário(UsuarioEntity) tem uma pessoa
    @JoinColumn(name = "pessoa_id") //nome da tabela no BD
    private PessoaEntity pessoaEntity;
}
