package br.unitins.tp1.resource.capacete;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.capacete.MarcaRequestDTO;
import br.unitins.tp1.dto.capacete.MarcaResponseDTO;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.service.capacete.MarcaService;
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

@Path("/marcas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaResource {

    private static final Logger LOG = Logger.getLogger(MarcaResource.class);

    @Inject
    public MarcaService marcaService;

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Buscando marca com ID: %d", id);
        return Response.ok(MarcaResponseDTO.valueOf(marcaService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando marcas pelo nome: %s", nome);
        List<Marca> marcas = marcaService.findByNome(nome);
        return Response.ok(marcas.stream().map(MarcaResponseDTO::valueOf).toList()).build();
    }

    @GET
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response findAll() {
        LOG.infof("Buscando todas as marcas");
        List<Marca> marcas = marcaService.findAll();
        return Response.ok(marcas.stream().map(MarcaResponseDTO::valueOf).toList()).build();
    }

    @POST
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response create(@Valid MarcaRequestDTO dto) {
        LOG.infof("Criando nova marca: %s", dto);
        return Response.status(Status.CREATED).entity(MarcaResponseDTO.valueOf(marcaService.create(dto))).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response update(@PathParam("id") Long id, @Valid MarcaRequestDTO dto) {
        LOG.infof("Atualizando marca com ID: %d", id);
        marcaService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Administrador", "Funcionario" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando marca com ID: %d", id);
        marcaService.delete(id);
        return Response.noContent().build();
    }
}