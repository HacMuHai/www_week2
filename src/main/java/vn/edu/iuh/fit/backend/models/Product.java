package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findOneById", query = "select p from Product p where p.id = ?1 and p.status = 1")
        ,@NamedQuery(name = "Product.findAll", query = "select p from Product p where  p.status = ?1")
        ,@NamedQuery(name = "Product.setStatus", query = "update Product p set p.status = ?1 WHERE p.id = ?2")
        ,@NamedQuery(name = "Product.getPriceNew", query = "select price from ProductPrice p where  p.product.id = ?1 order by priceDateTime desc limit 1")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "BIGINT")
    private long productId;

    @Column(name = "description",length = 250,nullable = false)
    private String description;

    @Column(name = "manufacturer_name",length = 100,nullable = false)
    private String manufacturer;

    @Column(name = "name",length = 150,nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "INT")
    private ProductStatus status;

    @Column(name = "",length = 25,nullable = false)
    private String unit;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(String description, String manufacturer, String name, ProductStatus status, String unit) {
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
