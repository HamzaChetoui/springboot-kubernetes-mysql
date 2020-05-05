package com.sqli.product.product.controller;

import com.sqli.product.product.dto.dtos.ProductDto;
import com.sqli.product.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct (@PathVariable Long id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id,productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct (@PathVariable Long id){
         productService.deleteProduct(id);

         return "Deleted Product id: "+id;
    }
}
