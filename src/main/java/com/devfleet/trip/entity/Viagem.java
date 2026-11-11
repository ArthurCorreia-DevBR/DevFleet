package com.devfleet.trip.entity;

import com.devfleet.driver.entity.Motorista;
import com.devfleet.trip.enums.StatusViagem;
import com.devfleet.vehicle.entity.Veiculo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_viagens")
public class Viagem {

    //Id gerado automaticamente com o método IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campo obrigatório,
    //máximo de caracteres -> 150
    @Column(name = "origem", nullable = false, length = 150)
    private String origem;

    //Campo obrigatório,
    // máximo de caracteres -> 150
    @Column(name = "destino", nullable = false, length = 150)
    private String destino;

    //Campo obrigatório
    @Column(name = "data_hora_prevista_partida", nullable = false)
    private LocalDateTime dataHoraPrevistaPartida;

    @Column(name = "data_hora_partida")
    private LocalDateTime dataHoraPartida;

    //Campo obrigatório
    @Column(name = "previsao_chegada", nullable = false)
    private LocalDateTime previsaoChegada;

    @Column(name = "data_hora_chegada")
    private LocalDateTime dataHoraChegada;

    @Column(name = "quilometragem_inicial")
    private Long quilometragemInicial;

    @Column(name = "quilometragem_final")
    private Long quilometragemFinal;

    //Campo obrigatório.
    //Enumerando por String para que as opções sejam strings, não números.
    @Column(name = "status_viagem", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusViagem status;

    //ManyToOne -> Relacionamento de muitos pra um.
    //Relacionamento OBRIGATÓRIO.
    //Coluna chave_estrangeira -> motorista_id, não pode ser null.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    //ManyToOne -> Relacionamento de muitos pra um.
    //Relacionamento OBRIGATÓRIO.
    //Coluna chave_estrangeira -> veiculo_id, não pode ser null.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

}
