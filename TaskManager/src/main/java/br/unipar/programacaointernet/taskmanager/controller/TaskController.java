package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Task;
import br.unipar.programacaointernet.taskmanager.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
public class TaskController {
    @Inject
    private TaskService taskService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTasks() {
        return Response.ok(taskService.listar()).build();
    }

    @POST
    @Path("/new")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarTask(Task task) {
        try {
            taskService.cadastrar(task);
            return Response.status(201)
                    .entity("Task cadastrada com Sucesso")
                    .build();

        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/delete")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarTask(Task task) {
        try {
            taskService.deletar(task);
            return Response.status(201)
                    .entity("Task deletada com Sucesso")
                    .build();

        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void alterarTask(Task task) {
        //return Response.accepted().build();
    }
}
