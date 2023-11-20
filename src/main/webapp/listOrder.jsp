<%@ page import="vn.edu.iuh.fit.backend.repositories.CustomerRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.services.EmployeeService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="vn.edu.iuh.fit.backend.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.backend.services.OrderService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Order" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp" %>
<%@include file="utils/navbar.jsp" %>

<h1 class="text-center">Page list Order</h1>
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

    OrderService orderService = new OrderService();
    List<Order> lst;
    String customerId = (String) session.getAttribute("customerId");
    String empId = (String) session.getAttribute("employeeId");
    if (customerId != null) {
        lst = orderService.getOrderByCustomerId(Long.parseLong(customerId));
        session.removeAttribute("customerId");
    } else if (empId != null) {
        lst = orderService.getOrderByEmployeeId(Long.parseLong(empId));
        session.removeAttribute("employeeId");
    } else {
        lst = orderService.getAll();
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
%>
<table width="85%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Customer</th>
        <th>Employee</th>
    </tr>
    <% for (Order order : lst) {%>
    <tr>
        <td><%=order.getOrderId()%>
        </td>
        <td><%=order.getOrderDate().format(formatter)%>
        </td>
        <td><%=order.getCustomer().getName()%>
        </td>
        <td><%=order.getEmployee().getFullName()%>
        </td>
        <td><a href="order?action=orderDetails&id=<%=order.getOrderId()%>">Details</a></td>
    </tr>
    <%}%>
</table>
<%@include file="utils/footer.jsp" %>
