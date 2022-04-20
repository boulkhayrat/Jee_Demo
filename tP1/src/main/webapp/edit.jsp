<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>

</head>
<body style="font-size:20px; background:#dedede;" >
<center>

		<p><h1>Modification</h1></p>
		
		<hr>
		
		<form method="post" action="index">
			<input type=text value="${l.isbn }" name="isbn"><br>
			<input type=text value="${l.titre }" name="titre"><br>
			<input type=text value="${l.description }" name="description"><br>
			<input type=text value=" ${l.date_editing }" name="date"><br>
			<p>Veuillez Choisir l'Editeur  :</p>
			  <div>
			    <input type="radio" id="ENI"
			     name="editeur" value="ENI">
			    <label for="ENI">ENI</label>
			
			    <input type="radio" id="DUNOND"
			     name="editeur" value="DUNOND">
			    <label for="DUNOND">DUNOND</label>
				<br>
			<input type=text value="${l.matricule }" name="matricule"><br>
			<input type=submit value="modifier" name="action">
		</form>
</center>
</body>
</html>