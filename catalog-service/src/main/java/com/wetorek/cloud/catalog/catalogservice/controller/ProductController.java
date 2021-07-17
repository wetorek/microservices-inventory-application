package com.wetorek.cloud.catalog.catalogservice.controller;

import com.wetorek.cloud.catalog.catalogservice.controller.dto.ProductResponseDto;
import com.wetorek.cloud.catalog.catalogservice.entity.Product;
import com.wetorek.cloud.catalog.catalogservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-info")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProductById/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") String uniq_Id) {
        return productService.getProductById(uniq_Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getProductsBySku/{sku}")
    ProductResponseDto getProductsBySku(@PathVariable("sku") String sku) {
        var products = productService.getProductsBySku(sku);
        return new ProductResponseDto(products);
    }
}
