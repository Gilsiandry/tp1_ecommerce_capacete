package br.unitins.tp1.resource;

import br.unitins.tp1.dto.CapaceteDTO;
import br.unitins.tp1.service.CapaceteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("capacetes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CapaceteResource {

    @Inject
    CapaceteService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/marca/{marca}")
    public Response buscarPorSigla(String marca) { 
        return Response.ok().entity(service.findByMarca(marca)).build();
    }

    @GET
    @Path("/categoria/{categoria}")
    public Response buscarPorCategoria(String categoria) { 
        return Response.ok().entity(service.findByCategoria(categoria)).build();
    }

    @GET
    @Path("/modelo/{modelo}")
    public Response buscarPorModelo(String modelo) { 
        return Response.ok().entity(service.findByModelo(modelo)).build();
    }

    @GET
    @Path("/cor/{cor}")
    public Response buscarPorCor(String cor) { 
        return Response.ok().entity(service.findByCor(cor)).build();
    }

    @GET
    @Path("/tamanho/{tamanho}")
    public Response buscarPorTamanho(int tamanho) { 
        return Response.ok().entity(service.findByTamanho(tamanho)).build();
    }

 
    @GET
    @Path("/search/preco/{min}/{max}")
    public Response findByPreco(@PathParam("min") Double min, @PathParam("max") Double max) {
        return Response.ok().entity(service.findByPreco(min, max)).build();
    }

    /*@GET
    public List<CapaceteResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/marca/{marca}")
    public List<CapaceteResponseDTO> buscarPorMarca(String marca) { 
        return service.findByMarca(marca);
    }

    @GET
    @Path("/categoria/{categoria}")
    public List<CapaceteResponseDTO> buscarPorCategoria(String categoria) { 
        return service.findByCategoria(categoria);
    }

    @GET
    @Path("/modelo/{modelo}")
    public List<CapaceteResponseDTO> buscarPorModelo(String modelo) { 
        return service.findByModelo(modelo);
    }

    @GET
    @Path("/cor/{cor}")
    public List<CapaceteResponseDTO> buscarPorCor(String cor) { 
        return service.findByCor(cor);
    }

    @GET
    @Path("/tamanho/{tamanho}")
    public List<CapaceteResponseDTO> buscarPorTamanho(int tamanho) { 
        return service.findByTamanho(tamanho);
    }

   /* @GET
    @Path("/preco/{preco}")
    public CapaceteResponseDTO buscarPorPreco(Double preco) { 
        return service.findByPreco(preco);
    }*/

    
   @POST
    public Response incluir(@Valid CapaceteDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, CapaceteDTO dto) {
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
    public CapaceteResponseDTO incluir(CapaceteDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, CapaceteDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}*/