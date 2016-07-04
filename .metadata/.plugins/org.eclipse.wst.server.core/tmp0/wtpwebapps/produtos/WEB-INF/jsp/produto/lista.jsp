<%@ page import="br.com.caelum.produtos.modelo.Produto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function removeProduto(id){
			$("#mensagem").load('<c:url value="/produto/remove"/>' + '?produto.id=' + id);
			$("#produto" + id).remove();
		}
	</script>

	<h1>Produtos</h1>
	<h2>
		<fmt:message key="mensagem.bemvindo" />
	</h2>
	<div id="mensagem"></div>
	<table width="100%">
		<tr>
			<td>No.</td>
			<td width="20%">Nome</td>
			<td>Preco</td>
			<td>Descricao</td>
			<td>Data de Inicio da Venda</td>
			<td>Usado?</td>
			<td width="20%">Remover?</td>
		</tr>


		<c:forEach var="p" items="${produtoList}" varStatus="st">
			<tr id="produto${p.id}">
				<td>${st.count}</td>
				<td>${fn:toUpperCase(p.nome)}</td>
				<td><fmt:formatNumber value="${p.preco}" type="currency" /></td>
				<td>${p.descricao}</td>
				<td><fmt:formatDate value="${p.dataInicioVenda.time}"
						pattern="dd/MM/yyyy" /></td>
				<c:if test="${p.usado}">
					<td>Sim</td>
				</c:if>
				<c:if test="${not p.usado}">
					<td>Não</td>
				</c:if>
				<td><a href="#" onclick="return removeProduto(${p.id})">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/produto/formulario"/>"><fmt:message
			key="mensagem.novoProduto" /></a>
	<c:import url="../_comum/rodape.jsp" />
</body>

</html>