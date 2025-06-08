package br.unitins.tp1.resource;

import br.unitins.tp1.dto.CertificacaoDTO;
import br.unitins.tp1.service.capacete.CertificacaoService;
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

@Path("certificacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CertificacaoResource {

    @Inject
    CertificacaoService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/pais/{pais}")
    public Response buscarPorPais(String pais) { 
        return Response.ok().entity(service.findByPais(pais)).build();
    }

    @GET
    @Path("/descricao/{descricao}")
    public Response buscarPorDescricao(String descricao) { 
        return Response.ok().entity(service.findByDescricao(descricao)).build();
    }

    
   @POST
    public Response incluir(@Valid CertificacaoDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, CertificacaoDTO dto) {
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