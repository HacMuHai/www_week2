package vn.edu.iuh.fit.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.services.CustomerService;
import vn.edu.iuh.fit.backend.services.OrderService;

import java.io.IOException;

public class OrderModel {
    private OrderService orderService;

    public OrderModel() {
        orderService = new OrderService();
    }



    public void openOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("listOrderDetail.jsp");
    }

    public void checkOut(HttpServletRequest req, HttpServletResponse resp) {


    }
}
