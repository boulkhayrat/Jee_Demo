
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${(role == 'Admin') || (role =='Visiteur') }">   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestion des Livres</title>
	</head>
<body style="font-size:20px; background:#dedede;" >	<center>
			<p><h1 style="color: blue;">GESTION DES LIVRES</h1></p>
			<a href="login.jsp" style="margin:20px; right:0;">se deconnecter<span class="a-icon">
							<ion-icon name="log-out-outline"></ion-icon>
						</span>	</a>
			<hr>
					
			<c:if test="${role == 'Admin'}">
			<div style="margin:20px;">
			  
						<label for="Gestion">Gestion de :</label>
					
					    <button style="colr:blue; background:white;"><a href="list.jsp" style="text-decoration: none; color:blue;">Livres</a></button>
				   
				    
					  	<button style="colr:blue; background:white;"><a href="listAut.jsp" style="text-decoration: none;">Auteurs</a></button>
						
			</div>
			</c:if>	
			<form method="get" action="index">
					<c:if test="${(role == 'Admin') || (role =='Visiteur') }">
						<button type="submit" class="button" name="action" value="afficher"> 
							<span class="button-text">Afficher vos Livres</span>
							<span class="button-icon">
								<ion-icon name="list-outline"></ion-icon> 
							</span>
						</button>
					</c:if>	
					<c:if test="${role == 'Admin'}">				
						<button type="submit" class="button" name="action" value="ajouter"> 
							<span class="button-text">Ajouter un Livre</span>
							<span class="button-icon">
								<ion-icon name="book-outline"></ion-icon>
							</span>
						</button>
					</c:if>
					<c:if test="${(role == 'Admin') || (role =='Visiteur') }">
						<button type="submit" class="button" name="action" value="rechercher"> 
							<span class="button-text">Rechercher par Isbn</span>
							<span class="button-icon">
								<ion-icon name="search-outline"></ion-icon>
							</span>
						</button>
					
						<input type="text" placeholder="entrer l'isbn souhaite"  value="" name="isbn"/>
					</c:if>	
			</form>
			
		
		<div class="center">
		
			<table style="font-size:20px; margin:5px; padding:10px;border-radius:5px; width:70%;" border="1">
				<tr>
					<th>Isbn</th>
					<th>Titre</th>
					<th>Description</th>
					<th>Date d'edition</th>
					<th>Editeur</th>
					<th>Matricule</th>
				<c:if test="${role == 'Admin'}">
					<th>Actions</th>
				</c:if>
				</tr>
				<c:forEach items="${requestScope.list}" var= "l">
				<tr>
					<td><c:out value="${l.isbn }"></c:out></td>
					<td><c:out value="${l.titre }"></c:out></td>
					<td><c:out value="${l.description }"></c:out></td>
					<td><c:out value="${l.date_editing }"></c:out></td>
					<td><c:out value="${l.editeur }"></c:out></td>
					<td><c:out value="${l.matricule }"></c:out></td>	
					
					<c:if test="${role == 'Admin'}">
					<td>
						<form method="get" action="index">
							<button><a href="index?action=supprimer&isbn=${l.isbn }" style="text-decoration: none; color:blue;">supprimer<span class="a-icon">
									<ion-icon name="trash-outline"></ion-icon>
								</span></a></button>
							<button><a href="index?action=modifier&isbn=${l.isbn }" style="text-decoration: none; color:blue;">modifier<span class="a-icon">
									<ion-icon name="create-outline"></ion-icon>
								</span></a></button>
						</form>
					</td>
					</c:if>
					
					
				</tr>
				</c:forEach>
			</table>
			
		</div>	
		<p style="color:red;font-weight:20px;"><% if(request.getAttribute("error")!=null) out.println(request.getAttribute("error")); %></p>
				<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
				<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	</center>
	</body>
</html>

</c:if>