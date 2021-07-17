package com.wetorek.cloud.catalog.catalogservice.controller.dto;

import com.wetorek.cloud.catalog.catalogservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    List<Product> products;

}
