<%@page import="entidad.Nacionalidad"%>
<%@page import="entidad.Paciente"%>
<%@page import="entidad.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%
       if(session.getAttribute("Sesion") == null){ 
    	   response.sendRedirect("Home.jsp"); 
       }
       else{
      %>
<head>
<% request.setCharacterEncoding("UTF-8"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&display=swap" rel="stylesheet">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Paciente</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="Principal.jsp"><i class="far fa-hospital px-2"></i>Sistema Clinica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     <% if(Integer.parseInt(session.getAttribute("tipoUsuario").toString()) == 1){ %>
     	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="fa fa-home"></span>Pacientes
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletPacientes?Param=0" class="dropdown-item">Alta Pacientes</a></li>
            <li><a href="servletPacientes?Param=3" class="dropdown-item">Listado Pacientes</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             <span class="fa fa-home"></span>Empleados
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletEmpleados?Param=0" class="dropdown-item">Alta Empleados</a></li>
            <li><a href="servletEmpleados?Param=3" class="dropdown-item">Listado Medicos</a></li>
             <li><a href="servletEmpleados?Param=4" class="dropdown-item">Listado Empleados</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <span class="fa fa-home"></span>Turnos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletTurnos?Param=0" class="dropdown-item">Alta Turno</a></li>
            <li><a href="servletTurnos?Param=1" class="dropdown-item">Listado Turnos</a></li>
          </ul>
        </li>
      </ul>
     <%}else if(Integer.parseInt(session.getAttribute("tipoUsuario").toString()) == 2){ %>
       <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="fa fa-home"></span>Medicos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletClinica?Param=0" class="dropdown-item">Turnos asignados</a></li>
          </ul>
        </li>
      </ul>
      <%}%>
      <div class="text-light pt-2">
      <% if(session.getAttribute("Sesion") != null){ %>
      	<p class="user"><%= session.getAttribute("Sesion") %> - <%= session.getAttribute("DescripcionTipoUsuario") %></p>
      	
      	<a class="user2" href="servletUsuarios?logout=1">Logout</a>
      <%}else{ %>
      	<p class="user">No logueado</p>
      	<%} %>
      </div>
    </div>
  </div>
</nav>

<div class="container">
	<div class="p-3 contenedor-principal">
	<h2 class="tituloForm">Paciente</h2>
		<% 	
			Paciente paciente = null;
			if(request.getAttribute("VerPaciente") != null) {
				paciente = (Paciente)request.getAttribute("VerPaciente");
		%>	
	<div class="d-flex justify-content-center text-light">				
			<form method="POST" action="servletClinica?Param=0" id="formularioModificacion" class="w-75">
				<div class="form-group">
					<label>DNI</label> 
					<input type="number" name="DNI" class="form-control" readonly="readonly" value="<%=paciente.getDni() %>" style="background-color: lightgrey;"></input>
					<label>Nombre</label> 
					<input type="text" name="nombre" readonly="readonly" minlength="3" maxlength="20" class="form-control" required value="<%=paciente.getNombre() %>"style="background-color: lightgrey;"></input>
					<label>Apellido</label> 
					<input type="text" name="apellido" readonly="readonly" minlength="3" maxlength="30" class="form-control" required value="<%=paciente.getApellido() %>"style="background-color: lightgrey;"></input>
					<label>Sexo</label> 
					<input type="text" name="sexo" readonly="readonly" minlength="3" maxlength="30" class="form-control" required value="<%=paciente.getSexo() %>"style="background-color: lightgrey;"></input>
					<label>Nacionalidad</label>
					<input type="text" name="nacionalidad" readonly="readonly" minlength="3" maxlength="30" class="form-control" required value="<%=paciente.getNacionalidad().getDescripcion() %>"style="background-color: lightgrey;"></input>
		    		<label>Fecha</label>
		    		<input type="date" name="fechaNacimiento" readonly="readonly" required value="<%=paciente.getFechaNacimiento()%>" class="form-control" style="background-color: lightgrey;"></input>
					<label>Direccion</label> 
					<input type="text" name="direccion" readonly="readonly" minlength="3" maxlength="40" required value="<%=paciente.getDireccion() %>" class="form-control" style="background-color: lightgrey;"></input>
					<label>Localidad</label> 
					<input type="text" name="localidad" readonly="readonly" minlength="3" maxlength="20" required value="<%=paciente.getLocalidad()%>" class="form-control" style="background-color: lightgrey;"></input> 
					<label>Provincia</label>
					<input type="text" name="provincia" readonly="readonly" minlength="3" maxlength="20" required value="<%=paciente.getProvincia().getDescripcion()%>" class="form-control" style="background-color: lightgrey;"></input> 
					<label>Email</label>
					<input type="email" name="Email" readonly="readonly" minlength="3" maxlength="40" required value="<%=paciente.getEmail() %>" class="form-control" style="background-color: lightgrey;"></input> 
					<label>Tel. fijo</label>
					<input type="tel" name="Telefono" readonly="readonly" minlength="6" maxlength="15" required value="<%=paciente.getTelefono() %>" class="form-control" style="background-color: lightgrey;"></input> 
				</div>
				<div class="submit">
					<input type="submit" class="btn btn-light" name="btnVolver" value="Volver"></input></br>
				</div>
			</form>
		</div>
<%} %>
		</div>
	</div>
</body>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>