package com.devfleet.driver.entity;

import com.devfleet.driver.enums.StatusMotorista;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_motoristas")
public class Motorista {

    //Id gerado automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campo obrigatório.
    //Tamanho máximo -> 100
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    //Campo obrigatório.
    //Tamanho máximo -> 11
    //Não pode ser repetido.
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    //Campo obrigatório.
    //Tamanho máximo -> 11
    //Não pode ser repetido.
    @Column(name = "numero_cnh", nullable = false, unique = true, length = 11)
    private String numeroCnh;

    //Campo obrigatório.
    //Tamanho máximo -> 3
    @Column(name = "categoria_cnh", nullable = false, length = 3)
    private String categoriaCnh;

    //Campo obrigatório.
    @Column(name = "validade_cnh", nullable = false)
    private LocalDate validadeCnh;

    //Tamanho máximo -> 20
    @Column(name = "telefone", length = 20)
    private String telefone;

    //Campo obrigatório.
    //EnumeratedType -> String pois, será referenciado por String, não número.
    @Column(name = "status_motorista", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusMotorista status;

}
