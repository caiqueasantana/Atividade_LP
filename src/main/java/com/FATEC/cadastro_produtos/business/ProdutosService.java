package com.FATEC.cadastro_produtos.business;

import com.FATEC.cadastro_produtos.infrastructure.entity.Produto;
import com.FATEC.cadastro_produtos.infrastructure.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.UnionSubclass;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//indica que é a classe de serviço
@Service
public class ProdutosService {

    private final ProdutoRepository repository;

    //construtor
    public ProdutosService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Produto produto){
        //salva o produto e fecha a conexão com o banco de dados
        repository.saveAndFlush(produto);
    }

    public Produto findById(Integer id){
        //encontra produto pelo Id, caso não encontre retorna um erro de exceção
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );
    }

    public void deleteById(Integer id){
        //deleta produto pelo Id
        repository.deleteById(id);
    }


    //este metodo atualiza as informações do produto pelo id
    //Produto.builder constroi um obj produto
    //primeiro ele verifica se o atributo é nulo e caso não seja, ele mantém o que foi passado
    //caso ele seja nulo, ele coloca o id que foi passado acima "produtoEntity"
    public void updateById (Integer id, Produto produto){
        Produto produtoEntity = findById(id);

        Produto produtoUpdate = Produto.builder()
                .id(produto.getId() != null ? produto.getId() : produtoEntity.getId())
                .nomeProduto(produto.getNomeProduto() != null ? produto.getNomeProduto() : produtoEntity.getNomeProduto())
                .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
                .build();
        repository.saveAndFlush(produtoUpdate);
    }
}
