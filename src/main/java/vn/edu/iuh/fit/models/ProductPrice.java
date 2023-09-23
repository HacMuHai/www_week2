package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "prodcut_id", nullable = false)
    private Product product;

}
