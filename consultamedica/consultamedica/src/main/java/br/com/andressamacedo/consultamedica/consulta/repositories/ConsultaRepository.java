package br.com.andressamacedo.consultamedica.consulta.repositories;

import br.com.andressamacedo.consultamedica.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
