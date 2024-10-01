package br.com.andressamacedo.consultamedica.usuario.repositories;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
