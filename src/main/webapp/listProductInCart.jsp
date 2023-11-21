<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="vn.edu.iuh.fit.backend.services.ProductService" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 11/20/2023
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="utils/header.jsp" %>
<%@include file="utils/navbar.jsp" %>

<%
    Map<Product, Integer> listProductCart = (Map<Product, Integer>) session.getAttribute("listProductCart");
    ProductService productService = new ProductService();
    DecimalFormat df = new DecimalFormat("#.##");
%>
<section class="h-100 h-custom" style="background-color: #d2c9ff;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-8">
                                <div class="p-5">
                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                        <h6 class="mb-0 text-muted"><%=listProductCart == null ? 0 : listProductCart.size()%>
                                            items</h6>
                                    </div>
                                    <hr class="my-4">

                                    <%
                                        double total = 0;
                                        if (listProductCart != null) {
                                            for (Map.Entry<Product, Integer> entry : listProductCart.entrySet()) {
                                                Product product = entry.getKey();
                                                double price = productService.getPrice(product.getProductId());
                                                int quantiy = entry.getValue();
                                                total += price * quantiy;
                                    %>
                                    <div class="row mb-4 d-flex justify-content-between align-items-center">
                                        <div class="col-md-2 col-lg-2 col-xl-2">
                                            <img
                                                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp"
                                                    class="img-fluid rounded-3" alt="id=<%=product.getProductId()%>">
                                        </div>
                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                            <h6 class="text-black mb-0"><%=product.getName()%></h6>
                                        </div>
                                        <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                            <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                <i class="fas fa-minus"></i>
                                            </button>

                                            <input id="form1" min="0" name="quantity" value="<%=quantiy%>"
                                                   type="number"
                                                   class="form-control form-control-sm"/>

                                            <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>
                                        <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                            <h6 class="mb-0">€ <%=df.format(price)%>
                                            </h6>
                                        </div>
                                        <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                            <a href="product?action=deleteProductCart&id=<%=product.getProductId()%>" class="text-muted">x</a>
                                        </div>
                                    </div>

                                    <hr class="my-4">
                                    <%
                                            }
                                        }
                                    %>


                                    <div class="pt-5">
                                        <h6 class="mb-0"><a href="product?action=listProduct" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 bg-grey">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-4">
                                        <h5 class="text-uppercase">
                                            items <%=listProductCart == null ? 0 : listProductCart.size()%>
                                        </h5>
                                        <h5>€ <%=df.format(total)%>
                                        </h5>
                                    </div>

                                    <h5 class="text-uppercase mb-3">Shipping</h5>

                                    <div class="mb-4 pb-2">
                                        <label class="form-label">€5.00</label>
                                        <%--                                        <select class="select">--%>
                                        <%--                                            <option value="1">Standard-Delivery- €5.00</option>--%>
                                        <%--                                            <option value="2">Two</option>--%>
                                        <%--                                            <option value="3">Three</option>--%>
                                        <%--                                            <option value="4">Four</option>--%>
                                        <%--                                        </select>--%>
                                    </div>

                                    <h5 class="text-uppercase mb-3">Give code</h5>

                                    <div class="mb-5">
                                        <div class="form-outline">
                                            <input type="text" id="form3Examplea2"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Examplea2">Enter your code</label>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-5">
                                        <h5 class="text-uppercase">Total price</h5>
                                        <h5>€ <%=df.format(total + 5)%>
                                        </h5>
                                    </div>
                                    <button type="submit" class="btn btn-dark btn-block btn-lg"
                                            data-mdb-ripple-color="dark" formaction="order?action=checkout"
                                            formmethod="post"
                                    >Check Out </button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="utils/footer.jsp" %>
