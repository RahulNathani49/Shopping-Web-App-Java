<%-- 
    Document   : orders
    Created on : Jul 27, 2022, 2:08:17 AM
    Author     : isi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.Shoppingapp.models.OrderHistory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Orders</title>
<link rel="stylesheet" href="./css/style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>    </head>
    <body>
        <%
            ArrayList<OrderHistory> historylist = (ArrayList<OrderHistory> )request.getAttribute("orderhistorylist");
        %>
        <jsp:include page="header.jsp" />
        
        <div class="ordercontainer">
            <h3>Your previous orders</h3>
            <div class="underline"></div>
            <%
                if (historylist!=null) {
                 for (OrderHistory history : historylist) {
                         
                     
 
                  
            %>
                
                <div class="orders">
                    <p>Order number #<%= history.getOrderid() %></p>
                    <p>Total items purchased <%= history.getOrdercount() %></p>
                    <p>Amount paid $<%= history.getTotal() %></p>
                    <p>Date <%= history.getDate() %></p>
                </div>
            </div>
            <%
                }
              }
            %>
        <jsp:include page="footer.jsp" />

    </body>
</html>
