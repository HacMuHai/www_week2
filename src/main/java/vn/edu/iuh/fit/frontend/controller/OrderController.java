package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontend.models.OrderModel;

import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet {

    OrderModel orderModel = new OrderModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            Object obj = req.getParameter("action");
           if(obj != null){
               String action = obj.toString();
               switch (action){
                   case "listOrder":{
                       resp.sendRedirect("listOrder.jsp");
                       break;
                   }
                   case "orderDetails":{
                       orderModel.openOrderDetail(req, resp);
                       break;
                   }
                   default:{
                       req.getSession().setAttribute("mess","Fail");
                       resp.sendRedirect("listOrder.jsp");
                       break;
                   }

               }
            }else{
                resp.sendRedirect("listOrder.jsp");
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
                    case "addOrder":{
//                        orderModel.addCustomer(req, resp);
                        break;
                    }
                    case "checkout":{
                        System.out.println("123");
                        orderModel.checkOut(req, resp);
                        break;
                    }

                }
            }else{
                resp.sendRedirect("listOrder.jsp");
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
