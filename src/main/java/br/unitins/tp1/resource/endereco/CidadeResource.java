package br.unitins.tp1.resource.endereco;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.endereco.CidadeRequestDTO;
import br.unitins.tp1.dto.endereco.CidadeResponseDTO;
import br.unitins.tp1.model.endereco.Cidade;
import br.unitins.tp1.service.endereco.CidadeService;
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

@Path("/cidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {

    private static final Logger LOG = Logger.getLogger(CidadeResource.class);

    @Inject
    public CidadeService cidadeService;

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Execução do método findById. ID da endereco: %d", id);
        return Response.ok(CidadeResponseDTO.valueOf(cidadeService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Execução do método findByNome. Nome da endereco: %s", nome);
        List<Cidade> cidades = cidadeService.findByNome(nome);
        return Response.ok(cidades.stream().map(CidadeResponseDTO::valueOf).toList()).build();
    }

    @GET
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response findAll() {
        LOG.info("Execução do método findAll. Buscando todas as cidades.");
        List<Cidade> cidades = cidadeService.findAll();
        return Response.ok(cidades.stream().map(CidadeResponseDTO::valueOf).toList()).build();
    }

    @POST
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response create(@Valid CidadeRequestDTO endereco) {
        LOG.infof("Execução do método create. Dados da endereco: %s", endereco);
        return Response.status(Status.CREATED).entity(CidadeResponseDTO.valueOf(cidadeService.create(endereco))).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response update(@PathParam("id") Long id, @Valid CidadeRequestDTO endereco) {
        LOG.infof("Execução do método update. Atualizando endereco com ID: %d. Dados: %s", id, endereco);
        cidadeService.update(id, endereco);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Execução do método delete. Deletando endereco com ID: %d", id);
        cidadeService.delete(id);
        return Response.noContent().build();
    }
}