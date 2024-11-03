package br.com.medconnect.MEDCONNECT.repository;

import br.com.medconnect.MEDCONNECT.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
