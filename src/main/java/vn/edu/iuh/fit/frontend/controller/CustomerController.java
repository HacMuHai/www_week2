package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontend.models.CustomerModel;

import java.io.IOException;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {

    CustomerModel customerModel = new CustomerModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            Object obj = req.getParameter("action");
           if(obj != null){
               String action = obj.toString();
               switch (action){
                   case "listCustomer":{
                       resp.sendRedirect("listCustomer.jsp");
                       break;
                   }
                   case "updateCustomer":{
                       customerModel.openUpdate(req, resp);
                       break;
                   }
                   default:{
                       req.getSession().setAttribute("mess","Fail");
                       resp.sendRedirect("listCustomer.jsp");
                       break;
                   }

               }
            }else{
                resp.sendRedirect("listCustomer.jsp");
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
                    case "addCustomer":{
                        customerModel.addCustomer(req, resp);
                        break;
                    }
                    case "updateCustomer":{
                        customerModel.updateCustomer(req, resp);
                        break;
                    }

                }
            }else{
                resp.sendRedirect("listCustomer.jsp");
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
