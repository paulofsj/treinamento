<%-- 
    Document   : buscaEmpresa
    Created on : Jun 23, 2016, 2:07:08 PM
    Author     : acpm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XUNDA</title>
    </head>
    <body>
        Resultado da busca:<br/>
        <ul>
            <c:forEach var="empresa" items="${empresas}">
                <li> ${empresa.id}: ${empresa.nome} </li>
            </c:forEach>
        </ul>
    </body>
</html>
