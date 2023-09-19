package vn.edu.iuh.fit.models;

import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

public class Product {
    private long product_id;
    private String description;
    private String manufacturer;
    private String name;
    private ProductStatus status;
    private String unit;
    private List<ProductImage> productImageList;
    private List<OrderDetail> orderDetails;
}
