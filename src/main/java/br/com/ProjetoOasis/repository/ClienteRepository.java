package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
