package com.sqli.product.product.service;

import com.sqli.product.product.Exception.DataNotFoundException;
import com.sqli.product.product.dao.ProductRepository;
import com.sqli.product.product.dto.ProductConverter;
import com.sqli.product.product.dto.dtos.ProductDto;
import com.sqli.product.product.entity.Product;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public List<ProductDto> getProducts(){

        return productRepository.findAll().stream()
                .map(product -> ProductConverter.fromProduct(product))
                .collect(Collectors.toList());
    }

    public ProductDto getProduct(Long id){

        return ProductConverter.fromProduct(productRepository
                .findById(id)
                .orElseThrow(() ->  new DataNotFoundException("Product not found: "+id)));

    }

    public ProductDto addProduct(ProductDto productDto){

        Product product = productRepository.save(ProductConverter.toProduct(productDto));

        return ProductConverter.fromProduct(product);

    }

    public ProductDto updateProduct(Long id, ProductDto productDto){

        if(!productRepository.findById(id).isPresent())
            throw new DataNotFoundException("Product that you want update does not exist, id: "+id);


        Product product = ProductConverter.toProduct(productDto);
        product.setId(id);

        Product result = productRepository.save(product);
        return ProductConverter.fromProduct(result);
    }

    public void deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);

        productRepository.delete(product
                .orElseThrow(() -> new DataNotFoundException("Product that you want to delete does not exist, id: "+id)));
    }


}
