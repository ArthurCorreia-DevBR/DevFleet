package com.devfleet.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_oficinas")
public class Oficina {

    //Id gerado automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campo obrigatório,
    //Tamanho máximo -> 120.
    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    //Tamanho máximo -> 14,
    //Valor não pode ser repetido.
    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    //Tamanho máximo -> 20.
    @Column(name = "telefone", length = 20)
    private String telefone;

    //Tamanho máximo -> 150.
    @Column(name = "email", length = 150)
    private String email;

    //Tamanho máximo -> 200
    @Column(name = "endereco", length = 200)
    private String endereco;

}
