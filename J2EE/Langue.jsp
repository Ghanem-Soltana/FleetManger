<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<html:html lang="true">
<lay:html></lay:html></html:html>
<%

String ch=String.valueOf(session.getAttribute("ch"));
if(!ch.equals("login.do?action=connexion"))
response.sendRedirect(ch);
else  response.sendRedirect("Principale.jsp");
%>
