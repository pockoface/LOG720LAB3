<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

Utilisateur '<%=request.getRemoteUser()%>' a ete deconnecter.

<% session.invalidate(); %>