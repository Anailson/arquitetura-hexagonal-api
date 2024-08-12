package br.hexagonal.acesso.api.adapter.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_morador")
public class MoradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String cpf;
    private String endereco;
    private String celular;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoaEntity;
}
