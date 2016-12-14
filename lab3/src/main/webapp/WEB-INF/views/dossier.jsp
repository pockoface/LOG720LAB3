<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/listeDesDossiers.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail du dossier</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Équipe10-log720-Lab02</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
            	<li><a href="<c:url value="/dossier/portail"/>">Gestionnaire des dossiers</a></li>
				<li><a href="<c:url value="/infraction/portail"/>">Gestionnaire des infractions</a></li>
				<li><a href="<c:url value="/logout"/>">Deconnection</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="folderDetails" class="container">
		<h3>Détails du dossier</h3>
		
		
		
		
		
		
			<div class="form-group">
				<label for="lastName">Nom</label> <input type="text"
					class="form-control" id="lastNameInput" placeholder=""
					value="${dossier.getNom()}" disabled>
			</div>
			<div class="form-group">
				<label for="firstName">Prénom</label> <input type="text"
					class="form-control" id="firstNameInput" placeholder=""
					value="${dossier.getPronom()}" disabled>
			</div>
			<div class="form-group">
				<label for="plateNumber">Numéro de plaque</label> <input type="text"
					class="form-control" id="plateNumber" placeholder=""
					value="${dossier.getNoPlaque()}" disabled>
			</div>
			<div class="form-group">
				<label for="licenseNumber">Numéro de permis de conduire</label> <input
					type="text" class="form-control" id="licenseNumber" placeholder=""
					value="${dossier.getNoPermis()}" disabled>
			</div>
			<div class="form-group">
				<label for="file-level">Niveau</label> <input type="text"
					class="form-control" id="file-level" placeholder=""
					value="${dossier.getNiveau()}" disabled>
			</div>
			
			
			
		<c:url var="addAction" value="/dossier/infraction/add" ></c:url>
		<form:form action="${addAction}" method="post" cssStyle="margin-top: 20px">
			
			<div class="form-group">
				<label for="infractions">Infractions liées au dossier</label> 
				
				<select
					class="form-control" id="infractions"
					 name="infraction">
					 
					 <c:forEach var="infraction" items="${listInfraction}">
					 	<option value="${infraction.getIdInfraction()}">${infraction.getDescription()}</option>
					 </c:forEach>
					 
				</select>
					
			</div>
			
			<input type="hidden" name="dossier" value="${dossier.getId()}">
			<button type="submit" class="btn btn-default">Ajoute une infraction au dossier</button>
		</form:form>
		
		
		
		
		
		
		
	</div>

	<div id="infractionsList" class="container">
		<h3>Liste des infractions</h3>
		<div id="">
			<Table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Description</th>
						<th>Niveau</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="infraction" items="${dossier.getInfractions()}">
						<tr>
							<td>${infraction.getIdInfraction()}</td>
							<td>${infraction.getDescription()}</td>
							<td>${infraction.getNiveau()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</Table>
		</div>
	</div>
</body>
</html>
