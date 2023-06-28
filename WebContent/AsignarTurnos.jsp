<%@page import="entidad.DiaSemana"%>
<%@page import="entidad.Paciente"%>
<%@page import="entidad.Medico"%>
<%@page import="entidad.Turno"%>
<%@page import="entidad.Especialidad"%>
<%@page import="entidad.Provincia"%>
<%@page import="entidad.Nacionalidad"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% request.setCharacterEncoding("UTF-8"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
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
<title>Asignar Turnos</title>
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
            <li><a href="servletPacientes?Param=1" class="dropdown-item">Estadísticas Pacientes</a></li>
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

<% 
		List<Especialidad> listaEsp = new ArrayList<Especialidad>();
		
		if (request.getAttribute("listaEsp") != null) {
			listaEsp = (List<Especialidad>) request.getAttribute("listaEsp");
		}
		
		List<Medico> listaMedicos = new ArrayList<Medico>();
		
		if (request.getAttribute("listaMedicos") != null && request.getAttribute("listaMedicos") != "") {
			listaMedicos = (List<Medico>) request.getAttribute("listaMedicos");
		}
		
		List<Turno> listaTurnos = new ArrayList<Turno>();
		
		if (request.getAttribute("turnosMedico") != null) {
			listaTurnos = (List<Turno>) request.getAttribute("turnosMedico");
		}
		
		List<Paciente> listaPac = new ArrayList<Paciente>();
		
		if (request.getAttribute("listaPac") != null) {
			listaPac = (List<Paciente>) request.getAttribute("listaPac");
		}
%>

	  <div class="container">
		 <div class="p-3 contenedor-principal">
			<h2 class="tituloForm"> Asignar turnos </h2> </br>
<%			int filas =0;
			String mensaje = "";

		if(request.getAttribute("insercion")!=null){
		filas=Integer.parseInt(request.getAttribute("insercion").toString());
		if(filas!=1) {
			mensaje= "Turno asignado correctamente!";
		}else if(filas==3){
			mensaje= "Ya tiene un turno asignado!";
		}else if(filas==2){
			mensaje = "Error al asignar turno.";
		}
	}  
	
%>  
			
<div class="content" style="text-align: center; font-weight: bold;"><%=mensaje %></div>	
<!-- Lo que mostrará el timer -->

<!--	si todavia no eligio especialidad muestra esto!-->
<% 		if(request.getParameter("btnBuscar")==null && request.getParameter("btnBuscar2")==null
&& request.getParameter("btnBuscar3")==null) {%>			
			<form class="row g-3" method="post" action="servletTurnos">
			 
			  
				  <div class="col-auto center">
				   <label class="formulario">Especialidad</label>
				   </div>
				   <div class="col-auto ">
			    			<select  name="especialidad" type="text" class="form-select"> 
								<% for (Especialidad esp : listaEsp) {%>
										<option value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
										<%}%>
								</select>
  				</div>

		  <div class="col-auto">
		   <input type="submit" class="btn btn-light" name="btnBuscar" value="Buscar" ></input></br>
		  </div>
		</form>
<%} %> 		
		
		
<!--	Luego de presionar buscar se cargan los medicos !-->	
<% 		if(request.getParameter("btnBuscar")!=null) {%>

		<form class="row g-3" method="post" action="servletTurnos">
			 
			  
				  <div class="col-auto center">
				   <label class="formulario">Especialidad</label>
				   </div>
				   
				   <% if (request.getAttribute("listaEsp") != null) {%>
				   <div class="col-auto ">
			    			<select  name="especialidad" type="text" class="form-select"> 
			    				<!--	Si la especialidad es la elegida queda seleccionada por default !-->
			    				<% int codigo = Integer.parseInt(session.getAttribute("EspecialidadTurno").toString());%>	
								 <% for (Especialidad esp : listaEsp) {%>
								 		<% int codigo2 = esp.getCodigo(); %>
										<% if(codigo2 == codigo) {%> 
										<option selected="selected" value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
										<%}else{%> 
										 <option value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
										<%}%> 
								<%}%>
								</select>
  				</div>

		  <div class="col-auto">
		   <input type="submit" class="btn btn-light" name="btnBuscar" value="Buscar" ></input></br>
		  </div>
		  	<%}else{%>
		  	<p class="user"> "No hay especialidades" <p>
		  	<%}%>
		</form>


		<br>
		
 
		<form class="row g-3" method="post" action="servletTurnos">
			   <%if (request.getAttribute("listaMedicos") != null && request.getAttribute("listaMedicos") != "") {%>
				 
				 	<div class="col-auto center2">
				   <label class="formulario">Medico</label>
				   </div>
				 
				  <div class="col-auto">
			    		<select  name="medico" type="text" class="form-select"> 
						<% for (Medico mec : listaMedicos) {%>
							<option value="<%=mec.getDni()%>"><%=mec.getNombre() + " " + mec.getApellido()%></option>			
						<%} %>
					</select>
  				</div>

		  <div class="col-auto">
		   <input type="submit" class="btn btn-light" name="btnBuscar2" value="Buscar" ></input></br>
		  </div>
		  
		  <%} else {%>
		  <div class="col-auto center2">
		<p class="user"> "No hay medicos de la especialidad seleccionada" <p>
			</div>	
		<%}%>
		
		</form>
		
		
<%} %>  



<!--	Luego de presionar buscar2 se cargan los turnos !-->	
<% 		if(request.getParameter("btnBuscar2")!=null) {%>

		<form class="row g-3" method="post" action="servletTurnos">
			 
			  
				  <div class="col-auto center">
				   <label class="formulario">Especialidad</label>
				   </div>
				   <div class="col-auto ">
			    			<select  name="especialidad" type="text" class="form-select"> 
			    				<!--	Si la especialidad es la elegida queda seleccionada por default !-->
			    				<% int codigo = Integer.parseInt(session.getAttribute("EspecialidadTurno").toString());%>	
								 <% for (Especialidad esp : listaEsp) {%>
								 		<% int codigo2 = esp.getCodigo(); %>
										<% if(codigo2 == codigo) {%> 
										<option selected="selected" value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
										<%}else{%> 
										 <option value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
										<%}%> 
								<%}%>
								</select>
  				</div>

		  <div class="col-auto">
		   <input type="submit" class="btn btn-light" name="btnBuscar" value="Buscar" ></input></br>
		  </div>
		</form>


		<br>
		

		 <form class="row g-3" method="post" action="servletTurnos">
		 		<div class="col-auto center2">
				   <label class="formulario">Medico</label>
				   </div>
				  <div class="col-auto">
			    			<select  name="medico" type="text" class="form-select">
			    			<% int codigoMedico = Integer.parseInt(session.getAttribute("MedicoTurno").toString());%> 
					<% for (Medico mec : listaMedicos) {%>
							<% int codigo2 = mec.getDni(); %>
								<% if(codigo2 == codigoMedico) {%> 
							<option selected="selected" value="<%=mec.getDni()%>"><%=mec.getNombre() + " " + mec.getApellido()%></option>
							<%}else{%>
							<option value="<%=mec.getDni()%>"><%=mec.getNombre() + " " + mec.getApellido()%></option>
							<%}%>
					<%}%> 
					
					</select>
  				</div>

		  <div class="col-auto">
		   <input type="submit" class="btn btn-light" name="btnBuscar2" value="Buscar" ></input></br>
		  </div>
		</form>  
		
		
		<br>
		
		<form class="row g-3" method="post" action="servletTurnos">
		
		<%if (request.getAttribute("turnosMedico") != null && request.getAttribute("turnosMedico") != "") {%>
				<div class="col-auto center2">
				   <label class="formulario">Turnos</label>
				   </div>
				  <div class="col-auto">
			    	<select  name="turno" type="text" class="form-select"> 
			    	<% 
					 for (Turno turn : listaTurnos) {
					%>
						<option value="<%=turn.getDia() %>  <%=turn.getHorario()%>"><%=turn.getDia() + " " + turn.getHorario()%></option>
					<%}%>
					</select>
  				</div>
  			 
  				
				<div class="col-auto">
					<label class="center3">Pacientes</label>
					</div>
					<div class="col-auto">
					<select  name="paciente" type="text" class="form-select"> 
					<% if(request.getAttribute("listaPac") != null) { %>
					<% for (Paciente pac : listaPac) {%>
							<option value="<%=pac.getCodPaciente()%>"><%=pac.getNombre() + " " + pac.getApellido()%></option>
					<%}%>
					<%}%>
					</select>
					</div>
						
				    <div class="submit">
				     <input type="submit" class="btn btn-light" name="btnEnviar" value="Enviar" ></input></br>
				    </div>
				    
				     <%} else {%>
				  <div class="col-auto center2">
				<p class="user"> "No hay turnos disponibles" <p>
					</div>	
				<%}%>	
			</form>			
<%} %> 







		
					
		  </div>
	</div>
</body>
<%-- cierra el else de la session --%>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>