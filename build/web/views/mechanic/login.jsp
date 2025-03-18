<%-- 
    Document   : login
    Created on : Mar 15, 2025, 12:13:39 PM
    Author     : USER
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đăng nhập</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .login-container {
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 350px;
            }
            h2 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
                color: #555;
            }
            input[type="text"], 
            input[type="tel"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
            }
            .btn-submit {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
                margin-top: 10px;
            }
            .btn-submit:hover {
                background-color: #45a049;
            }
            .error-message {
                color: red;
                font-size: 14px;
                margin-top: 5px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Đăng Nhập</h2>

            <!-- Hiển thị thông báo lỗi nếu có -->
            <c:if test="${not empty msg}">
                <div class="error-message">${msg}</div>
            </c:if>

            <form action="${pageContext.request.contextPath}/login/customer" method="post">
                <div class="form-group">
                    <label for="name">Họ và tên:</label>
                    <input type="text" id="name" name="name" required>
                </div>

                <div class="form-group">
                    <label for="phone">Số điện thoại:</label>
                    <input type="tel" id="phone" name="phone" required>
                </div>

                <button type="submit" class="btn-submit">Đăng Nhập</button>

            </form>
            <a href="${pageContext.request.contextPath}">
               <button style="margin-top: 4px" class="btn btn-primary">Login as a different user</button>
            </a>
        </div>

        <script>
            document.querySelector('form').addEventListener('submit', function (e) {
                const phoneInput = document.getElementById('phone');
                const phonePattern = /^[0-9]{9}$/;
                const errorMessage = document.querySelector('.error-message');

                if (!phonePattern.test(phoneInput.value)) {
                    e.preventDefault();
                    errorMessage.innerText = 'Vui lòng nhập số điện thoại hợp lệ (9 số)';
                    errorMessage.style.display = 'block';
                    phoneInput.focus();
                }
            });
        </script>
    </body>
</html>