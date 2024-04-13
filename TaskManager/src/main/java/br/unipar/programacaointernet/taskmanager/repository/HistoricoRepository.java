package br.unipar.programacaointernet.taskmanager.repository;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

// Repository e DAO são a mesma coisa
// eles se comunicam com o banco de dados
public class HistoricoRepository {
    @PersistenceContext(unitName = "HibernateJava")
    private EntityManager em;

    public List<Historico> listar(){
        String jpql = "SELECT h FROM Historico h";
        return em.createQuery(jpql, Historico.class).getResultList();
    }

    public void cadastrar(Historico historico) throws Exception {
        try {
            em.persist(historico);
        } catch (Exception ex) {
            throw new Exception("Historico não pode ser cadastrado");
        }
    }
}
