<%-- 
    Document   : login
    Created on : 08-Mar-2025, 09:00:43
    Author     : bluax
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    </head>
    <body class="screen-container">
        <div class="login-card">
            <h1>LOGIN AS A SALE PERSON</h1>
            <form action="${pageContext.request.contextPath}/login/sales-person" method="POST" accept-charset="utf-8" >
                <p><input type="text" name="txtname" required="" placeholder="enter name" ></p>
                <p><input style="margin-top: 4px" class="form-submit-btn" type="submit" value ="login" ></p>
            </form>
            <p>
                <%
                    if(request.getAttribute("error")!=null){
                        out.print(request.getAttribute("error"));
                    }
                %>
            </p>
            <a href="${pageContext.request.contextPath}">
                <button style="margin-top: 4px" class="btn btn-primary">Login as a different user</button>
            </a>
        </div>
    </body>
</html>
