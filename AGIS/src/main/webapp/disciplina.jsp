<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"	crossorigin="anonymous">
<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"	crossorigin="anonymous"></script>
<title>Disciplinas</title>
</head>
<body class="bg-light">
	<nav class="navbar navbar-expand-lg bg-body-tertiary"
		data-bs-theme="dark">
		<nav class="navbar bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					src="https://cdn-icons-png.flaticon.com/512/1/1968.png" alt="Logo"
					width="30" height="24" class="d-inline-block align-text-top">
					GIS
				</a>
			</div>
		</nav>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/curso">Cursos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/disciplina">Disciplina</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">Aluno</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/aluno">Ficha Aluno</a></li>
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/matricula">Matriculas</a></li>
					</ul></li>
				</ul>
			</div>
		</nav>
	<div align="center" class="container col-md-6">
		<br>
		<p class="fs-2">
			<b>Disciplina</b>
		</p>
	</div>
	<div align="right" class="container">
		<form class="row g-3" action="disciplina" method="post">
			<div align="right">
				<table>
					<tr>
						<td><input class="form-control" type="text" id="idDisciplina"
							name="idDisciplina" placeholder="Codigo Disciplina"
							value='<c:out value="${disciplina.idDisciplina}"></c:out>'></td>
						<td><input class="btn btn-dark" type="submit" id="botao"
							name="botao" value="Buscar"></td>
					</tr>
				</table>
			</div>
			<p class="fs-5 fw-medium" align="left">
				<b>Cadastro de Dados:</b>
			</p>
			<div class="col-md-8" align="left">
				<label class="form-label">Nome da Disciplina</label><input
					class="form-control" type="text" id="nomeDisciplina"
					name="nomeDisciplina"
					placeholder="ex: Laboratorio de Banco de Dados"
					value='<c:out value="${disciplina.nomeDisciplina}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Horário Semanal</label><input
					class="form-control" type="text" id="horarioSemanal"
					name="horarioSemanal" placeholder="ex: 14:50"
					value='<c:out value="${disciplina.horarioSemanal}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Quantidade de Aula</label><input
					class="form-control" type="text" id="aula" name="aula"
					placeholder="ex: 4"
					value='<c:out value="${disciplina.aula}"></c:out>'>
			</div>
			<div class="col-md-7" align="left">
				<label class="form-label">Resumo Conteudo</label><input
					class="form-control" type="text" id="tipoConteudo"
					name="tipoConteudo"
					placeholder="ex: Aplicar conceitos aprendido na disciplina de Banco de Dados"
					value='<c:out value="${disciplina.tipoConteudo}"></c:out>'>
			</div>
			<div class="col-md-5" align="left">
				<label class="form-label">Curso</label><select name="idCurso"
					class="form-select">
					<c:choose>
						<c:when test="${not empty disciplina}">
							<option value="${disciplina.curso.idCurso}">
								<c:out value="${disciplina.curso.nomeCurso}" />
							</option>
						</c:when>
						<c:otherwise>
							<option>Selecione o curso</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="c" items="${cursos}">
						<option value="${c.idCurso }">
							<c:out value="${c.nomeCurso}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<table>
				<tr>
					<td class="col-md-2" align="center"><input
						class="btn btn-dark col-md-11" type="submit" id="botao"
						name="botao" value="Cadastrar"></td>
					<td class="col-md-2" align="center"><input
						class="btn btn-dark col-md-11" type="submit" id="botao"
						name="botao" value="Alterar"></td>
					<td class="col-md-2" align="center"><input
						class="btn btn-dark col-md-11" type="submit" id="botao"
						name="botao" value="Excluir"></td>
					</tr>
			</table>
		</form>
	</div>
	<br>
	<c:if test="${not empty disciplinas}">
		<table class="table table-striped table-responsive">
			<thead>
				<tr>
					<th><b>Codigo Disciplina</b></th>
					<th><b>Disciplina</b></th>
					<th><b>Horário</b></th>
					<th><b>Aulas</b></th>
					<th><b>Conteudo</b></th>
					<th><b>Curso</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${disciplinas}">
					<tr>
						<td><c:out value="${d.idDisciplina}"></c:out></td>
						<td><c:out value="${d.nomeDisciplina}"></c:out></td>
						<td><c:out value="${d.horarioSemanal}"></c:out></td>
						<td><c:out value="${d.aula}"></c:out></td>
						<td><c:out value="${d.tipoConteudo}"></c:out></td>
						<td><c:out value="${d.curso.nomeCurso}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>