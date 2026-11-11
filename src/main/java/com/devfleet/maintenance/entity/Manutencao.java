package com.devfleet.maintenance.entity;

import com.devfleet.maintenance.enums.StatusManutencao;
import com.devfleet.maintenance.enums.TipoManutencao;
import com.devfleet.vehicle.entity.Veiculo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_manutencoes")
public class Manutencao {

    //Id criado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Campo obrigatório,
    //Tamanho máximo -> 255
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    //Campo obrigatório,
    //EnumeratedType -> String pois, sera referenciado pela String, não pelo número.
    @Column(name = "tipo_manutencao", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoManutencao tipoManutencao;

    //Campo obrigatório,
    //EnumeratedType -> String pois, sera referenciado pela String, não pelo número.
    @Column(name = "status_manutencao", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusManutencao statusManutencao;

    //Campo obrigatório
    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    //Campo obrigatório
    @Column(name = "quilometragem", nullable = false)
    private Long quilometragem;

    @Column(name = "custo", precision = 12, scale = 2)
    private BigDecimal custo;

    //ManyToOne -> um veiculo pode receber várias manutenções.
    //Relação obrigatória na criação da entidade.
    //JoinColumn -> chave estrangeira, obrigatória.
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

}
