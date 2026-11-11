package com.devfleet.fueling.entity;

import com.devfleet.fueling.enums.TipoCombustivel;
import com.devfleet.vehicle.entity.Veiculo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_abastecimentos")
public class Abastecimento {

    //Id gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Coluna obrigatória(não pode ser null)
    @Column(name = "data_hora_abastecimento", nullable = false)
    private LocalDateTime dataHoraAbastecimento;

    //Coluna obrigatória(não pode ser null)
    //EnumeratedType -> String para ser referenciado com String, não números.
    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    //Coluna obrigatória(não pode ser null)
    // máximo de digitos -> 10
    // Máximo de casas decimais -> 3
    @Column(name = "quantidade_litros", nullable = false, precision = 10, scale = 3)
    private BigDecimal quantidadeLitros;

    //Coluna obrigatória(não pode ser null)
    // máximo de digitos -> 10
    // Máximo de casas decimais -> 3
    @Column(name = "preco_por_litro", nullable = false, precision = 10, scale = 3)
    private BigDecimal precoPorLitro;

    //Coluna obrigatória(não pode ser null)
    @Column(name = "quilometragem", nullable = false)
    private Long quilometragem;

    //Máximo de caracteres -> 100
    @Column(name = "posto", length = 100)
    private String posto;

    //Relacionamento -> muitos pra um.
    //Optional -> false pois, o relacionamento é obrigatório.
    //JoinColumn -> Coluna utilizada para chave_estrangeira.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

}
