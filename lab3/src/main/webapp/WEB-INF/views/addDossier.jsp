<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/listeDesDossiers.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un dossier</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Équipe10-log720-Lab02</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/dossier/portail"/>">Gestionnaire
						des dossiers</a></li>
				<li><a href="<c:url value="/infraction/portail"/>">Gestionnaire
						des infractions</a></li>
				<li><a href="<c:url value="/logout"/>">Deconnection</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="addFolderForm" class="container">
		<h3>Formulaire d'ajout d'un dossier</h3>

		<c:url var="addAction" value="/dossier/add"></c:url>
		<form:form action="${addAction}" commandName="dossier"
			cssStyle="margin-top: 20px">

			<div class="form-group">


				<label for="lastName">Nom</label>
				<form:input path="nom" cssClass="form-control" />

			</div>
			<div class="form-group">
				<label for="firstName">Prénom</label>
				<form:input path="pronom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="plateNumber">Numéro de plaque</label>
				<form:input path="noPlaque" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="licenseNumber">Numéro de permis de conduire</label>
				<form:input path="noPermis" cssClass="form-control" />
			</div>

			<button type="submit" class="btn btn-default">Enregistrer</button>

		</form:form>
	</div>

</body>
</html>