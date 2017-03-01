<%@page import="com.etascioglu.dao.SiparisDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.etascioglu.model.Urun" %>
<%@page import="com.etascioglu.dao.KategoriDAO" %>
<%@page import="com.etascioglu.dao.UrunDAO" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sepetim</title>
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
			<div class="col-md-2">
			<a href="/webeticaret/index.jsp">
  				<img src="sepet.png" alt="logo_sepeti">
			</a>
			</div>
			<div class="col-md-6">
				<input type="text" class="form-control">
			</div>
			<div class="col-md-4">
				<div class="btn-group pull-right" role="group" aria-label="...">
					
					<div class="btn-group">
					<button type="button" class="btn btn-default custom-btn-group" data-toggle="dropdown">
					Hesabım <span class="caret"></span></button>
					<ul class="dropdown-menu" role="menu">
					<li><a href="#">Hesabım</a></li>
					<li><a href="#">Alışveriş Listem</a></li>
					<li><a href="#">Sepetim</a></li>
					<li><a href="#">Kasaya Git</a></li>
					</ul>
					</div>			 
					<a href="/webeticaret/Sepetim.jsp" type="button" class="btn btn-default custom-btn-group">Sepetim</a>	
					<button type="button" class="btn btn-default custom-btn-group">Giriş Yapın</button>
	
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
					<% if(session.getAttribute("eposta") != null ){%>
						<label>SEPETİNİZ !</label><label><%= session.getAttribute("eposta") %></label>
					<%} %>
					
					</div>
				</nav>
			</div>	
		</div>		
	</div>
	
	
						<%int i=0;%>
						<%int toplam=0;%>
						<%for(Urun urun :  new SiparisDAO().siparisgoster((int)session.getAttribute("kullanici_id"))) { %>		
						<p>Seçtiniz Ürünler </p>				
						<ul class="list-group">
						
  									<li class="list-group-item"><a  href="sepettencikar?urunid=<%=urun.getId()%>"></a></li>
  									<li class="list-group-item"><p><%=urun.getisim()%></p>	</li>
  									<li class="list-group-item"><p><%=urun.getaciklama()%></p></li>
  									<li class="list-group-item"><p><%=urun.getfiyat()%></li>				
						</ul>
					<% } %> <br>
	</body>
    