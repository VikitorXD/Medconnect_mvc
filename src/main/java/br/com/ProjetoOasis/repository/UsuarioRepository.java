package br.com.ProjetoOasis.repository;


import br.com.ProjetoOasis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
