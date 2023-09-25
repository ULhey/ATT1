<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<title>AGIS</title>
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
	<div align="center">
		<br> <br> <br> <br> <img src="https://cdn-icons-png.flaticon.com/512/1/1968.png" width="250" height="240">
		<b>GIS</b> <br> <br> <br>
		<p class="fs-1">
			<b>Bem-Vindos</b>
		</p>
	</div>
</body>
</html>