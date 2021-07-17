//package com.wetorek.cloud.productservice.repository;
//
//import com.google.common.collect.Lists;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.wetorek.cloud.productservice.common.Consts;
//import com.wetorek.cloud.productservice.domain.Product;
//import com.wetorek.cloud.productservice.repository.dto.ProductResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
////@Repository
//@RequiredArgsConstructor
//public class CatalogClient {
//    private final RestTemplate restTemplate;
//
//    @HystrixCommand(commandKey = "product-by-id")
//    public Optional<Product> getProductByUniqId(String uniqId) {
//        var productResponseEntity = restTemplate.getForEntity(
//                Consts.CATALOG_API_GET_PRODUCT_BY_ID, Product.class, uniqId);
//        return Optional.ofNullable(productResponseEntity.getBody());
//    }
//
//    @HystrixCommand(commandKey = "product-by-sku")
//    public List<Product> getProductsBySku(String sku) {
//        var productsResponseEntity = restTemplate.getForEntity(
//                Consts.CATALOG_API_GET_PRODUCTS_BY_SKU, ProductResponseDto.class, sku);
//        return productsResponseEntity.getBody() == null ? Lists.newArrayList() : productsResponseEntity.getBody().getProducts();
//    }
//}
//
