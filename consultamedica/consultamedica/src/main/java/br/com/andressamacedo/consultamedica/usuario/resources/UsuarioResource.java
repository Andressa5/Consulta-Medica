package br.com.andressamacedo.consultamedica.usuario.resources;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import br.com.andressamacedo.consultamedica.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNovo);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
