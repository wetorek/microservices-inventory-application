package com.wetorek.cloud.productservice.repository;

import com.wetorek.cloud.productservice.common.Consts;
import com.wetorek.cloud.productservice.domain.Product;
import com.wetorek.cloud.productservice.repository.dto.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service")
public interface CatalogFeignClient {

    @GetMapping(Consts.CATALOG_API_GET_PRODUCT_BY_ID)
    Product getProductById(@PathVariable("id") String uniq_Id);

    @GetMapping(Consts.CATALOG_API_GET_PRODUCTS_BY_SKU)
    ProductResponseDto getProductsBySku(@PathVariable("sku") String sku);
}
