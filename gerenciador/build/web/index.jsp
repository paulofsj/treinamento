<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Jun 23, 2016, 2:14:31 PM
    Author     : acpm
--%>


<%@page contentType="text/html"  info="" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${usuarioLogado.email != null}">
            Bem vindo  ${usuarioLogado.email} ao nosso gerenciador de empresas!<br/>
        </c:if> 

        <form action="novaEmpresa" method="POST">
            Nome: <input type="text" name="nome" /><br/>
            <input type="submit" value="Enviar" />
        </form>
        <br/>
        <form action="login" method="post">
            Email: <input type="text" name="email" /><br />
            Senha: <input type="password" name="senha" /><br />
            <input type="submit" value="Login" />
        </form>
        <br /><br /> 
        <form action="logout" method="post">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
