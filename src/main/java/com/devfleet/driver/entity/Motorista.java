package com.devfleet.driver.entity;

import com.devfleet.driver.enums.StatusMotorista;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_motoristas")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "numero_cnh", nullable = false, unique = true, length = 11)
    private String numeroCnh;

    @Column(name = "categoria_cnh", nullable = false, length = 3)
    private String categoriaCnh;

    @Column(name = "validade_cnh", nullable = false)
    private LocalDate validadeCnh;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "status_motorista", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusMotorista status;

}
