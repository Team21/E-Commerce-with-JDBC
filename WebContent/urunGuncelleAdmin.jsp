<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ürün Guncelle-ADMİN !</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Ürün Guncelel-ADMİN !</h3>
                    </div>
                    <div class="panel-body">                   	
                        <form role="form" method="post" action="/webeticaret/Urunguncelle" enctype="multipart/form-data">
                            <fieldset>                                 
								<div class="form-group">
                                    <input class="form-control" placeholder="İsim" name="isim" type="text" autofocus>
                                </div>
								<div class="form-group">
                                    <input class="form-control" placeholder="Fiyat" name="fiyat" type="text" autofocus>
                                </div>
								<div class="form-group">
                                    <input class="form-control" placeholder="Aciklama" name="aciklama" type="text" autofocus>
                                </div>     
                                <div class="form-group">
                                    <input class="form-control" placeholder="Resim" name="resim" type="text" autofocus>
                                </div>                   
                                <button type="submit" class="btn btn-lg btn-success btn-block">Ürün Guncelle</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>    
      </div>
</body>
</html>
