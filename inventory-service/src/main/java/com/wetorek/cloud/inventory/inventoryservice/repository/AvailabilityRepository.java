package com.wetorek.cloud.inventory.inventoryservice.repository;

import com.wetorek.cloud.inventory.inventoryservice.common.Consts;
import com.wetorek.cloud.inventory.inventoryservice.entity.Availability;
import com.wetorek.cloud.inventory.inventoryservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AvailabilityRepository {
    private final CsvFileReader csvFileReader;
    private Map<String, Availability> availabilityMap;

    @PostConstruct
    public void init() {
        try {
            var loadedProducts = csvFileReader.readProducts(Consts.DATA_PATH);
            this.availabilityMap = computeAvailability(loadedProducts);
        } catch (IOException e) {
            throw new RuntimeException("Data not loaded", e);
        }
    }

    private Map<String, Availability> computeAvailability(List<Product> loadedProducts) {
        return loadedProducts.stream()
                .map(this::createAvailability)
                .collect(Collectors.toMap(Availability::getUniq_id, Function.identity()));
    }

    private Availability createAvailability(Product product) {
        var availability = new Availability();
        availability.setUniq_id(product.getUniq_id());
        availability.setAmount(new Random().ints(0, 10).findFirst().orElse(0));
        return availability;
    }

    public List<Availability> getAvailabilityByListOfUniqIds(List<String> uniqIds) {
        return uniqIds.stream()
                .map(availabilityMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
