package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Historico;
import br.unipar.programacaointernet.taskmanager.service.HistoricoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historico")
public class HistoricoController {
    @Inject
    private HistoricoService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarHistoricos() {
        return Response.ok(service.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarHistorico(Historico historico) {
        try {
            service.cadastrar(historico);
            return Response.status(201)
                    .entity("Historico cadastrado com Sucesso")
                    .build();

        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }
}
