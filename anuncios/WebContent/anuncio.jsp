<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("anuncios");
%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Anúncios</h1>
	<a href="novo.html" class="botao1">Adicionar Novo Anúncio</a>


	<h3>Emitir Relatório por:</h3>
	<form name="formRelatorio" action="insert">
		<table>
			<tr>
				<td><label for="clienteRlt">Cliente</label> <input type="text"
					name="clienteRlt" placeholder="" class="caixa1"></td>
			</tr>
			<tr>
				<td><label for="dataInicioRlt">Data Início</label> <input
					type="text" name="dataInicioRlt" placeholder="aaaa-mm-dd"
					class="caixa2"></td>
			</tr>
			<tr>
				<td><label for="dataTerminoRlt">Data Término</label> <input
					type="tex" name="dataTerminoRlt" placeholder="aaaa-mm-dd"
					class="caixa2"></td>
			</tr>
		</table>
		

	</form>
	<a href="report" class="botao2">Gerar Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome do Anúncio</th>
				<th>Cliente</th>
				<th>Data de Início</th>
				<th>Data de Término</th>
				<th>Investimento</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdAnuncio()%></td>
				<td><%=lista.get(i).getNomeAnuncio()%></td>
				<td><%=lista.get(i).getCliente()%></td>
				<td><%=lista.get(i).getDataInicio()%></td>
				<td><%=lista.get(i).getDatatermino()%></td>
				<td><%=lista.get(i).getInvestimento()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>