package com.sqli.product.product;

import com.sqli.product.product.dao.ProductRepository;
import com.sqli.product.product.dto.dtos.ProductDto;
import com.sqli.product.product.entity.Product;
import com.sqli.product.product.service.ProductService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Main {
    @Autowired
    ProductService productService;
    @Autowired
    static ProductRepository productRepository;
    public static void main(String[] args) {

        /*System.out.println("---DTOS");
        List<ProductDto> productDtos = new Main().productService.getProducts();
        System.out.println(productDtos);

        System.out.println("MODELS");

        List<Product> products = new Main().productRepository.findAll();
        System.out.println(products);
    */

        System.out.println("Add product");
        Product product = new Product(2L,"Phone",240);
        System.out.println(productRepository.save(product));
    }
}
