package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id",columnDefinition = "BIGINT(20)")
    private long id;

    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;

    @Column(name = "address",length = 250,nullable = false)
    private String address;

    @Column(name = "phone",length = 15, nullable = false)
    private String phone;

    @Column(name = "email",length = 150)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList;



}
