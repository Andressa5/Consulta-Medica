package br.com.andressamacedo.consultamedica.usuario.services;

import br.com.andressamacedo.consultamedica.usuario.domain.Usuario;
import br.com.andressamacedo.consultamedica.usuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario( Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

public Usuario buscarUsuario(Long id) {
    return usuarioRepository.findById(id).orElseThrow(
    );
}
public List<Usuario> listarUsuarios(){
    return usuarioRepository.findAll();
}
public void deletarUsuario(Long id){
    Usuario usuario = buscarUsuario(id);
    usuarioRepository.delete(usuario);
}
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario upUsuario = buscarUsuario(id);
        upUsuario.setNomeUsuario(usuario.getNomeUsuario());
        upUsuario.setEmail(usuario.getEmail());
        upUsuario.setTelefone(usuario.getTelefone());
        upUsuario.setDataNascimento(usuario.getDataNascimento());
        upUsuario.setPermissao(usuario.getPermissao());
        return usuarioRepository.save(upUsuario);
}
}