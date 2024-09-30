package br.com.andressamacedo.consultamedica.usuario.resources;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import br.com.andressamacedo.consultamedica.usuario.repositories.UsuarioRepository;
import br.com.andressamacedo.consultamedica.usuario.services.UsuarioService;
import org.hibernate.ObjectNotFoundException;
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
    public ResponseEntity<List<Usuario>> listarClientes() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("teste");
        return ResponseEntity.ok().body(usuarios);
    }

//    public Usuario atualizarUsuario(Usuario usuario) {
//        if(usuario.getIdUsuario()==null){
//            throw new RuntimeException("Usuario sem ID");
//        }
//        return usuarioRepository.save(usuario);
//    }
//
//    public Usuario buscarUsuario(Long id) {
//        return usuarioRepository.findById(id).orElseThrow(
//                () -> new ObjectNotFoundException("Usuário não encontrado:", id)
//        );
//    }
//
//    public void deletarUsuario(Long id) {
//        usuarioRepository.deleteById(id);
//    }
}