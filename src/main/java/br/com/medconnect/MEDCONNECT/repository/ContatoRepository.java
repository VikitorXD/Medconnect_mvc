package br.com.medconnect.MEDCONNECT.repository;

import br.com.medconnect.MEDCONNECT.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
