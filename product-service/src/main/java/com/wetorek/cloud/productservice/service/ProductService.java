package com.wetorek.cloud.productservice.service;

import com.google.common.collect.Lists;
import com.wetorek.cloud.productservice.domain.Availability;
import com.wetorek.cloud.productservice.domain.Product;
import com.wetorek.cloud.productservice.repository.wrapper.CatalogClientWrapper;
import com.wetorek.cloud.productservice.repository.wrapper.InventoryClientWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final CatalogClientWrapper catalogClientWrapper;
    private final InventoryClientWrapper inventoryClientWrapper;

    @Transactional
    public Optional<Product> getAvailableProductById(String uniqId) {
        log.info("Getting available products by id: {}", uniqId);
        var product = catalogClientWrapper.getProductById(uniqId);
        var availability =
                inventoryClientWrapper.getAvailabilityByListOfUniqIds(Lists.newArrayList(uniqId)).get(0);
        if (availability == null || Objects.equals(availability.getAmount(), 0) || availability.getAmount() == null) {
            log.info("No available products found for id: {}", uniqId);
            return Optional.empty();
        }
        return product;
    }

    @Transactional
    public List<Product> getAvailableProducts(String sku) {
        log.info("Getting available products by sku: {}", sku);
        var products = catalogClientWrapper.getProductsBySku(sku).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        var ids = products.stream()
                .map(Product::getUniq_id)
                .collect(Collectors.toList());
        var availabilityMap = inventoryClientWrapper.getAvailabilityByListOfUniqIds(ids).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Availability::getUniq_id, Function.identity()));
        return products.stream()
                .filter(testProductAvailability(availabilityMap))
                .collect(Collectors.toList());
    }

    private Predicate<Product> testProductAvailability(Map<String, Availability> availabilityMap) {
        return product -> Objects.nonNull(availabilityMap.get(product.getUniq_id())) &&
                !Objects.equals(availabilityMap.get(product.getUniq_id()).getAmount(), 0);
    }
}
