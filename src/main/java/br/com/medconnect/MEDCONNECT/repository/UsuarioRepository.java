package br.com.medconnect.MEDCONNECT.repository;


import br.com.medconnect.MEDCONNECT.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
