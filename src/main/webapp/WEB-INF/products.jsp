<%-- 
    Document   : products
    Created on : Jul 22, 2022, 1:26:31 PM
    Author     : isi
--%>

<%@page import="com.Shoppingapp.models.User"%>
<%@page import="com.Shoppingapp.models.Category"%>
<%@page import="com.Shoppingapp.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Products</title>
        <link rel="stylesheet" href="./css/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    </head>
    <body>
     <%
     String message = (String)request.getAttribute("message");
     if (message==null || message=="") {
             message="";
         }
     String usermessage = (String)request.getAttribute("usermessage");
     if (usermessage==null || usermessage=="") {
             usermessage="";
         }
      String productid = (String)request.getAttribute("productid");

     %>
        <jsp:include page="header.jsp" />
        <%
           
           ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
           ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");

        %>
        <div class="productmain">
        <div class="category-container">
            <%
            if (categoryList!=null) {
            %>
            <a href='?categoryid=all'>All</a>
            <%
            for (Category category : categoryList) {
            %>
            <a href='?categoryid=<%= category.getCategoryId() %>'/><%= category.getCategoryName() %></a>
            <%
            } 
            }   
        %>  
        </div>
        <div class="product-container">
        <%
            if (productList !=null) {
            for (Product product : productList) {
        %>
        <div class="product">
            <img src="./images/<%= product.getProductImagePath() %>" alt="productimg"/>
            <h2><%= product.getProductName() %></h2>
            <p><%= product.getProductDescription()%></p>
            <p class="price">$ <%= product.getProductPrice()%></p>
            <a href="products?productid=<%=product.getProductId()%>" class="cartbuttonn">Add to cart</a>
            <%
               if (productid!=null) {
                       
                       if (Integer.parseInt(productid) == product.getProductId()) {
                           %>
                             <small style="padding: 20px;color:red;" ><%= message %></small>
                           <%
                        }
                   }
            %>
            
          
            <small style="padding: 20px;" style="color: red;"><%= usermessage %></small>
        </div> 
        <%
            }
            }  
            
        %>
        </div>
        
        </div>
        <jsp:include page="footer.jsp" />

    </body>
</html>
