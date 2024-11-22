package br.com.ProjetoOasis.repository;

import br.com.ProjetoOasis.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String nome);

}
