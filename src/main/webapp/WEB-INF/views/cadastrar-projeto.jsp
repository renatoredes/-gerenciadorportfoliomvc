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
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="nome">Nome Projeto</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Informe o nome do projeto">
						</div>
					</div>
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="nome">Descrição</label> <input type="text" class="form-control" id="nomeProjeto"
								name="nome" placeholder="Descrição do projeto">
						</div>
					</div>
					<div class="col-md-4 mb-3">
						<div class="form-group">
							<label for="opcao">Gerente Responsável</label>
							<select name="gerentes" id="gorentes" class="form-control">
								<c:forEach items="${gerentes}" var="proximo">
									<option value="${proximo.id}">${proximo.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Data Inicio</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Data de inicio">
						</div class="valid-feedback">
					</div>

					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Data Final</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Data Final">
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Previsão de Termino</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Previsão">
						</div>
					</div>					
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="nome">Orçamento</label> <input type="text" class="form-control"
								id="nomeProjeto" name="nome" placeholder="Orçamento">
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="opcao">Status do Projeto</label>
					  <select name="opcao" id="opcao" class="form-control">
						<option value="opcao1">EM_ANALISE</option>
						<option value="opcao2">ANALISE_REALIZADA</option>
						<option value="opcao3">ANALISE_APROVADA</option>
						<option value="opcao4">INICIADO</option>
						<option value="opcao4">PLANEJADO</option>
						<option value="opcao4">EM_ANDAMENTO</option>
						<option value="opcao4">ENCERRADO</option>
						<option value="opcao4">CANCELADO</option>
					  </select>
						</div>						
					</div>	
					<div class="col-md-3 mb-3">
						<div class="form-group">
							<label for="opcao">Classificação de Risco</label>
					  <select name="opcao" id="opcao" class="form-control">
						<option value="opcao1">BAIXO_RISCO</option>
						<option value="opcao2">MEDIO_RISCO</option>
						<option value="opcao3">ALTO_RISCO</option>
					  </select>
						</div>						
					</div>														
				</div>

				<a href="${pageContext.request.contextPath}/projetos/listar" class="btn btn-warning"> Voltar </a>
				<input type="submit" value="Salvar" class="btn btn-primary">
			</form:form>
		</div>

	</body>

	</html>