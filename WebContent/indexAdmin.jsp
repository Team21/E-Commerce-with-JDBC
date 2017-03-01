<%@page import="com.etascioglu.dao.KategoriDAO" %>
<%@page import="com.etascioglu.dao.UrunDAO" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setAttribute("urunler", new UrunDAO().tumUrunler()); %>
<% request.setAttribute("kategoriler", new KategoriDAO().tumKatagoriler()); %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Ana-Sayfa-ADMİN !</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="foy3.css">
	<script>
	$(window).scroll(function(){
    if ($(this).scrollTop() > 50)   
        $("#yukari").fadeIn(1000);   
    else 
        $("#yukari").fadeOut(500);    
	});
	$(document).ready(function(){
    $("#yukari").click(function(){    
        $("html, body").animate({ scrollTop: "0" }, 500);  
        return false;
    });
	});
	</script>
</head>
<body>
	
	<div class="container content">
		<div class="row">
			<div class="col-md-1">
			<a href="/webeticaret/index.jsp">
  				<img src="sepet.png" alt="logo_sepeti">
			</a>
			</div>
			<div class="col-md-4">
				<input type="text" class="form-control">
			</div>
			<div class="col-md-7">
				<div class="btn-group pull-right" role="group" aria-label="...">
					<div class="btn-group">
					<button type="button" class="btn btn-warning custom-btn-group" data-toggle="dropdown"> Hesabım <span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
					<li><a href="/webeticaret/error.html">Hesabım</a></li>
					<li><a href="/webeticaret/error.html">Alışveriş Listem</a></li>
					<li><a href="/webeticaret/Sepetim.jsp">Sepetim</a></li>
					<li><a href="/webeticaret/error.html">Kasaya Git</a></li>
					</ul>
					</div>
		     		<a href="/webeticaret/Sepetim.jsp" type="button" class="btn btn-warning custom-btn-group">Sepetim</a>
		     		<a href="/webeticaret/urunEkleAdmin.jsp" type="button" class="btn btn-info custom-btn-group">Ürün Ekle</a>
		     		<a href="/webeticaret/urunGuncelleAdmin.jsp" type="button" class="btn btn-info custom-btn-group">Ürün Güncelle</a>
					<a href="/webeticaret/register.html" type="button" class="btn btn-danger custom-btn-group">Hala Kayıt Olmadın mı?</a>			
					<a href="/webeticaret/login.html" type="button" class="btn btn-danger custom-btn-group">Giriş Yapın</a>
					<a href="/webeticaret/Cikis" type="button" class="btn btn-danger custom-btn-group">ÇIKIŞ !</a>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12 ">
				<nav class="navbar navbar-default custom-navbar ">		
					<div class="navbar-header">
					<button type="button" class="btn glyphicon glyphicon-home navbar-btn custom-button"></button>
					<button type="button" class="btn navbar-btn custom-button">ANNE,BEBEK,OYUNCAK</button>
					<button type="button" class="btn navbar-btn custom-button">BİLGİSAYAR ÜRÜNLERİ</button>
					<button type="button" class="btn navbar-btn custom-button">ELEKTRONİK,BİLGİSAYAR,TELEFON</button>
					</div>
				</nav>
			</div>	
		</div>
		<div class="row">
			<div class="col-md-1">
				<div class="box-heading"><span>KATEGORİLER</span></div>
				<table class="table table-hover">  
				<tbody> 
				 <c:forEach items="${kategoriler}" var="kategori">
			           <tr><td><a href="#">${kategori.isim}</a></td></tr> 
			     </c:forEach>						
				</tbody> 
				</table>				
			</div>
			<div class="box-heading"><span></span></div>
				<div class="row">
					<div class="col-lg-1">
						<div class="box-heading">
							<center>
								<c:forEach items="${urunler}" var="urun">
				            	<%-- <tr><td><p>${urun.isim}</p></td></tr>   --%>
				            	 <%--  <h4 class="renk">${urun.resim}</h4>   --%>
				            	 
				          	   		<h1 class="renk">${urun.isim}</h1>
				          	   		<h3 class="renk">${urun.aciklama}</h3>
				          	   		<h2 class="renk">${urun.fiyat}</h2>  	   	
				          	  		<a  href="/SepeteEkle?id=${urun.id}" class="btn btn-success custom-btn-group" role="button">Sepete Ekle</a>
				          	  		
				      	    	</c:forEach>
				      	    </center>	
				      	</div>
				    </div>
				</div>	
			</div>
			<div class="col-md-12">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">	
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
					<li data-target="#myCarousel" data-slide-to="5"></li>
					<li data-target="#myCarousel" data-slide-to="6"></li>
				</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="reklam1.png" alt="reklam1">
				</div>
				<div class="item">
					<img src="reklam2.png" alt="reklam2">
				</div>

				<div class="item">
					<img src="reklam3.png" alt="reklam3">
				</div>

				<div class="item">
					<img src="reklam4.png" alt="reklam4">
				</div>
				
				<div class="item">
					<img src="reklam5.png" alt="reklam5">
				</div>
				
				<div class="item">
					<img src="reklam6.png" alt="reklam6">
				</div>
				
				<div class="item">
					<img src="reklam7.jpg" alt="reklam7">
				</div>
			</div>
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			
	</div>
    