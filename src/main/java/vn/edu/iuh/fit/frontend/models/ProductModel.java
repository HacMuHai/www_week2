package vn.edu.iuh.fit.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.services.OrderService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ProductModel {
    private ProductService productService;

    public ProductModel() {
        productService = new ProductService();
    }


    public void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id").trim();
        Product product= productService.findByID(Long.parseLong(id)).get();

        Object obj = req.getSession().getAttribute("listProductCart");
        Map<Product, Integer> listProductCart = null;

        if(obj == null){
            listProductCart = new HashMap<>();
        }else{
            listProductCart = (Map<Product, Integer>) obj;
        }

        if(listProductCart.get(product) != null){
            int quantity = listProductCart.get(product);
            listProductCart.put(product,quantity+1);
        }else
            listProductCart.put(product,1);


        req.getSession().setAttribute("listProductCart",listProductCart);
        resp.sendRedirect("listProduct.jsp");
    }

    public void deleteProductCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Product product = productService.findByID(Long.parseLong(id)).get();

        Map<Product,Integer> lst = (Map<Product, Integer>) req.getSession().getAttribute("listProductCart");
        lst.remove(product);
        req.getSession().setAttribute("listProductCart",lst);
        resp.sendRedirect("listProductInCart.jsp");
    }

}
