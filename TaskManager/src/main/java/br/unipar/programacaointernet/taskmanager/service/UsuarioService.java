package br.unipar.programacaointernet.taskmanager.service;

import br.unipar.programacaointernet.taskmanager.model.Usuario;
import br.unipar.programacaointernet.taskmanager.repository.UsuarioRepository;
import jakarta.inject.Inject;

import java.util.List;

public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    public void cadastrar(Usuario usuario) throws Exception{
        usuarioRepository.cadastrar(usuario);
    }

    public void deletar(Usuario usuario) throws Exception {
        usuarioRepository.deletar(usuario);
    }

    public void update(Usuario usuario) throws Exception {

        Usuario oldUsuario = usuarioRepository.getUserById(usuario.getId());

        if (usuario.getNome() == null) {
            usuario.setNome(oldUsuario.getNome());
        }

        if (usuario.getCargo() == null) {
            usuario.setCargo(oldUsuario.getCargo());
        }

        usuarioRepository.update(usuario);
    }
}
