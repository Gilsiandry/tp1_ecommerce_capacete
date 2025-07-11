package br.unitins.tp1.resource;

import br.unitins.tp1.dto.LoteDTO;
import br.unitins.tp1.service.capacete.LoteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.time.LocalDate;



@Path("lotes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoteResource {

    @Inject
    LoteService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/codigo/{codigo}")
    public Response buscarPorCodigo(String codigo) { 
        return Response.ok().entity(service.findByCodigo(codigo)).build();
    }

    @GET
    @Path("/datafabricacao/{datafabricacao}")
    public Response buscarPorDataFabricacao(LocalDate datafabricacao) { 
        return Response.ok().entity(service.findByDataFabricacao(datafabricacao)).build();
    }



    
   @POST
    public Response incluir(@Valid LoteDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, LoteDTO dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response apagar(Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}