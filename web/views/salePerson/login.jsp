<%-- 
    Document   : login
    Created on : 08-Mar-2025, 09:00:43
    Author     : bluax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="loginServlet" accept-charset="utf-8">
            <p><input type="text" name="txtname" required="" placeholder="enter name" ></p>
            <p><input type="submit" value ="login" ></p>
        </form>
        <p>
            <%
                if(request.getAttribute("error")!=null){
                    out.print(request.getAttribute("error"));
                }
            %>
        </p>
    </body>
</html>
