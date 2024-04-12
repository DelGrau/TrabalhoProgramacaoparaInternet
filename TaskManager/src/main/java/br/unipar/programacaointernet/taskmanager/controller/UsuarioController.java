package br.unipar.programacaointernet.taskmanager.controller;

import br.unipar.programacaointernet.taskmanager.model.Usuario;
import br.unipar.programacaointernet.taskmanager.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        return Response.ok(usuarioService.listar()).build();
    }

    @POST
    @Path("/new")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);
            return Response.status(201)
                    .entity("Historico cadastrado com Sucesso")
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
    public Response deletarUsuario(Usuario usuario) {
        try {
            usuarioService.deletar(usuario);
            return Response.status(201)
                    .entity("Usuario deletada com Sucesso")
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
    public void atualizarUsuario(Usuario usuario) {

    }

}
