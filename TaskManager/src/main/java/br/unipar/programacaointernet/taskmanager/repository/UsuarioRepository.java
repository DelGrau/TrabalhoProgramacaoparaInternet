package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class UsuarioRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Usuario> listar() {
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public void cadastrar(Usuario usuario) throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuário não pode ser cadastrado!");
        }
    }

    public void deletar(Usuario usuario) throws Exception {
        try {
            em.remove(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuário não pode ser deletado!");
        }
    }
}
