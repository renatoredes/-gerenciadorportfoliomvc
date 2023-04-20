<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<%@include file="./base.jsp" %>
	</head>

	<body>

		<div class="container mt-3">

			<h1>Cadastrar Projeto</h1>
			<form:form method="POST" action="/demo/projetos/salvar">

				<c:if test="${resultado.equals('sucesso')}">
					<div id="resultado" name="resultado" display="block"
						class="alert alert-success alert-dismissible fade show" role="alert">
						${mensagem}
					</div>
				</c:if>

				<div class="row">
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Nome Projeto</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Informe o nome do projeto">
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Descrição</label> <input type="text" class="form-control" id="nomeProjeto"
								name="nome" placeholder="Descrição do projeto">
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="opcao">Gerente Responsável</label>
							<select name="gerentes" id="gorentes" class="form-control">
								<c:forEach items="${gerentes}" var="proximo">
									<option value="${proximo.id}">${proximo.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="opcao">Membro do Projeto</label>
							<select name="membros" id="membros" class="form-control">
								<c:forEach items="${membros}" var="proximoMembro">
									<option value="${proximoMembro.id}">${proximoMembro.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Data Inicio</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Informe o nome do projeto">
						</div class="valid-feedback">
					</div>

					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Data Final</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Informe a data">
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Previsão de Termino</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Informe a data prevista">
						</div>
					</div>									
				</div>

				<a href="${pageContext.request.contextPath}/projetos/listar" class="btn btn-warning"> Voltar </a>
				<input type="submit" value="Salvar" class="btn btn-primary">
			</form:form>
		</div>

	</body>

	</html>