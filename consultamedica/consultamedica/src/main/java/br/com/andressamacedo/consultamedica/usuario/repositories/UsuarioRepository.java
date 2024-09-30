package br.com.andressamacedo.consultamedica.usuario.repositories;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
