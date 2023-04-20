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
					<c:forEach var="gerente" items="${gerentes}">
						<tr>
							<td class="table-plus">${gerente.id}</td>
							<td class="table-plus">${gerente.nome}</td>
                            <td class="table-plus">
                                <form:form method="POST" action="/demo/gerentes/remover/${gerente.id}">
                                    <button type="submit" value="excluir" class="btn btn-primary"></button>
                                </form:form>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

            <form:form method="GET" action="/demo/gerentes/novo">
			<div>
			    <input type="submit" value="Novo Gerente" class="btn btn-primary">
			</div>
			</form:form>
		</div>
	</div>

</body>
</html>