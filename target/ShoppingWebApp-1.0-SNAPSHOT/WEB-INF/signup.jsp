
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App | Signup</title>
        <link rel="stylesheet" href="./css/style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    </head>
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
            <form class="form" action="signup" method="post">
                <h3>Signup</h3>
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
                <div class="form-field">
                    <label>Confirm Password</label>
                    <br>
                    <input type="password" name="confirmpassword"/>
                </div>
                <div class="form-field">
                    <label>Name</label>
                    <br>
                    <input type="name" name="name"/>
                </div>
                <div class="form-field">
                    <label>Date of birth</label>
                    <br>
                    <input type="date" name="dateofbirth"/>
                </div>
                <small style="color: red;"><%= message %></small>
                 <div class="form-field">
                    <input type="submit" name="dateofbirth"/>
                </div>
                
            </form> 
        </div> 
            </div>
        
    </body>
</html>
