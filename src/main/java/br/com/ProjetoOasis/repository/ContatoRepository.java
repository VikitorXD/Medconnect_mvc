package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
