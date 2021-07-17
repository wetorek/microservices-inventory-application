package com.wetorek.cloud.inventory.inventoryservice.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    @CsvBindByName
    private String uniq_id;
    @CsvBindByName
    private String sku;
    @CsvBindByName
    private String name_title;
    @CsvBindByName
    private String description;
    @CsvBindByName
    private BigDecimal list_price;
    @CsvBindByName
    private BigDecimal sale_price;
    @CsvBindByName
    private String category;
    @CsvBindByName
    private String category_tree;
    @CsvBindByName
    private String average_product_rating;
    @CsvBindByName
    private String product_url;
    @CsvBindByName
    private String product_image_urls;
    @CsvBindByName
    private String brand;
    @CsvBindByName
    private Long total_number_reviews;
    @CsvBindByName
    private String Reviews;

}
