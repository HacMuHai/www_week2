package vn.edu.iuh.fit.frontend.models;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeModel {
    private EmployeeService employeeService;

    public EmployeeModel() {
        employeeService = new EmployeeService();
    }


    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        boolean result = employeeService.setStatusEmp(Long.parseLong(id));

        if(result){
            req.getSession().setAttribute("mess","Delete Employee id="+id+" Complete");
        }else{
            req.getSession().setAttribute("mess","Delete Employee id="+id+" Fail");
        }
        resp.sendRedirect("listEmp.jsp");
    }

    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        String fullname = req.getParameter("name").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        String dateOfBirth = req.getParameter("dob").trim();

        LocalDateTime dob = LocalDate.parse(dateOfBirth).atStartOfDay();
        Employee employee = new Employee(fullname,dob,email,address,phone, EmployeeStatus.ACTIVE);
        employee.setId(Long.parseLong(id));

        boolean result = employeeService.updateEmp(employee);

        if(result){
            req.getSession().setAttribute("mess","Update Employee id="+id+" Complete");
            resp.sendRedirect("listEmp.jsp");
        }else{
            req.getSession().setAttribute("mess","Update Employee Fail");
            resp.sendRedirect("updateEmp.jsp");
        }

    }

    public void openUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.findByID(Long.parseLong(id)).orElse(new Employee());
        req.getSession().setAttribute("emp",employee);
        resp.sendRedirect("updateEmp.jsp");
    }

    public void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullname = req.getParameter("name").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        String dateOfBirth = req.getParameter("dob").trim();

        LocalDateTime dob = LocalDate.parse(dateOfBirth).atStartOfDay();
        Employee employee = new Employee(fullname,dob,email,address,phone, EmployeeStatus.ACTIVE);

        boolean result = employeeService.insert(employee);

        if(result){
            req.getSession().setAttribute("mess","Add Employee Complete");
            resp.sendRedirect("listEmp.jsp");
        }else{
            req.getSession().setAttribute("mess","Add Employee Fail");
            resp.sendRedirect("addEmp.jsp");
        }

    }

    public void openOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        req.getSession().setAttribute("employeeId",id);
        resp.sendRedirect("listOrder.jsp");
    }
}

