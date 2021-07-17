package com.wetorek.cloud.catalog.catalogservice.repository;

import com.wetorek.cloud.catalog.catalogservice.common.Consts;
import com.wetorek.cloud.catalog.catalogservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final CsvFileReader csvFileReader;
    private List<Product> loadedProducts;

    @PostConstruct
    public void init() {
        try {
            this.loadedProducts = csvFileReader.readProducts(Consts.DATA_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Data not loaded", e);
        }
    }

    public Optional<Product> getProductById(String uniq_Id) {
        return loadedProducts.stream()
                .filter(u -> StringUtils.equals(u.getUniq_id(), uniq_Id))
                .findAny();
    }

    public List<Product> getProductsBySku(String sku) {
        return loadedProducts.stream()
                .filter(u -> StringUtils.equals(u.getSku(), sku))
                .collect(Collectors.toList());
    }
}
