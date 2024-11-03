package br.com.medconnect.MEDCONNECT.repository;

import br.com.medconnect.MEDCONNECT.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
