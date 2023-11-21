<%@ page import="vn.edu.iuh.fit.backend.repositories.CustomerRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.services.EmployeeService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="vn.edu.iuh.fit.backend.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.backend.services.OrderService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Order" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp" %>
<%@include file="utils/navbar.jsp" %>

<h1 class="text-center">Page list Product</h1>
<%
    String mess = (String) session.getAttribute("mess");
    if (mess != null) {
%>
<div>
    <h2 class="text-primary"><%=mess%>
    </h2>
</div>
<%
    }
    session.removeAttribute("mess");

    ProductService productService = new ProductService();
    DecimalFormat df = new DecimalFormat("#.##");
    List<Product> lst = productService.getAll();

%>
<table width="85%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Unit</th>
        <th colspan="2"><a href="product?action=addProduct">Insert</a></th>
    </tr>
    <% for (Product product : lst) {%>
    <tr>
        <td><%=product.getProductId()%> </td>
        <td><%=product.getName()%> </td>
        <td><%=df.format(productService.getPrice(product.getProductId()))%></td>
        <td><%=product.getManufacturer()%> </td>
        <td><%=product.getUnit()%></td>
        <td>
            <a href="product?action=openUpdateProduct&id=<%=product.getProductId()%>">Update</a>
            <a href="product?action=deleteProduct&id=<%=product.getProductId()%>">Delete</a>
        </td>
        <td><a href="product?action=addToCart&id=<%=product.getProductId()%>">Add to Cart</a></td>
    </tr>
    <%}%>
</table>
<%@include file="utils/footer.jsp" %>
