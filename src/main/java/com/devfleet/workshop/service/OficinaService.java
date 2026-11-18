package com.devfleet.workshop.service;

import com.devfleet.workshop.entity.Oficina;
import com.devfleet.workshop.exceptions.*;
import com.devfleet.workshop.repository.OficinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OficinaService {

    //Injeção de dependencia.
    private final OficinaRepository oficinaRepository;

    //Adicionando uma oficina.
    public void addOficina(Oficina oficina){
        //CNPJ já cadastrado
        if (oficinaRepository.existsByCnpj(oficina.getCnpj())){
            throw new CNPJAlreadyRegistered("Este CNPJ já foi utilizado");
        }
        //Campo "nome" vazio
        else if (oficina.getNome() == null) {
            throw new NameRequired("O campo 'nome' deve ser informado");
        }
        //Nome com mais de 120 caracteres
        else if (oficina.getNome().length() > 120){
            throw new NameTooLong("O campo 'nome' não pode ultrapassar 120 caracteres");
        }
        //Ou Email ou telefone obrigatórios
        else if (oficina.getEmail() == null && oficina.getTelefone() == null){
            throw new PhoneOrEmailRequire("Você deve escolher entre telefone e e-mail");
        }

        oficinaRepository.saveAndFlush(oficina);
    }

    //Consultar Oficina
    public Oficina getOficina(Long id){
        return oficinaRepository.findById(id).orElseThrow(() ->
                new WorkShopNotFound("Oficina não encontrada"));
    }

    //Deletar Oficina
    public void deleteOficina(Long id){
        getOficina(id);
        oficinaRepository.deleteById(id);
    }

    //Atualizar Oficina
    public void updateOficina(Long id, Oficina oficina){

        //Consumindo oficina antiga.
        Oficina oldOficina = oficinaRepository.findById(id).orElseThrow(() ->
                new WorkShopNotFound("Oficina não encontrada"));

        //Atualizando Oficina.
        //CNPJ imutável;
        Oficina newOficina = Oficina.builder()
                .id(oldOficina.getId())
                .email(oficina.getEmail() != null ?
                        oficina.getEmail() : oldOficina.getEmail())
                .endereco(oficina.getEndereco() != null ?
                        oficina.getEndereco() : oldOficina.getEndereco())
                .nome(oficina.getNome() != null ?
                        oficina.getNome() : oldOficina.getNome())
                .telefone(oficina.getTelefone() != null ?
                        oficina.getTelefone() : oldOficina.getTelefone())
                .cnpj(oldOficina.getCnpj())
                .build();

        oficinaRepository.saveAndFlush(newOficina);

    }

}
