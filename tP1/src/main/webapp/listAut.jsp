<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Auteurs</title>


</head>
<body style="font-size:20px; background:#dedede;" >
<center>
			<p><h1 style="color: blue;">GESTION DES AUTEURS</h1></p>
			<a href="login.jsp" style="margin:20px; right:0;">se deconnecter<span class="a-icon">
							<ion-icon name="log-out-outline"></ion-icon>
						</span>	</a>
			<hr>
					
						
					
			
			<div style="margin:20px;">
			  
					<label for="Gestion">Gestion de :</label>
					
					    <button style="colr:blue; background:white;"><a href="list.jsp" style="text-decoration:none;">Livres</a></button>
				   
				    
					  	<button style="colr:blue; background:white;"><a href="listAut.jsp" style="text-decoration:none; color: blue;">Auteurs</a></button>
			</div>
			
			</div>
			<form method="get" action="indexa">
					<c:if test="${(role == 'Admin') || (role =='Visiteur') }">
						<button type="submit" class="button" name="action" value="afficher"> 
							<span class="button-text">Lister les Auteurs</span>
							<span class="button-icon">
								<ion-icon name="list-outline"></ion-icon> 
							</span>
						</button>
					</c:if>	
					<c:if test="${role == 'Admin'}">				
						<button type="submit" class="button" name="action" value="ajouter"> 
							<span class="button-text">Ajouter un Auteur </span>
							<span class="button-icon">
								<ion-icon name="person-add-outline"></ion-icon>
							</span>
						</button>
					</c:if>
					<c:if test="${(role == 'Admin') || (role =='Visiteur') }">
						<button type="submit" class="button" name="action" value="rechercher"> 
							<span class="button-text">Rechercher par Matricule</span>
							<span class="button-icon">
								<ion-icon name="search-outline"></ion-icon>
							</span>
						</button>
					
						<input type="text" placeholder="entrer la matricule souhaite"  value="" name="matricule"/>
					</c:if>	
			</form>
			
		
		<div class="center">
		
			<table style="font-size:20px; margin:5px; padding:10px;border-radius:5px; width:70%;" border="1">
				<tr>
					<th>Matricule</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Genre</th>
				<c:if test="${role == 'Admin'}">
					<th>Actions</th>
				</c:if>
				</tr>
				<c:forEach items="${requestScope.Auteurs}" var= "auteur">
				<tr>
					<td><c:out value="${auteur.matricule }"></c:out></td>
					<td><c:out value="${auteur.nom }"></c:out></td>
					<td><c:out value="${auteur.prenom }"></c:out></td>
					<td><c:out value="${auteur.genre }"></c:out></td>
					
					<c:if test="${role == 'Admin'}">
					<td>
						<form method="get" action="index">
							<button>
							<a href="indexa?action=supprimer&matricule=${auteur.matricule }" style="text-decoration: none; color:blue;">
							supprimer
								<span class="a-icon">
									<ion-icon name="trash-outline"></ion-icon>
								</span>
							</a>
							</button>
							<button>
							<a href="indexa?action=modifier&matricule=${auteur.matricule }" style="text-decoration: none; color:blue;">
							modifier
							<span class="a-icon">
									<ion-icon name="create-outline"></ion-icon>
								</span>
							</a>
							</button>
						</form>
					</td>
					</c:if>
					
					
				</tr>
				</c:forEach>
			</table>
		</div>
		
		<p class="errorr"><% if(request.getAttribute("error")!=null) out.println(request.getAttribute("error")); %></p>
				<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
				<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
		</center>
</body>
</html>