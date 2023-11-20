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

    public void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullname = req.getParameter("name").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        String dateOfBirth = req.getParameter("dob").trim();

        System.out.println(dateOfBirth);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

}
