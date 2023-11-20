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
<%@ page import="vn.edu.iuh.fit.backend.models.OrderDetail" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp"%>
<%@include file="utils/navbar.jsp"%>

<h1 class="text-center">Page list Order Datails</h1>
<%
    String mess = (String) session.getAttribute("mess");
    if (mess != null){
%>
<div>
    <h2 class="text-primary"><%=mess%></h2>
</div>
<%
    }
    session.removeAttribute("mess");

    String id = (String) session.getAttribute("id");

    OrderService orderService = new OrderService();
    List<OrderDetail> lst = orderService.getOrderDetailByOrderID(Long.parseLong(id));

%>
<h3>OrderID=<%=id%></h3>
<table width="75%" align="center" border="1">
    <tr>
        <th>ProductID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Amount</th>
        <th>Note</th>
      </tr>
    <%
        double total = 0;
        double amount = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for(OrderDetail orderDetail:lst){
            amount = orderDetail.getPrice() * orderDetail.getQuantity();
            total += amount;

    %>
    <tr>
        <td><%=orderDetail.getProduct().getProductId()%></td>
        <td><%=orderDetail.getProduct().getName()%></td>
        <td><%=df.format(orderDetail.getPrice())%></td>
        <td><%=orderDetail.getQuantity()%></td>
        <td><%=df.format(amount)%></td>
        <td><%=orderDetail.getNote()%></td>
<%--        <td> <a href="order?action=orderDetails&id=<%=orderDetail.getOrderId()%>">Details</a></td>--%>
    </tr>
    <%}%>
    <tr>
        <td colspan="4" class="text-right"><strong class="d-inline-block mr-2">Total</strong></td>
        <td colspan="3" class="text-left ml-5"><%=df.format(total)%></td>
    </tr>
</table>
<%@include file="utils/footer.jsp"%>
