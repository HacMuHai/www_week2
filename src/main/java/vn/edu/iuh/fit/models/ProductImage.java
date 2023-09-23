package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", columnDefinition = "BIGINT(20)")
    private long imageId;

    @Column(name = "alternative",length = 250)
    private String alternative;

    @Column(name = "path",length = 250,nullable = false)
    private String path;
    @ManyToOne
    @JoinColumn(name = "product_id",unique = true)
    private  Product product;
}
