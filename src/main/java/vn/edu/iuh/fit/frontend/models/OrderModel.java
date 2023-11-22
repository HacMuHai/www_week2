package vn.edu.iuh.fit.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.OrderDetailRepository;
import vn.edu.iuh.fit.backend.services.CustomerService;
import vn.edu.iuh.fit.backend.services.EmployeeService;
import vn.edu.iuh.fit.backend.services.OrderService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class OrderModel {
    private OrderService orderService;

    public OrderModel() {
        orderService = new OrderService();
    }


    public void openOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        req.getSession().setAttribute("id", id);
        resp.sendRedirect("listOrderDetail.jsp");
    }

    public void checkOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<Product, Integer> lst = (Map<Product, Integer>) req.getSession().getAttribute("listProductCart");

        if (lst != null) {

            EmployeeService employeeService = new EmployeeService();
            CustomerService customerService = new CustomerService();
            ProductService productService = new ProductService();
            OrderDetailRepository orderDetailRepository = new OrderDetailRepository();

            Employee employee = employeeService.findEmpFirst().orElse(new Employee());
            Customer customer = customerService.findCusFirst().orElse(new Customer());

            Order order = new Order(LocalDateTime.now(), customer, employee);
            orderService.insert(order);
            System.out.println(order);
            for (Map.Entry<Product, Integer> entry : lst.entrySet()) {
                Product product = entry.getKey();
                OrderDetail orderDetail = new OrderDetail(order,product,productService.getPrice(product.getProductId()),entry.getValue(),"");
                orderDetailRepository.insert(orderDetail);
            }

            req.getSession().removeAttribute("listProductCart");
            req.getSession().setAttribute("id",order.getOrderId()+"");

            resp.sendRedirect("listOrderDetail.jsp");

        } else {
            resp.sendRedirect("listProductInCart.jsp");
        }


    }
}
