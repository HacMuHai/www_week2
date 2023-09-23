package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "BIGINT(20)")
    private long productId;

    @Column(name = "description",length = 250,nullable = false)
    private String description;

    @Column(name = "manufacturer_name",length = 100,nullable = false)
    private String manufacturer;

    @Column(name = "name",length = 150,nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "INT(11)")
    private ProductStatus status;

    @Column(name = "",length = 25,nullable = false)
    private String unit;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
