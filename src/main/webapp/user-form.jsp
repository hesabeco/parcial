<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Pacientes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${paciente != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${paciente == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${paciente != null}">
                                    Edit paciente
                                </c:if>
						<c:if test="${paciente == null}">
                                    Agregar Nuevo paciente
                                </c:if>
					</h2>
				</caption>

				<c:if test="${paciente != null}">
					<input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Documento del paciente</label> <input type="text"
						value="<c:out value='${paciente.documento}' />" class="form-control"
						name="documento" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre del Paciente</label> <input type="text"
						value="<c:out value='${paciente.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Apellido del Paciente</label> <input type="text"
						value="<c:out value='${paciente.apellido}' />" class="form-control"
						name="apellido">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${paciente.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Genero</label> <input type="text"
						value="<c:out value='${paciente.genero}' />" class="form-control"
						name="genero">
				</fieldset>
				<fieldset class="form-group">
					<label>Fecha de Nacimiento</label> <input type="date"
						value="<c:out value='${paciente.fechanacimiento}' />" class="form-control"
						name="fechanacimiento">
				</fieldset>
				<fieldset class="form-group">
					<label>Telefono</label> <input type="text"
						value="<c:out value='${paciente.telefono}' />" class="form-control"
						name="telefono">
				</fieldset>
				<fieldset class="form-group">
					<label>Direccion</label> <input type="text"
						value="<c:out value='${paciente.direccion}' />" class="form-control"
						name="direccion">
				</fieldset>
                <fieldset class="form-group">
					<label>Peso</label> <input type="text"
						value="<c:out value='${paciente.peso}' />" class="form-control"
						name="peso">
				</fieldset>
				<fieldset class="form-group">
					<label>Estatura</label> <input type="text"
						value="<c:out value='${paciente.estatura}' />" class="form-control"
						name="estatura">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>