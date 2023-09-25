<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<title>Cursos</title>
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
			<b>Cursos</b>
		</p>
	</div>
	<div align="right" class="container">
		<form class="row g-3" action="curso" method="post">
			<div align="right">
				<table>
					<tr>
						<td><input class="form-control" type="text" id="idCurso2"
							name="idCurso2" placeholder="Codigo Curso"
							value='<c:out value="${curso.idCurso}"></c:out>'></td>
						<td><input class="btn btn-dark" type="submit" id="botao"
							name="botao" value="Buscar"></td>
					</tr>
				</table>
			</div>
			<p class="fs-5 fw-medium" align="left">
				<b>Cadastro de Dados:</b>
			</p>
			<div class="col-md-12" align="left">
				<label class="form-label">Nome Curso</label><input
					class="form-control" type="text" id="nomeCurso" name="nomeCurso"
					placeholder="ex: Analise e Desenvolvimento Sistema"
					value='<c:out value="${curso.nomeCurso}"></c:out>'>
			</div>
			<div class="col-md-3" align="left">
				<label class="form-label">Codigo do Curso</label><input
					class="form-control" type="text" id="idCurso" name="idCurso"
					placeholder="1 a 100"
					value='<c:out value="${curso.idCurso}"></c:out>'>
			</div>
			<div class="col-md-3" align="left">
				<label class="form-label">Carga Horária</label><input
					class="form-control" type="text" id="cargaHorario"
					name="cargaHorario" placeholder="ex: 1800"
					value='<c:out value="${curso.cargaHorario}"></c:out>'>
			</div>
			<div class="col-md-3" align="left">
				<label class="form-label">Sigla do Curso</label><input
					class="form-control" type="text" id="sigla" name="sigla"
					placeholder="ex: ADS"
					value='<c:out value="${curso.sigla}"></c:out>'>
			</div>
			<div class="col-md-3" align="left">
				<label class="form-label">ENADE</label><input class="form-control"
					type="number" min="0" max="5" step="0.1" id="ENADE" name="ENADE"
					placeholder="ex: 0,0 a 5,0"
					value='<c:out value="${curso.ENADE}"></c:out>'>
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
	<c:if test="${not empty cursos}">
		<table class="table table-striped table-responsive">
			<thead>
				<tr>
					<th><b>Codigo</b></th>
					<th><b>Nome</b></th>
					<th><b>Carga Horária</b></th>
					<th><b>Sigla</b></th>
					<th><b>ENADE</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${cursos}">
					<tr>
						<td><c:out value="${c.idCurso}"></c:out></td>
						<td><c:out value="${c.nomeCurso}"></c:out></td>
						<td><c:out value="${c.cargaHorario}"></c:out></td>
						<td><c:out value="${c.sigla}"></c:out></td>
						<td><c:out value="${c.ENADE}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>