package vn.edu.iuh.fit.frontend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontend.models.ProductModel;

import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    ProductModel productModel = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            Object obj = req.getParameter("action");
           if(obj != null){
               String action = obj.toString();
               switch (action){
                   case "listProduct":{
                       resp.sendRedirect("listProduct.jsp");
                       break;
                   }
                   case "addToCart":{
                       productModel.addToCart(req, resp);
                       break;
                   }
                   case "openCart":{
                       resp.sendRedirect("listProductInCart.jsp");
                       break;
                   }case "deleteProductCart":{
                       productModel.deleteProductCart(req, resp);
                       break;
                   }
                   default:{
                       req.getSession().setAttribute("mess","Fail");
                       resp.sendRedirect("listProduct.jsp");
                       break;
                   }

               }
            }else{
                resp.sendRedirect("listProduct.jsp");
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
                    default:{
                        req.getSession().setAttribute("mess","Fail");
                        resp.sendRedirect("listProduct.jsp");
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
