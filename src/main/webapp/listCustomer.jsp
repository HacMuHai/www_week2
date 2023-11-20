<%@ page import="vn.edu.iuh.fit.backend.repositories.CustomerRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.services.EmployeeService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="vn.edu.iuh.fit.backend.services.CustomerService" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp"%>
<%@include file="utils/navbar.jsp"%>

<h1 class="text-center">Page list Customer</h1>
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

    CustomerService customerService = new CustomerService();
    List<Customer> lst = customerService.getAll();


%>
<table width="95%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th><a href="addCustomer.jsp">Insert</a> </th>
    </tr>
    <% for(Customer cus:lst){%>
    <tr>
        <td><%=cus.getId()%></td>
        <td><%=cus.getName()%></td>
        <td><%=cus.getAddress()%></td>
        <td><%=cus.getPhone()%></td>
        <td><%=cus.getEmail()%></td>
        <td>
            <a href="customer?action=updateCustomer&id=<%=cus.getId()%>">Update</a>
            <a href="">Details</a>
        </td>
    </tr>
    <%}%>
</table>
<%@include file="utils/footer.jsp"%>
