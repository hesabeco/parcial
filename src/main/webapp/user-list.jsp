<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User
     Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de pacientes</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Usuario</a>
                    </div>
                    <br>
                    <jsp:useBean id="cdao" class="parcial.repositories.PacienteDao" scope="request">
</jsp:useBean>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Documento</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Genero</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Telefono</th>
                                <th>Direccion </th>
                                <th>Peso</th>
                                <th>Estatura</th>
                                <th>IMC</th>
                                <th>Nivel de Peso</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="paciente" items="${cdao.list()}">
                                
                                <tr>
                                    <td>
                                        <c:out value="${paciente.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.documento}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.apellido}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.genero}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.fechanacimiento}"/>
                                    </td>
                                    <td>
                                        <c:out value="${paciente.telefono}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.direccion}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.peso}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.estatura}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.imc}" />
                                    </td>
                                    <td>
                                        <c:out value="${paciente.nivelpeso}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${paciente.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${paciente.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>