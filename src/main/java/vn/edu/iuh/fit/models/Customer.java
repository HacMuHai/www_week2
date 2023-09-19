package vn.edu.iuh.fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

//@Entity
//@Table(name = "Customer")
public class Customer {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<Order> orderList;



}
