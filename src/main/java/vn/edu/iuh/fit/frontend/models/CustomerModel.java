package vn.edu.iuh.fit.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.CustomerService;
import vn.edu.iuh.fit.backend.services.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerModel {
    private CustomerService customerService;

    public CustomerModel() {
        customerService = new CustomerService();
    }


    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullname = req.getParameter("name").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();

       Customer customer = new Customer(fullname,address,phone,email);

        boolean result = customerService.insert(customer);

        if(result){
            req.getSession().setAttribute("mess","Add Customer Complete");
            resp.sendRedirect("listCustomer.jsp");
        }else{
            req.getSession().setAttribute("mess","Add Customer Fail");
            resp.sendRedirect("addCustomer.jsp");
        }

    }

    public void openUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Customer customer = customerService.findByID(Long.parseLong(id)).orElse(new Customer());
        req.getSession().setAttribute("customer",customer);
        resp.sendRedirect("updateCustomer.jsp");
    }

    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        String fullname = req.getParameter("name").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();

        Customer customer = new Customer(fullname,address,phone,email);
        customer.setId(Long.parseLong(id));



        boolean result = customerService.updateCustomer(customer);

        if(result){
            req.getSession().setAttribute("mess","Update Customer id="+id+" Complete");
            resp.sendRedirect("listCustomer.jsp");
        }else{
            req.getSession().setAttribute("mess","Update Customer Fail");
            resp.sendRedirect("updateCustomer.jsp");
        }
    }
}
