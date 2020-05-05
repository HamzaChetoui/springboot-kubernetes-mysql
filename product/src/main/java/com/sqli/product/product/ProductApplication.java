package com.sqli.product.product;

import com.sqli.product.product.dao.ProductRepository;
import com.sqli.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {

    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo() {
        return (args) -> {


        };
    }
}
