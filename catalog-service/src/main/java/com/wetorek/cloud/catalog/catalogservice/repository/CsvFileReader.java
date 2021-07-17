package com.wetorek.cloud.catalog.catalogservice.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.wetorek.cloud.catalog.catalogservice.entity.Product;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

@Component
public class CsvFileReader {

    public List<Product> readProducts(String path) throws IOException {
        try (Reader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(path))))) {
            return new CsvToBeanBuilder<Product>(reader)
                    .withType(Product.class)
                    .withThrowExceptions(false)
                    .withIgnoreQuotations(true)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }
    }
}
