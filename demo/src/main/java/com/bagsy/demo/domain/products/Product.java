package com.bagsy.demo.domain.products;

import jakarta.persistence.*;
import lombok.*;

@Table(name="produtos")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "produto_id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String produto_id;
    private String nome;
    private String descricao;
    private Float preco;

    public Product(RequestProduct requestProduct){
        this.nome = requestProduct.nome();
        this.descricao = requestProduct.descricao();
        this.preco = requestProduct.preco();

    }
}
