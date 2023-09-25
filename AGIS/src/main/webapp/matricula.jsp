<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"	crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"	crossorigin="anonymous"></script>
<title>Matriculas</title>
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
			<b>Matriculas Aluno</b>
		</p>
	</div>
	<div align="right" class="container">
		<form class="row g-3" action="matricula" method="post">
			<div align="center">
				<table>
					<tr>
						<td><input class="form-control" type="text" id="RA" name="RA"
							placeholder="RA" value='<c:out value="${matricula.RA}"></c:out>'></td>
						<td><input class="btn btn-dark" type="submit" id="botao"
							name="botao" value="Buscar"></td>
					</tr>
				</table>
			</div>
			<div align="left">
				<label class="form-label"><b>Matriculas Disciplina</b></label>
				<table class="col-md-10">
					<tr>
						<td><select name="idDisciplina" class="form-select">
								<option>Seleciona a Disciplina</option>
								<c:forEach var="d" items="${disciplina}">
									<option value="${d.idDisciplina }">
										<c:out value="${d.nomeDisciplina}" />
									</option>
								</c:forEach>
						</select></td>
						<td><input class="col-md-3 btn btn-outline-success"
							type="submit" id="botao" name="botao" value="Matricular">
							<input class="col-md-3 btn btn-outline-info"
							type="submit" id="botao" name="botao" value="Listar">
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<c:if test="${not empty matriculas}">
		<table class="table table-striped table-responsive">
			<thead>
				<tr>
					<th><b>Codigo Matricula</b></th>
					<th><b>RA</b></th>
					<th><b>Ano</b></th>
					<th><b>Semest. Inicio</b></th>
					<th><b>Disciplina</b></th>
					<th><b>Situação</b></th>
			</thead>
			<tbody>
				<c:forEach var="a" items="${matriculas}">
					<tr>
						<td><c:out value="${a.idMatricula}"></c:out></td>
						<td><c:out value="${a.aluno.RA}"></c:out></td>
						<td><c:out value="${a.ano}"></c:out></td>
						<td><c:out value="${a.semestreMatricula}"></c:out></td>
						<td><c:out value="${a.disciplina.nomeDisciplina}"></c:out></td>
						<td><c:out value="${a.aprovacao}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>