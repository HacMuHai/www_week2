package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {

        orderRepository = new OrderRepository();
    }

    public Optional<Order> getOneById(long id) {
        return orderRepository.getOneById(id);
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }


    public boolean insert(Order o) {
        return orderRepository.insert(o);
    }

    public boolean update(Order o) {
        return orderRepository.update(o);
    }

    public List<OrderDetail> getOrderDetailByOrderID(long id) {
        return orderRepository.getOrderDetailByOrderID(id);

    }

    public List<Order> getOrderByCustomerId(long id) {
        return orderRepository.getOrderByCustomerId(id);
    }

    public List<Order> getOrderByEmployeeId(long id) {
        return orderRepository.getOrderByEmployeeId(id);
    }
}
