package br.unipar.programacaointernet.taskmanager.service;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.repository.HistoricoRepository;
import br.unipar.programacaointernet.taskmanager.repository.TaskRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

@Stateless
public class TaskService {
    @Inject
    private TaskRepository taskRepository;
    @Inject
    private HistoricoRepository historicoRepository;

    public List<Task> listar() {
        return taskRepository.listar();
    }

    public void cadastrar(Task task) throws Exception{
        if (task == null)
            throw new Exception("Task = null");
        else {
            Historico historico = new Historico();

            historico.setDescricao(task.getDescricao());
            historico.setData_alteracao(new Date());
            historico.setObservacao(task.getObservacao());
            historico.setPrioridade(task.getPrioridade().toString());
            historico.setStatus(task.isStatus());
            historico.setUsuario(task.getUsuario());
            historico.setTask(task);

            taskRepository.cadastrar(task);
            historicoRepository.cadastrar(historico);
        }
    }

    public void deletar(Task task) throws Exception{
        taskRepository.deletar(task);
    }
}
