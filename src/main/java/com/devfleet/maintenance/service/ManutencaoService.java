package com.devfleet.maintenance.service;

import com.devfleet.maintenance.entity.Manutencao;
import com.devfleet.maintenance.exceptions.MaintenanceNotFound;
import com.devfleet.maintenance.repository.ManutencaoRepository;
import com.devfleet.vehicle.exceptions.VehicleNotFound;
import com.devfleet.vehicle.repository.VeiculoRepository;
import com.devfleet.workshop.exceptions.WorkShopNotFound;
import com.devfleet.workshop.repository.OficinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManutencaoService {

    //Injeção de dependência
    private final ManutencaoRepository manutencaoRepository;

    private final VeiculoRepository veiculoRepository;

    private final OficinaRepository oficinaRepository;

    //Adicionar uma manutenção
    public void addManutencao(Manutencao manutencao){
        if (!veiculoRepository.existsById(manutencao.getVeiculo().getId())){
            throw new VehicleNotFound("Veiculo não encontrado");
        } else if (manutencao.getOficina() != null){
            if (!oficinaRepository.existsById(manutencao.getOficina().getId())){
                throw new WorkShopNotFound("Oficina não encontrada");
            }
        }
        manutencaoRepository.saveAndFlush(manutencao);
    }

    //Consultar manutenção
    public Manutencao getManutencao(Long id){
        return manutencaoRepository.findById(id).orElseThrow(() ->
                new MaintenanceNotFound("Manutenção não encontrada"));
    }

    //Deletar manutenção
    public void deleteManutencao(Long id){
        getManutencao(id);
        manutencaoRepository.deleteById(id);
    }

    //Atualizar manutenção
    public void updateManutencao(Long id, Manutencao manutencao){
        //Consumindo valor antigo
        Manutencao oldManutencao = manutencaoRepository.findById(id).orElseThrow(() ->
                new MaintenanceNotFound("Manutenção não encontrada"));

        //Builder
        Manutencao newManutencao = Manutencao.builder()
                .id(oldManutencao.getId())
                .custo(manutencao.getCusto() != null ?
                        manutencao.getCusto() : oldManutencao.getCusto())
                .dataAbertura(oldManutencao.getDataAbertura())
                .dataConclusao(manutencao.getDataConclusao() != null ?
                        manutencao.getDataConclusao() : oldManutencao.getDataConclusao())
                .descricao(manutencao.getDescricao() != null ?
                        manutencao.getDescricao() : oldManutencao.getDescricao())
                .oficina(oldManutencao.getOficina())
                .quilometragem(manutencao.getQuilometragem() != null ?
                        manutencao.getQuilometragem() : oldManutencao.getQuilometragem())
                .statusManutencao(manutencao.getStatusManutencao() != null ?
                        manutencao.getStatusManutencao() : oldManutencao.getStatusManutencao())
                .tipoManutencao(manutencao.getTipoManutencao() != null ?
                        manutencao.getTipoManutencao() : oldManutencao.getTipoManutencao())
                .veiculo(oldManutencao.getVeiculo())
                .build();

        manutencaoRepository.saveAndFlush(newManutencao);
    }
}
