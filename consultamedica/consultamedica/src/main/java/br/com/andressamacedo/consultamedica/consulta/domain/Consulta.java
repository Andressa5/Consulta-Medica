package br.com.andressamacedo.consultamedica.consulta.domain;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID CONSULTA")
    private Long idConsulta;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA CONSULTA")
    private String dataConsulta;
    @Column(name = "PROFISSIONAL")
    private String profissional;
    @Column(name = "ESPECIALIDADE")
    private String especialidade;
   @ManyToOne
   @JoinColumn(name = "id usuario")
    private Usuario usuario;

    public Consulta() {

    }
    public Consulta(Long idConsulta, String dataConsulta, String profissional, String especialidade, Usuario usuario) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.profissional = profissional;
        this.especialidade = especialidade;
        this.usuario = usuario;
    }




}
