package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            Object obj = req.getParameter("action");
           if(obj != null){
               String action = obj.toString();
               if(action.equals("listEmp")){
                   resp.sendRedirect("employees/listEmp.jsp");
               }
            }else{
                resp.sendRedirect("employees/listEmp.jsp");
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
//                if(action.equals("listEmp")){
//                    resp.sendRedirect("listEmp.jsp");
//                }
            }else{
                resp.sendRedirect("employees/listEmp.jsp");
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
