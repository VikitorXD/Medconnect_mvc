package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
