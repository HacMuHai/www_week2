package vn.edu.iuh.fit.models;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long order_id;
    private LocalDateTime orderDate;
    private Customer customer;
    private Employee employee;
    private List<OrderDetail> orderDetails;
}
