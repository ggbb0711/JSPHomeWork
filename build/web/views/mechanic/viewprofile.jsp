<%-- 
    Document   : viewprofile
    Created on : Mar 17, 2025, 9:31:19 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>My Profile - GARAGE Management</title>
        <meta name="description" content="Customer Profile Page">
        <meta name="author" content="YourName">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="style/slider.css">
        <link rel="stylesheet" type="text/css" href="style/mystyle.css">
        <link rel="stylesheet" type="text/css" href="source/custon-css/header-customer.css">

        <style>
            .profile-container {
                padding: 30px;
                margin: 20px auto;
                max-width: 600px;
                border: 1px solid #e0e0e0;
                border-radius: 8px;
                background-color: #ffffff;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }

            .profile-section {
                margin-bottom: 25px;
                padding: 20px;
                background-color: #f8f9fa;
                border-radius: 5px;
            }

            .profile-section h2 {
                color: #2c3e50;
                font-size: 1.8em;
                margin-bottom: 20px;
                padding-bottom: 10px;
                border-bottom: 2px solid #3498db;
                font-weight: 600;
            }

            .profile-section p {
                margin: 10px 0;
                font-size: 1.1em;
                color: #444;
                line-height: 1.6;
            }

            .profile-section strong {
                color: #2c3e50;
                font-weight: 600;
                min-width: 130px;
                display: inline-block;
            }

            .profile-section p:not(:last-child) {
                border-bottom: 1px dashed #eee;
                padding-bottom: 10px;
            }

            .edit-btn, .save-btn {
                display: inline-block;
                padding: 10px 20px;
                background-color: #3498db;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .edit-btn:hover, .save-btn:hover {
                background-color: #2980b9;
                color: white;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        

            <div class="allcontain">
                <h1 class="text-center">• MY PROFILE •</h1>

            <c:choose>
                <c:when test="${empty sessionScope.customer}">
                    <p class="text-center">Please login to view your profile.</p>
                </c:when>
                <c:otherwise>
                    <div class="profile-container">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Profile Information -->
                                <div class="profile-section">
                                    <h2>Personal Information</h2>
                                    <p><strong>Customer ID:</strong> ${infor.custID}</p>

                                    <form id="profileForm" action="/JSPHomeWork/mechanic/updateProfile" method="post">
                                        <div class="form-group">
                                            <label for="custName"><strong>Name:</strong></label>
                                            <input type="text" class="form-control" id="custName" name="custName" value="${infor.custName}" required>
                                        </div>
                                        <div class="form-group">
                                          
                                            <input style="display: none" type="text" class="form-control"  name="customerId" value="${infor.custID}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="phone"><strong>Phone:</strong></label>
                                            <input type="text" class="form-control" id="phone" name="phone" value="${infor.phone}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="sex"><strong>Sex:</strong></label>
                                            <select class="form-control" id="sex" name="sex" required>
                                                <option value="M" <c:if test="${fn:trim(infor.sex) == 'M'}">selected</c:if>>Male</option>
                                                <option value="F" <c:if test="${fn:trim(infor.sex) == 'F'}">selected</c:if>>Female</option>

                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="cusAddress"><strong>Address:</strong></label>
                                                <input type="text" class="form-control" id="cusAddress" name="cusAddress" value="${infor.cusAddress}" required>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="save-btn">Save</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Footer -->
       

        <script type="text/javascript" src="source/js/header-customer.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
        <script type="text/javascript" src="source/js/isotope.js"></script>
        <script type="text/javascript" src="source/js/myscript.js"></script> 
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
        <script type="text/javascript">
        </script>
    </body>
</html>