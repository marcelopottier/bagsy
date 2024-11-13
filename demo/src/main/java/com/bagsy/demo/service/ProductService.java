package com.bagsy.demo.service;

import com.bagsy.demo.domain.products.CreateProductDTO;
import com.bagsy.demo.domain.products.Product;
import com.bagsy.demo.domain.products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public UUID createProduct(CreateProductDTO createProductDTO){
        var entity = new Product(
                UUID.randomUUID(),
                createProductDTO.nome(),
                createProductDTO.descricao(),
                createProductDTO.preco(),
                createProductDTO.estoque(),
                createProductDTO.marca(),
                createProductDTO.cor(),
                createProductDTO.tamanho(),
                createProductDTO.peso(),
                createProductDTO.material(),
                createProductDTO.dataCriacao(),
                createProductDTO.dataAtualizacao(),
                createProductDTO.categoria()
        );
        var productSaved = productRepository.save(entity);
        return productSaved.getProdutoId();
    }
}
