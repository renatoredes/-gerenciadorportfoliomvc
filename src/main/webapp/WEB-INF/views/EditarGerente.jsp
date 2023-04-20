<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Editar Gerênte Form</h1>
		<form action="atualizarGerente" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="id">Id</label> <input type="text"
							value="${gerente.id}" class="form-control" id="nomeGerente" name="nomeGerente"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							value="${gerente.nome }" class="form-control" id="nomeGerente"
							name="nomeGerente" placeholder="Enter Name">
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Editar</button>
		</form>

	</div>

</body>
</html>