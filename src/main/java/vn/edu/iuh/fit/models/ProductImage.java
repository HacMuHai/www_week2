package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Objects;

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

    public ProductImage() {
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImage that = (ProductImage) o;
        return imageId == that.imageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId);
    }
}
