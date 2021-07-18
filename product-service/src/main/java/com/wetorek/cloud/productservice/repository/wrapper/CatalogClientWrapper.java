package com.wetorek.cloud.productservice.repository.wrapper;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wetorek.cloud.productservice.domain.Product;
import com.wetorek.cloud.productservice.repository.CatalogFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CatalogClientWrapper {
    private final CatalogFeignClient catalogFeignClient;

    @HystrixCommand(commandKey = "product-by-id")
    public Optional<Product> getProductById(String uniq_Id) {
        return Optional.of(catalogFeignClient.getProductById(uniq_Id));
    }

    @HystrixCommand(commandKey = "product-by-sku")
    public List<Product> getProductsBySku(String sku) {
        return catalogFeignClient.getProductsBySku(sku)
                .getProducts();
    }


}
