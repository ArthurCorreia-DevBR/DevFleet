package com.devfleet.fueling.entity;

import com.devfleet.fueling.enums.TipoCombustivel;
import com.devfleet.vehicle.entity.Veiculo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_abastecimentos")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_abastecimento", nullable = false)
    private LocalDateTime dataHoraAbastecimento;

    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "quantidade_litros", nullable = false, precision = 10, scale = 3)
    private BigDecimal quantidadeLitros;

    @Column(name = "preco_por_litro", nullable = false, precision = 10, scale = 3)
    private BigDecimal precoPorLitro;

    @Column(name = "quilometragem", nullable = false)
    private Long quilometragem;

    @Column(name = "posto", length = 100)
    private String posto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

}
