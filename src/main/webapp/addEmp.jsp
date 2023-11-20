<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/17/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp"%>
<%@include file="utils/navbar.jsp"%>

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
%>

<div class="container">
    <form action="employee?action=addEmp" method="POST">
        <div class="mb-3">
            <label for="inputFullName" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputFullName"
                   name="name" required
            >
        </div>
        <div class="mb-3">
            <label for="inputDob" class="form-label">Date of Birthday</label>
            <input type="date" class="form-control" id="inputDob"
                   name="dob" required
            >
        </div>
        <div class="mb-3">
            <label for="inputEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail"
                   name="email" required
            >
        </div>
        <div class="mb-3">
            <label for="inputPhone" class="form-label">Phone</label>
            <input type="tel" class="form-control" id="inputPhone"
                   name="phone" required
            >
        </div>
        <div class="mb-3">
            <label for="inputAddress" class="form-label">Address</label>
            <input type="text" class="form-control" id="inputAddress"
                   name="address" required
            >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="utils/footer.jsp"%>
