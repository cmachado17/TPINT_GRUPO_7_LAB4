<%@page import="entidad.Paciente"%>
<%@page import="entidad.Provincia"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImpl.PacienteDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {			//script para hacer que el cartel de "Paciente agregado correctamente" se desvanezca a los 3 seg luego de aparecer
    setTimeout(function() {
        $(".content").fadeOut(1500);
    },3000);
});
</script>


<title>Alta Pacientes</title>
</head>

    <%
       if(session.getAttribute("Sesion") == null){ 
    	   response.sendRedirect("Home.jsp"); 
       }
       else{
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

<%
	
	String mensaje = "";

	if(request.getAttribute("insercion")!=null){
		int filas=Integer.parseInt(request.getAttribute("insercion").toString());
		if(filas==2) {
			mensaje="Paciente agregado correctamente!";
		
		}else if(filas ==1){
			mensaje="Error al agregar al paciente.";
		}
	}
	
	
%>
<!-- <div style="text-align: center;"> -->
<%-- 		<%=mensaje %> --%>
<div class="content" style="text-align: center; font-weight: bold;"><%=mensaje %></div>		<!-- Lo que mostrará el timer -->

	<div class="p-3 contenedor-principal">

<h2 class="tituloForm"> Alta de pacientes </h2>

<%
		List<Provincia> listaP = new ArrayList<Provincia>();

		if (request.getAttribute("listaProv") != null) {
			listaP = (List<Provincia>) request.getAttribute("listaProv");
		}
		
		List<Nacionalidad> listaN = new ArrayList<Nacionalidad>();

		if (request.getAttribute("listaNac") != null) {
			listaN = (List<Nacionalidad>) request.getAttribute("listaNac");
		}
%>

			<div class="d-flex justify-content-center text-light">
				<form method="post" action="servletPacientes?Param=0" class="w-75">
					<div class="form-group">
					<label>DNI</label> <input type="number" name="DNI"  min="1111111" max="99999999" class="form-control" required></input>
					</div>
					<div class="form-group">
					<label>Nombre</label> <input type="text" name="nombre" minlength="3" maxlength="20"  class="form-control"required></input>
					</div>
					<div class="form-group">
					<label>Apellido</label> <input type="text" name="apellido" minlength="3" maxlength="30" class="form-control" required></input>
					</div>
					<div class="form-group">
						<label>Sexo</label>    
					 	<select name="sexo" required class="form-select">
	    					<option value="F">MUJER</option>
	    					<option value="M">HOMBRE</option>
	   		 			</select> 
					</div>
					<div class="form-group">
						<label>Nacionalidad</label> 
	   		 			<select name="nacionalidad" required class="form-select custom-select">
	  						<%for (Nacionalidad n : listaN) {%>
	  						<option value="<%=n.getCodigo()%>"><%=n.getDescripcion()%></option>
							<%}%>
						</select> 
					</div>
					<div class="form-group">
					 <label>Fecha Nac.</label> <input type="date" name="fechaNacimiento" required class="form-control" ></input> 
					</div>
					<div class="form-group">
					<label>Direccion</label> <input type="text" name="direccion" minlength="3" maxlength="40" required class="form-control"></input>
					</div>
					<div class="form-group">
					 <label>Localidad</label> <input type="text" name="localidad" minlength="3" maxlength="20" required class="form-control"></input>
					</div>
					<div class="form-group">
						 <label>Provincia</label>
						<select type="text" name="provincia" required class="form-select">
							<%for (Provincia p : listaP) {%>
							<option value="<%=p.getCodigo()%>"><%=p.getDescripcion()%></option>
							<%}%>
						</select> 
					</div>
					<div class="form-group">
					<label>Email</label> <input type="email" name="email" minlength="3" maxlength="40" required class="form-control"></input> 
					</div>
					<div class="form-group">
					<label>Telefono</label> <input type="tel" name="telefono" minlength="6" maxlength="15" required class="form-control"></input> 
					</div>
	
				    <div class="submit">
				     <input type="submit" class="btn btn-light" name="btnEnviar-pacientes" value="Enviar" ></input></br>
					</div>
				</form>
	   		</div>
  		</div>
	</div>
</body>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>