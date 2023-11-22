<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp"%>
<%@include file="utils/navbar.jsp"%>

<h1 class="text-center">Update Customer</h1>
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

    Customer customer = (Customer) session.getAttribute("customer");
%>

<div class="container">
    <form action="customer?action=updateCustomer" method="POST">
        <div class="mb-3">
            <label for="inputID" class="form-label">ID</label>
            <input type="text" class="form-control" id="inputID"
                   name="id" value="<%=customer.getId()%>" readonly
            >
        </div>
        <div class="mb-3">
            <label for="inputFullName" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputFullName"
                   name="name" value="<%=customer.getName()%>" required
            >
        </div>
        <div class="mb-3">
            <label for="inputEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail"
                   name="email" value="<%=customer.getEmail()%>" required
            >
        </div>
        <div class="mb-3">
            <label for="inputPhone" class="form-label">Phone</label>
            <input type="tel" class="form-control" id="inputPhone"
                   name="phone" value="<%=customer.getPhone()%>" required
            >
        </div>
        <div class="mb-3">
            <label for="inputAddress" class="form-label">Address</label>
            <input type="text" class="form-control" id="inputAddress"
                   name="address" value="<%=customer.getAddress()%>" required
            >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="utils/footer.jsp"%>
