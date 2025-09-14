package br.unitins.tp1.resource.capacete;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.tp1.dto.capacete.CapaceteResponseDTO;
import br.unitins.tp1.model.capacete.Marca;
import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.service.file.CapaceteFileServiceImpl;
import br.unitins.tp1.service.capacete.CapaceteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/capacetes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CapaceteResource {

    private static final Logger LOG = Logger.getLogger(CapaceteResource.class);

    @Inject
    public CapaceteService capaceteService;

    @Inject
    public CapaceteFileServiceImpl fileService;

    @GET
    public Response getAll() {
        LOG.infof("Buscando todos os capacetes");
        List<Capacete> capacetes = capaceteService.findAll();
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf)).build();
    }

    @GET
    @Path("/search/nome")
    public Response findByNome(@QueryParam("nome") String nome) {
        LOG.infof("Buscando capacetes por nome: %s", nome);
        List<Capacete> capacetes = capaceteService.findByNome(nome);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

    @GET
    @Path("/search/cor")
    public Response findByCor(@QueryParam("cor") String cor) {
        LOG.infof("Buscando capacetes por cor: %s", cor);
        List<Capacete> capacetes = capaceteService.findByCor(cor);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

     @GET
    @Path("/search/Tamanho")
    public Response findByTamanho(@QueryParam("tamanho") int tamanho) {
        LOG.infof("Buscando capacetes por tamanho: %s", tamanho);
        List<Capacete> capacetes = capaceteService.findByTamanho(tamanho);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

    @GET
    @Path("/search/marca")
    public Response findByMarca(@QueryParam("marca") String marca) {
        LOG.infof("Buscando capacetes por marca: %s", marca);
        List<Capacete> capacetes = capaceteService.findByMarca(marca);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

    @GET
    @Path("/search/categoria")
    public Response findByCategoria(@QueryParam("categoria") Categoria categoria) {
        LOG.infof("Buscando capacetes por categoria: %s", categoria.getLabel());
        List<Capacete> capacetes = capaceteService.findByCategoria(categoria);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

    @GET
    @Path("/search/preco")
    public Response findByPreco(@QueryParam("preco") Double preco) {
        LOG.infof("Buscando capacetes por preço até: %f", preco);
        List<Capacete> capacetes = capaceteService.findByPreco(preco);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }

    @GET
    @Path("/search/preco/min/{precoMin}/max/{precoMax}")
    public Response findByPrecoMinAndMax(@PathParam("precoMin") Double precoMin,
            @PathParam("precoMax") Double precoMax) {
        LOG.infof("Buscando capacetes com preço entre %f e %f", precoMin, precoMax);
        List<Capacete> capacetes = capaceteService.findByPrecoMinAndMax(precoMin, precoMax);
        return Response.ok(capacetes.stream().map(CapaceteResponseDTO::valueOf).toList()).build();
    }
}