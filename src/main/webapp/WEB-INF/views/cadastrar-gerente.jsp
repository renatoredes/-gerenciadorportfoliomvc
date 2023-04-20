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

		<h1>Cadastrar Gerente</h1>
		<form:form method="POST" action="/demo/gerentes/salvar" >

           <c:if test="${resultado.equals('sucesso')}" >
            <div id="resultado" name="resultado" display="block" class="alert alert-success alert-dismissible fade show" role="alert">
               ${mensagem}
            </div>
            </c:if>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="nome">Nome Gerente</label> <input type="text"
							class="form-control" id="nomeGerente" name="nome"
							placeholder="Informe o nome do gerente">
					</div>
				</div>
			</div>

			<a href="${pageContext.request.contextPath}/gerentes/listar"
				class="btn btn-warning"> Voltar </a>
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form:form>
	</div>

</body>
</html>