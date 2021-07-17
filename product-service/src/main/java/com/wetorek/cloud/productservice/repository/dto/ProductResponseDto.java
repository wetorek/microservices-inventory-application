package com.wetorek.cloud.productservice.repository.dto;

import com.wetorek.cloud.productservice.domain.Product;
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
