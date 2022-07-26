   <%@page import="com.Shoppingapp.models.User"%>
<%
       User user = (User)session.getAttribute("loggeduser");
       String message = (String)request.getAttribute("message");
       if (message==null) {
             message="";
        }
        if (user!=null) {
            session.setAttribute("loggeduser", user);
        }
   %>
<header>
    <div class="navigation-bar">
        <div class="logo"><h1>Shoppingger</h1></div>
            <div class="navigation-links">
                <ul>
                    <li><a href="/ShoppingWebApp">Home</a></li>
                    <%
                        if(user!=null){
                        
                        
                    %>
                    <li><a href="checkout?vieworder=true">Orders</a></li>  
                    <%
                    }
                    %>
                    <li><a href="products">Products</a></li>
                </ul>
            </div>
            <%        
            if (user!=null) {
              %>
              <div class="loggedinview">

              <%= "<h3 style='padding:0 20px;'> Welcome "+user.getName()+"</h3>" %>
              
              <a href="cart" class="cartbutton" style="margin-right: 10px"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
              <a href="logout" class="cartbutton">Log out</a>

            </div>
              <%
                }     
             %>
            <%
                    if (user==null) {              
            %>
            <div class="loggedoutview">
                 <a href="login" class="login">Login</a>
                 <a href="signup" class="register">Register</a>
            </div>   
            <%
            }
            %>
    </div>
</header>