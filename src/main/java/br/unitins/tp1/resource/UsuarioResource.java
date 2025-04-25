package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.UsuarioDTO;
/*import br.unitins.tp1.dto.UsuarioResponseDTO;*/
import br.unitins.tp1.service.UsuarioService;
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

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @GET
    public Response buscarTodos() { 
        return Response.ok().entity(service.findAll()).build();
    }

     @GET
    @Path("/usuario/{id}")
    public Response buscarPorUsuario(Long id) { 
        return Response.status(Status.OK).entity(service.findByUsuario(id)).build();
    }

    @GET
    @Path("/email/{email}")
    public Response  buscarPorEmail(String email) { 
        return Response.status(Status.OK).entity(service.findByEmail(email)).build();
    }

    
    /*@GET
    public List<UsuarioResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/email/{email}")
    public List<UsuarioResponseDTO> buscarPorEmail(String email) { 
        return service.findByEmail(email);
    }
*/

    
   @POST
    public Response incluir(@Valid UsuarioDTO dto) {
        return Response.status(Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, UsuarioDTO dto) {
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
    public UsuarioResponseDTO incluir(UsuarioDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, UsuarioDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}*/