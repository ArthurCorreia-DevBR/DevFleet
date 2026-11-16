package com.devfleet.driver.repository;

import com.devfleet.driver.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    public boolean existsByCpf(String cpf);

    public boolean existsByNumeroCnh(String numeroCnh);

}
