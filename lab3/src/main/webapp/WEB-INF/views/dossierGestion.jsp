<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/listeDesDossiers.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionnaire des dossiers</title>
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
    
    <div id="folderManager" class="container">
    	<h3>Gestionnaire des dossiers</h3>
    	<div id="sectionBtnsContainer">
   			<a href="<c:url value="/dossiers"/>">
	   			<div id="viewFoldersList">
	   				<p class="buttonTxt">Liste des dossiers</p>
	   			</div>
   			</a>
    		<a href="<c:url value="/dossier/form/add"/>">
	    		<div id="addFolderToList">
	    			<p class="buttonTxt">Ajouter un dossier</p>
	    		</div>
    		</a>
    	</div>
    </div>

</body>
