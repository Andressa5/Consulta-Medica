package br.com.andressamacedo.consultamedica.usuario.services;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import br.com.andressamacedo.consultamedica.usuario.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Jair");

        // Mock behavior
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Execute the method to be tested
        var result = usuarioService.cadastrarUsuario(usuario);

        // Validation
        assertNotNull(result);
        assertEquals("Jair", result.getNomeUsuario()); // Fix the expected value

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void listarUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Aarys");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Edgar");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);


        when(usuarioRepository.findAll()).thenReturn(usuarios);


        var resulta = usuarioService.listarUsuarios();


        assertAll(
                () -> assertNotNull(resulta),
                () -> assertEquals(2, resulta.size()),
                () -> assertEquals("fernandinho B", resulta.get(0).getNomeUsuario()), // Fix expected value
                () -> assertEquals("Edgar", resulta.get(1).getNomeUsuario())  // Fix expected value
        );
    }

    @Test
    void buscarUsuario() {
        Usuario user = new Usuario();
        user.setIdUsuario(1L); // Ensure the ID is set
        user.setNomeUsuario("Luis");

        // Mock behavior
        when(usuarioRepository.findById(user.getIdUsuario())).thenReturn(Optional.of(user));

        // Execute the method to be tested
        var resultado = usuarioService.buscarUsuario(user.getIdUsuario());

        // Validation
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Luis", resultado.getNomeUsuario()) // Fix expected value
        );
    }

    @Test
    void deletarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L); // Set the ID correctly
        usuario.setNomeUsuario("Fabio");


        when(usuarioRepository.findById(usuario.getIdUsuario())).thenReturn(Optional.of(usuario));


        usuarioService.deletarUsuario(usuario.getIdUsuario());


        verify(usuarioRepository, times(1)).deleteById(usuario.getIdUsuario());
    }
}
