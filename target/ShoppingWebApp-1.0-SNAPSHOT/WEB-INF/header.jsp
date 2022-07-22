   <%@page import="com.Shoppingapp.models.User"%>
<%
       User user = (User)request.getAttribute("loggeduser");
       String message = (String)request.getAttribute("message");
       if (message==null) {
             message="";
        }
   %>
<header>
    <div class="navigation-bar">
        <div class="logo"><h1>Shoppingger</h1></div>
            <div class="navigation-links">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>  
                    <li><a href="fetchproducts">Products</a></li>
                </ul>
            </div>
            <%        
            if (user!=null) {
              %>
              <div class="loggedinview">

              <%= "<h3 style='padding:0 20px;'> Welcome "+user.getName()+"</h3>" %>
              
                 <a href="#" class="cartbutton"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
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