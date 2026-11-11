package com.devfleet.vehicle.entity;

import com.devfleet.vehicle.enums.StatusVeiculo;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    //Id gerado automaticamente.
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //Campo obrigatório.
    //Não pode ser repetido.
    //Tamanho máximo -> 8
    @Column(name = "placa", unique = true, length = 8, nullable = false)
    private String placa;

    //Campo obrigatório.
    //Tamanho máximo -> 50
    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    //Campo obrigatório.
    //Tamanho máximo -> 60
    @Column(name = "modelo", nullable = false, length = 60)
    private String modelo;

    //Campo obrigatório.
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    //Campo obrigatório.
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;

    //Campo obrigatório.
    @Column(name = "quilometragem_atual", nullable = false)
    private Long quilometragemAtual;

    //Campo obrigatório.
    //EnumeratedType -> String pois, será vinculado por String, não por número.
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

}
