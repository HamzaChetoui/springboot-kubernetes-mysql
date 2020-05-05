package com.sqli.product.product.dto.dtos;

import java.io.Serializable;

public final class ProductDto implements Serializable {

    private final String name;

    private final int price;

    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
