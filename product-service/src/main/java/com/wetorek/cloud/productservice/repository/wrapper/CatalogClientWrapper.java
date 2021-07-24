package com.wetorek.cloud.productservice.repository.wrapper;

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

    public Optional<Product> getProductById(String uniq_Id) {
        return Optional.of(catalogFeignClient.getProductById(uniq_Id));
    }

    public List<Product> getProductsBySku(String sku) {
        return catalogFeignClient.getProductsBySku(sku)
                .getProducts();
    }
}
