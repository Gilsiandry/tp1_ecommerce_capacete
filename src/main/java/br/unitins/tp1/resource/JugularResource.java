package br.unitins.tp1.resource;

import br.unitins.tp1.dto.JugularDTO;
import br.unitins.tp1.service.JugularService;
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

@Path("jugulares")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JugularResource {

    @Inject
    JugularService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

     @GET
    @Path("/capacete/{id}")
    public Response buscarPorCapacete(Long id) { 
        return Response.status(Status.OK).entity(service.findByCapacete(id)).build();
    }

    @GET
    @Path("/tipoFechamento/{tipoFechamento}")
    public Response  buscarPorTipoFechamento(String tipoFechamento) { 
        return Response.status(Status.OK).entity(service.findByTipoFechamento(tipoFechamento)).build();
    }

    
    /*@GET
    public List<JugularResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/tipoFechamento/{tipoFechamento}")
    public List<JugularResponseDTO> buscarPorTipoFechamento(String tipoFechamento) { 
        return service.findByMarca(tipoFechamento);
    }
*/

    
   @POST
    public Response incluir(@Valid JugularDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, JugularDTO dto) {
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


    /*@POST
    public JugularResponseDTO incluir(JugularDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, JugularDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}*/