<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style type="text/css">
form{
margin: 20px;
padding: 10px;

}

input{
padding:5px;
font-size:16px;
width:200px;
height: 30px;
border-radius:10px;
border: 2px solid;
margin:5px;

}


</style>
</head>
<body style="font-size:20px; background:#dedede;" >
<center>

		<p><h1>Connexion</h1>	</p>
		<p style="color:red;font-weight:20px;"><% if(request.getAttribute("error")!=null) out.println(request.getAttribute("error")); %></p>

		
		<hr>
		<form method="post" action="index1" style="font-size:24px;">
			<input type=text placeholder="email" name="email"><br>
			<input type=password placeholder="password" name="password"><br>
			<div >
			<input type=submit value="connecter" name="action" style="width: 100px; background:black;color:white;marign:10px;">
			</div>
		</form>
</center>
</body>
</html>