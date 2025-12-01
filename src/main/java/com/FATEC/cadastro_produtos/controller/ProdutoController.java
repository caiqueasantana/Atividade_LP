package com.FATEC.cadastro_produtos.controller;


import com.FATEC.cadastro_produtos.business.ProdutosService;
import com.FATEC.cadastro_produtos.infrastructure.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Indica que é um controller do padrão REST (retorna a pesquisa do user no estado atual do item pesquisado)
@RestController
//Indica a requisição localhost:8080/produto
@RequestMapping("/produto")

//obriga todos os construtores a serem não nulos
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<Void > salvarProduto(@RequestBody Produto produto){
        produtosService.salvarProduto(produto);
        //indica que qualquer respota HTTP é aceita
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Produto> findById(@RequestParam Integer id){
        return ResponseEntity.ok(produtosService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id){
        produtosService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateById(@RequestParam Integer id, @RequestBody Produto produto){
        produtosService.updateById(id, produto);
        return ResponseEntity.ok().build();
    }
}
