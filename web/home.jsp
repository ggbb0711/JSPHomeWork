<%-- 
    Document   : home
    Created on : Mar 16, 2025, 1:54:10 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Scarica gratis GARAGE Template html/css - Web Domus Italia - Web Agency </title>
        <meta name="description" content="Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE può fare per voi. Web Domus Italia">
        <meta name="author" content="Web Domus Italia">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="style/slider.css">
        <link rel="stylesheet" type="text/css" href="style/mystyle.css">
        <link rel="stylesheet" type="text/css" href="source/custon-css/header-customer.css">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="common/header.jsp"></jsp:include>
            <!-- Header -->
            <!--_______________________________________ Carousel__________________________________ -->
        <jsp:include page="common/Carousel.jsp"></jsp:include>
            <!-- ____________________Featured Section ______________________________--> 
            <div class="allcontain">

                <!-- ________________________LATEST CARS SECTION _______________________-->
                <div class="latestcars">
                    <h1 class="text-center">&bullet; LATEST   CARS &bullet;</h1>
                    <ul class="nav nav-tabs navbar-left latest-navleft">
                        <li role="presentation" class="li-sortby"><span class="sortby">SORT BY: </span></li>
                        <li data-filter=".RECENT" role="presentation"><a href="#mostrecent" class="prcBtnR">MOST RECENT </a></li>
                        <li data-filter=".POPULAR" role="presentation"><a href="#mostpopular" class="prcBtnR">MOST POPULAR </a></li>
                        <li  role="presentation"><a href="#" class="alphSort">ALPHABETICAL </a></li>
                        <li data-filter=".HPRICE" role="presentation"><a href="#" class="prcBtnH">HIGHEST PRICE </a></li>
                        <li data-filter=".LPRICE" role="presentation"><a href="#" class="prcBtnL">LOWEST  PRICE </a></li>
                        <li id="hideonmobile">
                    </ul>
                </div>
                <br>
                <br>

                <div class="grid">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                            <div class="txthover">
                                <img src="image/car1.jpg" alt="car1">
                                <div class="txtcontent">
                                    <div class="stars">
                                        <div class="glyphicon glyphicon-star"></div>
                                        <div class="glyphicon glyphicon-star"></div>
                                        <div class="glyphicon glyphicon-star"></div>
                                    </div>
                                    <div class="simpletxt">
                                        <h3 class="name">Rolls Royce</h3>
                                        <p>"Lorem ipsum dolor sit amet, consectetur,<br>
                                            sed do eiusmod tempor incididunt" </p>
                                        <h4 class="price"> 1000&euro;</h4>
                                        <button>READ MORE</button><br>
                                        <div class="wishtxt">
                                            <p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
                                            <p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
                                        </div>
                                    </div>
                                    <div class="stars2">
                                        <div class="glyphicon glyphicon-star"></div>
                                        <div class="glyphicon glyphicon-star"></div>
                                        <div class="glyphicon glyphicon-star"></div>
                                    </div>
                                </div>
                            </div>	 
                        </div>

                    </div>
                </div>

            <jsp:include page="common/footer.jsp"></jsp:include>
        </div>
        <script type="text/javascript" src="source/js/header-customer.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
        <script type="text/javascript" src="source/js/isotope.js"></script>
        <script type="text/javascript" src="source/js/myscript.js"></script> 
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
        <script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    </body>
</html>