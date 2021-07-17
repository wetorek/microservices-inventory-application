package com.wetorek.cloud.productservice.repository;

import com.wetorek.cloud.productservice.domain.Product;
import com.wetorek.cloud.productservice.repository.dto.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service")
public interface CatalogFeignClient {

    @GetMapping("/api/product-info/getProductById/{id}")
    Product getProductById(@PathVariable("id") String uniq_Id);

    @GetMapping("/api/product-info/getProductsBySku/{sku}")
    ProductResponseDto getProductsBySku(@PathVariable("sku") String sku);
}
