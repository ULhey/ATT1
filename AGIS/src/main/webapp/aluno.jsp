<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<title>Alunos</title>
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
			<b>Ficha Aluno</b>
		</p>
	</div>
	<div align="right" class="container">
		<form class="row g-3" action="aluno" method="post">
			<div align="right">
				<table>
					<tr>
						<td><input class="form-control" type="text" id="RA" name="RA"
							placeholder="RA" value='<c:out value="${aluno.RA}"></c:out>'></td>
						<td><input class="btn btn-dark" type="submit" id="botao"
							name="botao" value="Buscar"></td>
					</tr>
				</table>
			</div>
			<p class="fs-5 fw-medium" align="left">
				<b>Cadastro de Dados:</b>
			</p>
			<div class="col-md-6" align="left">
				<label class="form-label">Nome</label><input class="form-control"
					type="text" id="nome" name="nome" placeholder="Fulana Santos"
					value='<c:out value="${aluno.nome}"></c:out>'>
			</div>
			<div class="col-md-6" align="left">
				<label class="form-label">Nome Social</label><input
					class="form-control" type="text" id="nomeSocial" name="nomeSocial"
					placeholder="ex: Filho feio não tem pai"
					value='<c:out value="${aluno.nomeSocial}"></c:out>'>
			</div>
			<div class="col-md-3" align="left">
				<label class="form-label">CPF</label><input class="form-control"
					type="text" id="CPF" name="CPF" placeholder="ex: 22233366638"
					value='<c:out value="${aluno.CPF}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Data de Nascimento</label> <input
					class="form-control" type="date" id="dataNasc" name="dataNasc"
					value='<c:out value="${aluno.dataNasc}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Telefone</label><input
					class="form-control" type="text" id="telefone" name="telefone"
					placeholder="ex: 11922223333"
					value='<c:out value="${aluno.telefone}"></c:out>'>
			</div>
			<div class="col-md-5" align="left">
				<label class="form-label">Email</label><input class="form-control"
					type="text" id="email" name="email"
					placeholder="ex: Fulana@fulana.com"
					value='<c:out value="${aluno.email}"></c:out>'>
			</div>
			<div class="col-md-6" align="left">
				<label class="form-label">Instituições de graduação</label><input
					class="form-control" type="text" id="instituicaoMedio"
					name="instituicaoMedio" placeholder="ex: Jardim Pedra Branca"
					value='<c:out value="${aluno.instituicaoMedio}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Data Formação</label> <input
					class="form-control" type="date" id="dataMedio" name="dataMedio"
					value='<c:out value="${aluno.dataMedio}"></c:out>'>
			</div>
			<div class="col-md-2" align="left">
				<label class="form-label">Pontuação Vestibular</label> <input
					class="form-control" type="text" id="pontVestibular"
					name="pontVestibular" placeholder="8,5"
					value='<c:out value="${aluno.pontVestibular}"></c:out>'>
			</div>
			<div class="col-2" align="left">
				<label class="form-label">Posição Vestibular</label><input
					class="form-control" type="text" id="posiVestibular"
					name="posiVestibular" placeholder="1"
					value='<c:out value="${aluno.posiVestibular}"></c:out>'>
			</div>
			<div class="col-md-6" align="left">
				<label class="form-label">Periodo</label><input class="form-control"
					type="text" id="turno" name="turno" placeholder="ex: Vespertino"
					value='<c:out value="${aluno.turno}"></c:out>'>
			</div>
			<div class="col-md-6" align="left">
				<label class="form-label">Curso</label><select name="idCurso"
					class="form-select">
					<c:choose>
						<c:when test="${not empty aluno}">
							<option value="${aluno.curso.idCurso}">
								<c:out value="${aluno.curso.nomeCurso}" />
							</option>
						</c:when>
						<c:otherwise>
							<option>Selecione o curso</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="c" items="${cursos}">
						<option value="${c.idCurso}">
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
	<c:if test="${not empty alunos}">
		<table class="table table-striped table-responsive">
			<thead>
				<tr>
					<th><b>RA</b></th>
					<th><b>CPF</b></th>
					<th><b>Nome</b></th>
					<th><b>Social</b></th>
					<th><b>Nascimento</b></th>
					<th><b>Telefone</b></th>
					<th><b>Email</b></th>
					<th><b>Corp.</b></th>
					<th><b>Data Formação</b></th>
					<th><b>I. Formação</b></th>
					<th><b>P. Vest.</b></th>
					<th><b>P. Vest.</b></th>
					<th><b>Ano Inicio</b></th>
					<th><b>S. Inicio</b></th>
					<th><b>S. Conclusão</b></th>
					<th><b>Ano Conclusão</b></th>
					<th><b>Periodo</b></th>
					<th><b>Curso</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${alunos}">
					<tr>
						<td><c:out value="${a.RA}"></c:out></td>
						<td><c:out value="${a.CPF}"></c:out></td>
						<td><c:out value="${a.nome}"></c:out></td>
						<td><c:out value="${a.nomeSocial}"></c:out></td>
						<td><c:out value="${a.dataNasc}"></c:out></td>
						<td><c:out value="${a.telefone}"></c:out></td>
						<td><c:out value="${a.email}"></c:out></td>
						<td><c:out value="${a.emailCorp}"></c:out></td>
						<td><c:out value="${a.dataMedio}"></c:out></td>
						<td><c:out value="${a.instituicaoMedio}"></c:out></td>
						<td><c:out value="${a.pontVestibular}"></c:out></td>
						<td><c:out value="${a.posiVestibular}"></c:out></td>
						<td><c:out value="${a.anoInicio}"></c:out></td>
						<td><c:out value="${a.semesInicio}"></c:out></td>
						<td><c:out value="${a.semesConclusao}"></c:out></td>
						<td><c:out value="${a.anoLimite}"></c:out></td>
						<td><c:out value="${a.turno}"></c:out></td>
						<td><c:out value="${a.curso.nomeCurso}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>