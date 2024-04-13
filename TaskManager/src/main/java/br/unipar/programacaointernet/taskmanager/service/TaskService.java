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
            taskRepository.cadastrar(task);
            gravarHistorico(task);
        }
    }

    public void deletar(Task task) throws Exception{
        taskRepository.deletar(task);
    }

    public void update(Task task) throws Exception{

        Task oldTask = taskRepository.getTaskByID(task.getId());

        if (task.getDescricao() == null) {
            task.setDescricao(oldTask.getDescricao());
        }

        if (task.getObservacao() == null) {
            task.setObservacao(oldTask.getObservacao());
        }

        if (task.getPrioridade() == null) {
            task.setPrioridade(oldTask.getPrioridade());
        }

        if (task.getUsuario() == null) {
            task.setUsuario(oldTask.getUsuario());
        }

        if (task.isStatus() != oldTask.isStatus()) {
            task.setStatus(oldTask.isStatus());
        }

        taskRepository.editar(task);
        gravarHistorico(task);
    }

    private void gravarHistorico(Task task) throws Exception{
        Historico historico = new Historico();

        historico.setDescricao(task.getDescricao());
        historico.setData_alteracao(new Date());
        historico.setObservacao(task.getObservacao());
        historico.setPrioridade(task.getPrioridade().toString());
        historico.setStatus(task.isStatus());
        historico.setUsuario(task.getUsuario());
        historico.setTask(task);

        historicoRepository.cadastrar(historico);
    }
}
