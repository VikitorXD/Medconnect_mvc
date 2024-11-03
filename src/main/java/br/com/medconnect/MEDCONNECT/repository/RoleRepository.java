package br.com.medconnect.MEDCONNECT.repository;

import br.com.medconnect.MEDCONNECT.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String nome);

}
