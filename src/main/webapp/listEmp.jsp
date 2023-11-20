<%@ page import="vn.edu.iuh.fit.backend.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.services.EmployeeService" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp"%>
<%@include file="utils/navbar.jsp"%>

<h1 class="text-center">Page list Employee</h1>
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

    EmployeeService employeeService = new EmployeeService();
    List<Employee> lst = employeeService.getAllEmp();

%>
<table width="95%" align="center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Address</th>
        <th><a href="addEmp.jsp">Insert</a> </th>
    </tr>
    <% for(Employee emp:lst){%>
    <tr>
        <td><%=emp.getId()%></td>
        <td><%=emp.getFullName()%></td>
        <td><%=emp.getPhone()%></td>
        <td><%=emp.getEmail()%></td>
        <td><%=emp.getDob()%></td>
        <td><%=emp.getAddress()%></td>
        <td>
            <a href="employee?action=updateEmp&id=<%=emp.getId()%>">Update</a>
            <a href="#">Delete</a>
        </td>
        <td>
            <a href="#">Order</a>
        </td>
    </tr>
    <%}%>
</table>
<%@include file="utils/footer.jsp"%>