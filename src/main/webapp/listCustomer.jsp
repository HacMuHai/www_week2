<%@ page import="vn.edu.iuh.fit.backend.repositories.CustomerRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>

<h1 style="font-size: 16px">Page list Customer</h1>

<%
    CustomerRepository customerRepository = new CustomerRepository();
    List<Customer> lst = customerRepository.getAll();

%>
<table width="95%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th><a href="Employees/insertEmp.jsp">Insert</a> </th>
    </tr>
    <% for(Customer cus:lst){%>
    <tr>
        <td><%=cus.getId()%></td>
        <td><%=cus.getName()%></td>
        <td><%=cus.getAddress()%></td>
        <td><%=cus.getPhone()%></td>
        <td><%=cus.getEmail()%></td>
        <td>
            <a href="">Update</a>
            <a href="">Delete</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
