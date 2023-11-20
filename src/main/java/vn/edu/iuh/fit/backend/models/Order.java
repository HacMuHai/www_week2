package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Order.findOneById", query = "select o from Order o where o.orderId = ?1")
        ,@NamedQuery(name = "Order.findAll", query = "select o from Order o")
        ,@NamedQuery(name = "Order.getOrderDetailById", query = "select od from OrderDetail od WHERE od.order.id = ?1")
        ,@NamedQuery(name = "Order.getOrderByCustomerId", query = "select o from Order o where o.customer.id = ?1")
        ,@NamedQuery(name = "Order.getOrderByEmployeeId", query = "select o from Order o where o.employee.id = ?1")
})
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "order_date",nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(LocalDateTime orderDate, Customer customer, Employee employee) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
