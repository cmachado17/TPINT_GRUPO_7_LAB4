<%@page import="entidad.Turno"%>
<%@page import="java.util.ArrayList"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&display=swap" rel="stylesheet">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
	
<!-- Agrega los enlaces a DataTables -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css" />



<!-- Agrega los enlaces a SweetAlert2 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

<title>Turnos asignados</title>
</head>
<%
ArrayList <Turno> listaTurnos = null;
if(request.getAttribute("listaTurnos") != null){
	listaTurnos = (ArrayList <Turno>) request.getAttribute("listaTurnos");
}
%>
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
            <li><a href="servletEmpleados?Param=3" class="dropdown-item">Listado Empleados</a></li>
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

<h2 class="tituloForm"> Turnos asignados </h2> </br>
<form method="post" action="servletClinica">
  <div class="row my-2">
    <div class="col">
    <label>Desde</label>
      <input type="date" class="form-control" name="fechadesde" <%if (request.getAttribute("fechadesde") != null) { %>value ="<%= request.getAttribute("fechadesde").toString() %>"<%} %>>
    </div>
    <div class="col">
     <label>Hasta</label>
      <input type="date" class="form-control" name="fechahasta" <%if (request.getAttribute("fechahasta") != null) { %>value ="<%= request.getAttribute("fechahasta").toString() %>"<%} %>>
    </div>
      <div class="col d-flex align-items-end">
       <input type="submit" class="btn btn-light mx-2" name="btnBuscar" value="Filtrar" ></input>
         <input type="submit" class="btn btn-light" name="btnBorrar" value="Borrar filtros" ></input>
    </div>
  </div>
</form>
	<table id="table_id" class="display table table-striped bg-light">
		<thead>
			<tr>
				<th scope="col">Dia y Horario</th>
				<th scope="col">Paciente</th>
				<th scope="col">Estado</th>
				<th scope="col">Acciones</th>				
			</tr>
		</thead>
		<tbody>
		<% if(listaTurnos != null)
			for(Turno turno : listaTurnos){%>
			<tr>
				<td scope="row"><%=turno.getDia()%> <%=turno.getHorario()%> </td>
				<td scope="row"><%=turno.getPaciente().getNombre()%> <%=turno.getPaciente().getApellido()%>
				<td scope="row"><%=turno.getEstadoTurno().getDescripcion()%></td>
				<td scope="row">
					<input type="submit" class="btn-light" value="Ver Paciente" name="btnVerPaciente" onclick="window.location.href='servletClinica?btnVerPaciente&txtDni=<%=turno.getPaciente().getDni() %>'" />
					<% if (turno.getEstadoTurno().getCodigo() != 3 && turno.getEstadoTurno().getCodigo() != 4){  %>
					<input type="submit" class="btn-light" value="Editar Turno" name="btnEditarEstado" onclick="window.location.href='servletClinica?btnEditarEstado&paciente=<%=turno.getPaciente().getCodPaciente()%>&dia=<%=turno.getDia()%>&hora=<%=turno.getHorario()%> '"/>
					<%} %>
				</td>
			</tr>
		<%} %>	
		</tbody>
	</table>
</div>
</div>
</body>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>