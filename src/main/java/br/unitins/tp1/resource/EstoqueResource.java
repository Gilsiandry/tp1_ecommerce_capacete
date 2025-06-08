package br.unitins.tp1.resource;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.pedido.EstoqueDTO;
import br.unitins.tp1.dto.pedido.EstoqueResponseDTO;
import br.unitins.tp1.service.pedido.EstoqueService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
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

@Path("/lotes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueResource {

    private static final Logger LOG = Logger.getLogger(EstoqueResource.class);
    
    @Inject
    public EstoqueService loteService;

    @GET
    @RolesAllowed({"Adm"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Execucao do metodo findById. Id: " + id);
        return Response.ok(EstoqueResponseDTO.valueOf(loteService.findById(id))).build();
    }

    @GET
    @RolesAllowed({"Adm"})
    @Path("/search/codigo/{codigo}")
    public Response findByCodigo(@PathParam("codigo") String codigo) {
        LOG.info("Execucao do metodo findByCodigo. Codigo: " + codigo);
        return Response.ok(EstoqueResponseDTO.valueOf(loteService.findByCodigo(codigo))).build();
    }

    @GET
    @RolesAllowed({"Adm"})
    @Path("/search/capacete/qtdetotal/{idCapacete}")
    public Response findByIdCapaceteQtdeTotal(@PathParam("idCapacete") Long idCapacete) {
        LOG.info("Execucao do metodo findByCapaceteQtdeTotal. Id do Capacete: " + idCapacete);
        return Response.ok(loteService.findByIdCapaceteQtdeTotal(idCapacete)
                .stream()
                .map(EstoqueResponseDTO::valueOf)
                .toList()).build();
    }

    @GET
    @RolesAllowed({"Adm"})
    public Response findAll() {
        LOG.info("Execucao do metodo findAll");
        return Response.ok(loteService.findAll()
            .stream()
            .map(EstoqueResponseDTO::valueOf)
            .toList()).build();
    }

    @POST
    @RolesAllowed({"Adm"})
    public Response create(@Valid EstoqueDTO dto) {
        LOG.info("Execucao do metodo create");
        return Response.status(Status.CREATED)
            .entity(EstoqueResponseDTO.valueOf(loteService.create(dto)))
            .build();
    }

    @PUT
    @RolesAllowed({"Adm"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid EstoqueDTO dto) {
        LOG.info("Execucao do metodo update. Id do lote: " + id);
        loteService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @RolesAllowed({"Adm"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.info("Execucao do metodo delete. Id do lote: " + id);
        loteService.delete(id);
        return Response.noContent().build();
    }


}
