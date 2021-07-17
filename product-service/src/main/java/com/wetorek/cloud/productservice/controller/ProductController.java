package com.wetorek.cloud.productservice.controller;

import com.wetorek.cloud.productservice.domain.Product;
import com.wetorek.cloud.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getAvailableProductById(@PathVariable String id) {
        var product = productService.getAvailableProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getProductsBySku/{sku}")
    List<Product> getAvailableProductsBySku(@PathVariable String sku) {
        return productService.getAvailableProducts(sku);
    }
}
