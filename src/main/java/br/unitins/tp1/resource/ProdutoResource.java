package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;
import br.unitins.tp1.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService service;

    @GET
    public List<ProdutoResponseDTO> buscarTodos() { 
        return service.findAll();
    }

    @GET
    @Path("/marca/{marca}")
    public List<ProdutoResponseDTO> buscarPorMarca(String marca) { 
        return service.findByMarca(marca);
    }

    @GET
    @Path("/modelo/{modelo}")
    public List<ProdutoResponseDTO> buscarPorModelo(String modelo) { 
        return service.findByModelo(modelo);
    }

    @GET
    @Path("/cor/{cor}")
    public List<ProdutoResponseDTO> buscarPorCor(String cor) { 
        return service.findByCor(cor);
    }

    @GET
    @Path("/tamanho/{tamanho}")
    public List<ProdutoResponseDTO> buscarPorTamanho(int tamanho) { 
        return service.findByTamanho(tamanho);
    }

   /* @GET
    @Path("/preco/{preco}")
    public ProdutoResponseDTO buscarPorPreco(Double preco) { 
        return service.findByPreco(preco);
    }*/

    



    @POST
    public ProdutoResponseDTO incluir(ProdutoDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, ProdutoDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
        service.delete(id);
    }

}