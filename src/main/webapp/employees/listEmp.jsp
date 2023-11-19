<%@ page import="vn.edu.iuh.fit.backend.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List employee</title>
</head>
<body>
<h1 style="font-size: 16px">Page list Employee</h1>
<%
    EmployeeRepository employeeRepository = new EmployeeRepository();
    List<Employee> lst = employeeRepository.getAllEmp();

%>
<table width="95%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Birthday</th>
        <th><a href="insertEmp.jsp">Insert</a> </th>
    </tr>
    <% for(Employee emp:lst){%>
    <tr>
        <td><%=emp.getId()%></td>
        <td><%=emp.getFullName()%></td>
        <td><%=emp.getAddress()%></td>
        <td><%=emp.getPhone()%></td>
        <td><%=emp.getEmail()%></td>
        <td><%=emp.getDob()%></td>
        <td>
            <a href="">Update</a>
            <a href="">Delete</a>
        </td>
        <td>
            <a href="">Order</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
