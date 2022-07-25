<%-- 
    Document   : cart
    Created on : Jul 24, 2022, 10:00:21 PM
    Author     : isi
--%>

<%@page import="com.Shoppingapp.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Shoppingapp.models.UserCartItems"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Your Cart</title>
        <link rel="stylesheet" href="./css/style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%
        ArrayList<UserCartItems> usercartitems = (ArrayList<UserCartItems>)request.getAttribute("usercartitems");
        User user = (User)session.getAttribute("loggeduser");
        session.setAttribute("loggeduser", user);
        %>
        <div class="cartcontainer">
            <h3>Your Cart </h3>
            <div class="underline"></div>
             <%
                  if (usercartitems!=null) {
                        for (UserCartItems items : usercartitems) {
                                
                        
                    %>
            <div class="cartitem">
                    <div class="productimg">
                        <img src="./images/<%= items.getImage() %>" alt="image"/>
                    </div>
                <div class="description">
                    <form action="cart?productid=<%= items.getProductId() %>&cartid=<%= items.getCartid()  %>" method="get">
                        <h3><%= items.getProductName()%></h3>
                        <div class ="quantityadjust">
                            <input  type="submit" value="-" name="action">
                            <input type="number" name="quantity" value="<%= items.getQuantity()%>" disabled="">
                            <input type="submit" value="+" name="action">
                        </div>
                        <h3>$<%= items.getTotal() %></h3>
                    </form>
                </div>
            </div>
                           <%
                        }
                  }
                  %>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
