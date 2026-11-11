package com.devfleet.trip.entity;

import com.devfleet.driver.entity.Motorista;
import com.devfleet.trip.enums.StatusViagem;
import com.devfleet.vehicle.entity.Veiculo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_viagens")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origem", nullable = false, length = 150)
    private String origem;

    @Column(name = "destino", nullable = false, length = 150)
    private String destino;

    @Column(name = "data_hora_prevista_partida", nullable = false)
    private LocalDateTime dataHoraPrevistaPartida;

    @Column(name = "data_hora_partida")
    private LocalDateTime dataHoraPartida;

    @Column(name = "previsao_chegada", nullable = false)
    private LocalDateTime previsaoChegada;

    @Column(name = "data_hora_chegada")
    private LocalDateTime dataHoraChegada;

    @Column(name = "quilometragem_inicial")
    private Long quilometragemInicial;

    @Column(name = "quilometragem_final")
    private Long quilometragemFinal;

    @Column(name = "status_viagem", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusViagem status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

}
