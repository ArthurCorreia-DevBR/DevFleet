package com.devfleet.vehicle.entity;

import com.devfleet.vehicle.enums.StatusVeiculo;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa", unique = true, length = 8, nullable = false)
    private String placa;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 60)
    private String modelo;

    @Column(name = "anoFabricacao", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "anoModelo", nullable = false)
    private Integer anoModelo;

    @Column(name = "quilometragemAtual", nullable = false)
    private Long quilometragemAtual;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

}
