<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Lista</h1>
		<!-- <a href="criarGerente" class="btn btn-primary"> Cadastrar Gerente </a>
		-->
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="projeto" items="${projetos}">
						<tr>
							<td class="table-plus">${projeto.nome}</td>
							<td class="table-plus">${projeto.orcamentoTotal}</td>
                            <td class="table-plus">
                                <form:form method="POST" action="/demo/projetos/remover/${projeto.id}">
                                    <button type="submit" value="excluir" class="btn btn-primary"></button>
                                </form:form>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

            <form:form method="GET" action="/demo/projetos/novo">
			<div>
			    <input type="submit" value="Novo Projeto" class="btn btn-primary">
			</div>
			</form:form>
		</div>
	</div>

</body>
</html>