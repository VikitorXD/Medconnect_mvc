package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}