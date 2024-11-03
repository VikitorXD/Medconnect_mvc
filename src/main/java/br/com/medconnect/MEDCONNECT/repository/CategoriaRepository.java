package br.com.medconnect.MEDCONNECT.repository;

import br.com.medconnect.MEDCONNECT.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long > {
}

