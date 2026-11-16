package com.devfleet.driver.service;

import com.devfleet.driver.entity.Motorista;
import com.devfleet.driver.exception.*;
import com.devfleet.driver.repository.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    //Injeção de dependência
    private final MotoristaRepository repository;

    //Adicionar um motorista.
    public void addDriver(Motorista driver){
        if (repository.existsByCpf(driver.getCpf())){
            throw new CPFAlreadyExists("Este CPF já foi cadastrado");
        } else if (repository.existsByNumeroCnh(driver.getNumeroCnh())){
            throw new DriverLicenseNumberAlreadyExists("Número de CNH já registrado");
        } else {
            repository.saveAndFlush(driver);
        }
    }

    //Deletar um motorista.
    public void deleteDriver(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new NonExistentDriver("Motorista não encontrado");
        }
    }

    //Consultar Motorista
    public Motorista getMotorista(Long id){
        return repository.findById(id).orElseThrow(
                () -> new NonExistentDriver("Motorista não encontrado")
        );
    }


    //Atualizar Motorista
    public void attMotorista(Long id, Motorista newDriver) {
        Motorista antigo = repository.findById(id).orElseThrow(()
                -> new NonExistentDriver("Motorista não encontrado"));

        if (newDriver.getNumeroCnh() != null &&
                !newDriver.getNumeroCnh().equals(antigo.getNumeroCnh())) {
            throw new DifferentRegistrationNumberException(
                    "O número da CNH está divergindo do documento original"
            );
        } else if(newDriver.getCpf() != null){
            if (!newDriver.getCpf().equals(antigo.getCpf())){
            throw new CPFCannotBeChanged("O CPF não pode ser alterado");
            }
        }
            Motorista newUpdate = Motorista.builder()
                    .id(antigo.getId())
                    .nome(newDriver.getNome() != null ?
                            newDriver.getNome() : antigo.getNome())
                    .cpf(antigo.getCpf())
                    .categoriaCnh(newDriver.getCategoriaCnh() != null ?
                            newDriver.getCategoriaCnh() : antigo.getCategoriaCnh())
                    .validadeCnh(newDriver.getValidadeCnh() != null ?
                            newDriver.getValidadeCnh() : antigo.getValidadeCnh())
                    .status(newDriver.getStatus() != null ?
                            newDriver.getStatus() : antigo.getStatus())
                    .telefone(newDriver.getTelefone() != null ?
                            newDriver.getTelefone() : antigo.getTelefone())
                    .numeroCnh(antigo.getNumeroCnh())
                    .build();

            repository.saveAndFlush(newUpdate);

    }
}
