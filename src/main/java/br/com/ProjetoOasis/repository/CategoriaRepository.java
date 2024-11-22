package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long > {
}

