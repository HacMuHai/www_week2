package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontend.models.EmployeeModel;

import java.io.IOException;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

    EmployeeModel employeeModel = new EmployeeModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            Object obj = req.getParameter("action");
           if(obj != null){
               String action = obj.toString();
               switch (action){
                   case "listEmp":{
                       resp.sendRedirect("listEmp.jsp");
                       break;
                   }
                   case "updateEmp":{
                       employeeModel.openUpdateEmployee(req, resp);
                       break;
                   }
                   case "deleteEmp":{
                       employeeModel.deleteEmployee(req, resp);
                       break;
                   }

               }
            }else{
                resp.sendRedirect("listEmp.jsp");
            }
       }catch (Exception ex){
           throw new RuntimeException(ex);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object obj = req.getParameter("action");
            if(obj != null){
                String action = obj.toString();
                switch (action){
                    case "addEmp":{
                        employeeModel.addEmployee(req, resp);
                        break;
                    }
                    case "updateEmp":{
                        employeeModel.updateEmployee(req, resp);
                        break;
                    }

                }
            }else{
                resp.sendRedirect("listEmp.jsp");
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
