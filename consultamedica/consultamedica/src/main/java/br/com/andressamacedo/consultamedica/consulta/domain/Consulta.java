package br.com.andressamacedo.consultamedica.consulta.domain;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA") // Corrigido
    private Long idConsulta;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_CONSULTA") // Corrigido
    private String dataConsulta;

    @Column(name = "PROFISSIONAL")
    private String profissional;

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO") // Corrigido
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
