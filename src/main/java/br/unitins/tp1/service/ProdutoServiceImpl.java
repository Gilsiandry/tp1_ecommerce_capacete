package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;
import br.unitins.tp1.model.Produto;
import br.unitins.tp1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    public ProdutoServiceImpl() {
    }

    @Override
    @Transactional
    public ProdutoResponseDTO create(ProdutoDTO produto) {
        Produto novoProduto = new Produto();
        novoProduto.setNome(produto.nome());
        novoProduto.setMarca(produto.marca());
        novoProduto.setModelo(produto.modelo());
        novoProduto.setCor(produto.cor());
        novoProduto.setTamanho(produto.tamanho());
        //novoProduto.setPreco(produto.preco()));
       

        // realizando inclusao
        produtoRepository.persist(novoProduto);

        return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    @Transactional
    public void update(long id, ProdutoDTO produto) {
        Produto edicaoProduto = produtoRepository.findById(id);

        edicaoProduto.setNome(produto.nome());
        edicaoProduto.setMarca(produto.marca());
        edicaoProduto.setModelo(produto.modelo());
        edicaoProduto.setCor(produto.cor());
        edicaoProduto.setTamanho(produto.tamanho());
       // edicaoProduto.setPreco(produto.preco());
    
    }

    @Override
    @Transactional
    public void delete(long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public ProdutoResponseDTO findById(long id) {
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findByMarca(String marca) {
        return produtoRepository.findByMarca(marca).stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByModelo(String modelo) {
        return produtoRepository.findByModelo(modelo).stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByCor(String cor) {
        return produtoRepository.findByCor(cor).stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByTamanho(int tamanho) {
        return produtoRepository.findByTamanho(tamanho).stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }

    /*@Override
    public List<ProdutoResponseDTO> findByPreco
    (Double preco) {
        return produtoRepository.findByPreco(findByPreco).stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }
*/

    @Override
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.findAll().stream().map(p -> ProdutoResponseDTO.valueOf(p)).toList();
    }
    
}