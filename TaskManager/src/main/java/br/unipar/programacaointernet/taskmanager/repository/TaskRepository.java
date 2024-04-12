package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class TaskRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Task> listar(){
        String jpql = "SELECT t FROM Task t";
        return em.createQuery(jpql, Task.class).getResultList();
    }

    public void cadastrar(Task task) throws Exception {
        try {
            em.persist(task);
        } catch (Exception ex) {
            throw new Exception("Task não pode ser cadastrada");
        }
    }

    public void deletar(Task task) throws Exception {
        try {
            em.remove(task);
        } catch (Exception ex) {
            throw new Exception("Task não pode ser deletada");
        }
    }

    public void editar(Task task) throws Exception {
        try {

        } catch (Exception ex){
            throw new Exception("Task não pode ser atualizada!");
        }
    }
}
