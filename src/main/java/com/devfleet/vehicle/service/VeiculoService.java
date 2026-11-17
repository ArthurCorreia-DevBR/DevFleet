package com.devfleet.vehicle.service;

import com.devfleet.vehicle.entity.Veiculo;
import com.devfleet.vehicle.exceptions.VehicleAlreadyExistsException;
import com.devfleet.vehicle.exceptions.VehicleNotFound;
import com.devfleet.vehicle.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    public final VeiculoRepository veiculoRepository;

    //Adicionar um carro
    public void addCar(Veiculo veiculo){
        if (veiculoRepository.existsByPlaca(veiculo.getPlaca())){
            throw new VehicleAlreadyExistsException("Está placa já foi cadastrada");
        }
        veiculoRepository.saveAndFlush(veiculo);
    }


    //Consultar veiculo
    public Veiculo getVehicle(Long id){
        return veiculoRepository.findById(id).orElseThrow(() ->
                new VehicleNotFound("Veículo não encontrado"));
    }

    //Deletar veiculo.
    public void deleteVehicle(Long id){
        Veiculo veiculo = getVehicle(id);
        veiculoRepository.deleteById(veiculo.getId());
    }

    // Atualizar Veículo
    public void attVehicle(Long id, Veiculo veiculo) {

        // Consumindo informações do veículo antigo.
        Veiculo oldVehicle = veiculoRepository.findById(id).orElseThrow(() ->
                new VehicleNotFound("Veículo não encontrado"));

        // Define qual placa será utilizada na atualização.
        String placaAtualizada = veiculo.getPlaca() != null ?
                veiculo.getPlaca() : oldVehicle.getPlaca();

        // Valida se existe a mesma placa em outro veículo.
        if (veiculoRepository.existsByPlacaAndIdNot(
                placaAtualizada, oldVehicle.getId())) {

            throw new VehicleAlreadyExistsException(
                    "Esta placa já está cadastrada em outro veículo");
        }

        // Informações imutáveis:
        // marca
        // modelo
        // anoFabricacao
        // anoModelo

        // Montando o novo veículo com as novas informações.
        Veiculo newVehicle = Veiculo.builder()
                .id(oldVehicle.getId())
                .placa(placaAtualizada)
                .quilometragemAtual(veiculo.getQuilometragemAtual() != null ?
                        veiculo.getQuilometragemAtual() : oldVehicle.getQuilometragemAtual())
                .status(veiculo.getStatus() != null ?
                        veiculo.getStatus() : oldVehicle.getStatus())
                .marca(oldVehicle.getMarca())
                .modelo(oldVehicle.getModelo())
                .anoFabricacao(oldVehicle.getAnoFabricacao())
                .anoModelo(oldVehicle.getAnoModelo())
                .build();

        veiculoRepository.saveAndFlush(newVehicle);
    }


}
