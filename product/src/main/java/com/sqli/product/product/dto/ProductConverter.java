package com.sqli.product.product.dto;

import com.sqli.product.product.dto.dtos.ProductDto;
import com.sqli.product.product.entity.Product;

public class ProductConverter {

    private ProductConverter(){}

    public static ProductDto fromProduct(Product product){
        return new ProductDto(
                product.getName(),
                product.getPrice()
        );
    }

    public static Product toProduct(ProductDto productDto){
        return new Product(
                null,
                productDto.getName(),
                productDto.getPrice()
        );
    }
}
