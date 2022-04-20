<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertion</title>

</head>
<body style="font-size:20px; background:#dedede;" ><center>

		<p><h1>Insertion</h1>	</p>
		
		<hr>
		<form method="post" action="index">
			<input type=text placeholder="isbn" name="isbn"><br>
			<input type=text placeholder="titre" name="titre"><br>
			<input type=text placeholder="description" name="description"><br>
			<input type=text placeholder="date d'edition" name="date"><br>
			<p>Veuillez Choisir l'Editeur  :</p>
			  <div>
			    <input type="radio" id="ENI"
			     name="editeur" value="ENI">
			    <label for="ENI">ENI</label>
			
			    <input type="radio" id="DUNOND"
			     name="editeur" value="DUNOND">
			    <label for="DUNOND">DUNOND</label>
			    
			    <input type="radio" id="FIRST"
			     name="editeur" value="FIRST">
			    <label for="FIRST">FIRST</label>
				<br>
			<input type=text placeholder="matricule" name="matricule"><br>
			<input type=submit value="ajouter" name="action">
		</form>
</center>
</body>
</html>