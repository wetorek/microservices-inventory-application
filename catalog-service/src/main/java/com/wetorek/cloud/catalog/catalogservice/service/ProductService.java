package com.wetorek.cloud.catalog.catalogservice.service;

import com.wetorek.cloud.catalog.catalogservice.entity.Product;
import com.wetorek.cloud.catalog.catalogservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getProductById(String uniq_Id) {
        log.info("Geting products by id: {}", uniq_Id);
        return productRepository.getProductById(uniq_Id);
    }

    public List<Product> getProductsBySku(String sku) {
        log.info("Geting products by sku: {}", sku);
        return productRepository.getProductsBySku(sku);
    }
}