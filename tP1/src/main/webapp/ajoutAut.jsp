<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserion</title>

</head>
<body style="font-size:20px; background:#dedede;" >
	<center>
		<p><h1>Insertion</h1>	</p>
		
		<hr>
		<form method="post" action="indexa">
			<input type=text placeholder="matricule" name="matricule"><br>
			<input type=text placeholder="nom" name="nom"><br>
			<input type=text placeholder="prenom" name="prenom"><br>
			<p>Veuillez Choisir le Genre de Cet Auteur :</p>
			  <div>
			    <input type="radio" id="Masculin"
			     name="genre" value="Masculin">
			    <label for="Masculin">Masculin</label>
			
			    <input type="radio" id="Feminin"
			     name="genre" value="Feminin">
			    <label for="Feminin">Feminin</label>
				<br>
			<input type=submit value="ajouter" name="action">
		</form>
	</center>
</body>
</html>