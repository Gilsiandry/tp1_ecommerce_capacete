package br.unitins.tp1.resource.capacete;

import br.unitins.tp1.dto.capacete.ModeloRequestDTO;
import br.unitins.tp1.dto.capacete.ModeloResponseDTO;
import br.unitins.tp1.service.capacete.ModeloService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

    @Path("/modelos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class ModeloResource {

    @Inject
    ModeloService service;

    @GET
    public List<ModeloResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(service.buscarPorId(id)).build();
    }

    @POST
    public Response inserir(@Valid ModeloRequestDTO dto, @Context UriInfo uriInfo) {
        ModeloResponseDTO criado = service.inserir(dto);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(criado.id()));
        return Response.created(builder.build()).entity(criado).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid ModeloRequestDTO dto) {
        return Response.ok(service.atualizar(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build();
    }
}