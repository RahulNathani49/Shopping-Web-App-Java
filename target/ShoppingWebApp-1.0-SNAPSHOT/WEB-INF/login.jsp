

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Login</title>
        <link rel="stylesheet" href="./css/style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
       <%
       String message = (String)request.getAttribute("message");
       if (message==null) {
             message="";
        }
   %>
    <body>
        <jsp:include page="header.jsp" />
        <div class="form-bg">
        <div class="form-container">
            <form class="form" action="login" method="post">
                <h3>Login</h3>
                <div class="form-field">
                    <label>Username</label>
                    <br>
                    <input type="text" name="username"/>
                </div>
               <div class="form-field">
                    <label>Password</label>
                    <br>
                    <input type="password" name="password"/>
                </div>
 
                <small style="color: red;"><%= message %></small>
                 <div class="form-field">
                    <input type="submit"  value="Login"/>
                </div>
                
            </form> 
        </div> 
            </div>
        
    </body>
</html>
