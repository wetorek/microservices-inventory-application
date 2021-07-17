package com.wetorek.cloud.productservice.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private BigDecimal list_price;
    private BigDecimal sale_price;
    private String category;
    private String category_tree;
    private String average_product_rating;
    private String product_url;
    private String product_image_urls;
    private String brand;
    private Long total_number_reviews;
    private String Reviews;

}
