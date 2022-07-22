<%-- 
    Document   : products
    Created on : Jul 22, 2022, 1:26:31 PM
    Author     : isi
--%>

<%@page import="com.Shoppingapp.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Products</title>
    </head>
    <body>
        <%
           ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
        %>
        <%
            for (Product product : productList) {
            %>
            <%= product.getProductName() %>
            <%
            }
        %>
    </body>
</html>
