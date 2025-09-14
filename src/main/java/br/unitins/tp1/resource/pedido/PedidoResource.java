package br.unitins.tp1.resource.pedido;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.tp1.model.pedido.SituacaoPedido;
import br.unitins.tp1.service.pedido.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/adm/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @Inject
    public PedidoService pedidoService;

    @Inject
    public JsonWebToken jsonWebToken;

    @PATCH
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Administrador" })
    public Response updateStatusPedido(@PathParam("id") Long id, @QueryParam("situacaoPedido") SituacaoPedido situacaoPedido) {
        LOG.infof("Atualizado status do pedido %d para %s", id, situacaoPedido.getLabel());
        pedidoService.updateStatusPedido(id, situacaoPedido);
        return Response.noContent().build();
    }

}