package com.devfleet.driver.service;

import com.devfleet.driver.entity.Motorista;
import com.devfleet.driver.repository.MotoristaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MotoristaServiceTest {

    @InjectMocks
    private MotoristaService motoristaService;

    @Mock
    private MotoristaRepository motoristaRepository;

    @Test
    void deveCadastrarMotoristaComSucesso() {

        // Arrange: preparar os dados
        Motorista motorista = Motorista.builder()
                .nome("Arthur")
                .cpf("12345678901")
                .numeroCnh("98765432109")
                .build();

        when(motoristaRepository.existsByCpf(motorista.getCpf()))
                .thenReturn(false);

        when(motoristaRepository.existsByNumeroCnh(motorista.getNumeroCnh()))
                .thenReturn(false);

        // Act: executar o método
        motoristaService.addDriver(motorista);

        // Assert: verificar o comportamento
        verify(motoristaRepository).saveAndFlush(motorista);
    }
}