package com.wetorek.cloud.productservice.common;

public class Consts {

    public static String CATALOG_API_GET_PRODUCT_BY_ID = "http://catalog-service/api/products/getProductById/{id}";
    public static String CATALOG_API_GET_PRODUCTS_BY_SKU = "http://catalog-service/api/products/getProductsBySku/{sku}";
    public static String INVENTORY_API_GET_AVAILABILITY_BY_IDS = "http://inventory-service/api/availability/getAvailabilityByListOfUniqIds";

    private Consts() {
    }
}
