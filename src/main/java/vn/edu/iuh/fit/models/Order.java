package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",columnDefinition = "BIGINT(20)")
    private long orderId;

    @Column(name = "order_date",nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "cust_id",unique = true)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,unique = true)
    private Employee employee;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
