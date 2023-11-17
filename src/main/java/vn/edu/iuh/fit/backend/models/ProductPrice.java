package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time",columnDefinition = "DATETIME(6)")
    private LocalDateTime priceDateTime;

    @Column(name = "note",length = 255)
    private String note;

    @Column(name = "price",nullable = false)
    private double price;


    @Id
    @ManyToOne
    @JoinColumn(name = "prodcut_id", nullable = false)
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, String note, double price, Product product) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(priceDateTime, that.priceDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceDateTime);
    }
}
