package com.FATEC.cadastro_produtos.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produto")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    //nome = nomeDaTabela, restrições da coluna
    @Column(name = "nomeProduto", unique = true)
    private String nomeProduto;

    @Column(name = "preço")
    private BigDecimal preco;
}
