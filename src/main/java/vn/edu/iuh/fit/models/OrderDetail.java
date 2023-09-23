package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "price",nullable = false)
    private  double price;

    @Column(name = "quantity",nullable = false)
    private double quantity;

    @Column(name = "note")
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
