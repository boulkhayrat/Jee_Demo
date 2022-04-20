<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
</head>
<body style="font-size:20px;">
<center>
		<p><h1>Modification</h1></p>
		
		<hr>
		
		<form method="post" action="indexa">
			<input type=text value="${l.matricule }" name="matricule"><br>
			<input type=text value="${l.nom }" name="nom"><br>
			<input type=text value="${l.prenom }" name="prenom"><br>
			<p>Veuillez Choisir le Genre de Cet Auteur :</p>
			  <div>
			    <input type="radio" id="Masculin"
			     name="genre" value="Masculin">
			    <label for="Masculin">Masculin</label>
			
			    <input type="radio" id="Feminin"
			     name="genre" value="Feminin">
			    <label for="Feminin">Feminin</label>
				<br>
		
			<input type=submit value="modifier" name="action">
		</form>
</center>		
</body>
</html>