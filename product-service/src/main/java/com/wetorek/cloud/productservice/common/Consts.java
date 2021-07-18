package com.wetorek.cloud.productservice.common;

public class Consts {

    public static final String CATALOG_API_GET_PRODUCT_BY_ID = "/api/product-info/getProductById/{id}";
    public static final String CATALOG_API_GET_PRODUCTS_BY_SKU = "/api/product-info/getProductsBySku/{sku}";
    public static final String INVENTORY_API_GET_AVAILABILITY_BY_IDS = "/api/availability/getAvailabilityByListOfUniqIds";

    private Consts() {
    }
}
