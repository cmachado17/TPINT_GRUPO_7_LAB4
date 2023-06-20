<%@page import="entidad.DiaSemana"%>
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


<title>Alta Empleados</title>
</head>
<body>
<%
       if(session.getAttribute("Sesion") == null){ 
    	   response.sendRedirect("Home.jsp"); 
       }
       else{
    	   if(Integer.parseInt(session.getAttribute("tipoUsuario").toString()) == 2){ 
        	   response.sendRedirect("Principal.jsp"); 
           }	   	      	
      %>
    	
      
      
      
      
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

			<h2 class="tituloForm">Alta de Empleados</h2>
			
					<%
	int filas =0;
	String mensaje = "";

	if(request.getAttribute("insercionMedico")!=null){
		filas=Integer.parseInt(request.getAttribute("insercionMedico").toString());
		if(filas!=0) {
			mensaje= "Medico agregado correctamente!";
		}
		else{
			mensaje = "Error al agregar al medico.";
		}
	}
	
	
%>  
			
<div class="content" style="text-align: center; font-weight: bold;"><%=mensaje %></div>		<!-- Lo que mostrará el timer -->
			
			
			
			<%
		List<Provincia> listaP = new ArrayList<Provincia>();

		if (request.getAttribute("listaProv") != null) {
			listaP = (List<Provincia>) request.getAttribute("listaProv");
		}
		
		List<Nacionalidad> listaN = new ArrayList<Nacionalidad>();

		if (request.getAttribute("listaNac") != null) {
			listaN = (List<Nacionalidad>) request.getAttribute("listaNac");
		}
		
		List<Especialidad> listaEsp = new ArrayList<Especialidad>();
		
		if (request.getAttribute("listaEsp") != null) {
			listaEsp = (List<Especialidad>) request.getAttribute("listaEsp");
		}
		
		List<DiaSemana> listaDia = new ArrayList<DiaSemana>();
		
		if (request.getAttribute("listaDias") != null) {
			listaDia = (List<DiaSemana>) request.getAttribute("listaDias");
		}
%>
<div class="d-flex justify-content-center text-light">

			<form method="post" action="servletEmpleados" class="w-75">
				<div class="form-group">
				<label>DNI</label> <input type="number" name="DNI" class="form-control" required></input>
				</div>
				<div class="form-group">
				<label>Nombre</label> <input type="text" name="nombre"  class="form-control"required></input>
				</div>
				<div class="form-group">
				<label>Apellido</label> <input type="text" name="apellido" class="form-control" required></input>
				</div>
				<div class="form-group">
					<label>Sexo</label>    
				 	<select name="sexo" required class="form-control">
    					<option value="F">MUJER</option>
    					<option value="M">HOMBRE</option>
   		 			</select> 
				</div>
				<div class="form-group">
					<label>Nacionalidad</label> 
   		 			<select name="nacionalidad" required class="form-control custom-select">
  						<%for (Nacionalidad n : listaN) {%>
  						<option value="<%=n.getCodigo()%>"><%=n.getDescripcion()%></option>
						<%}%>
					</select> 
				</div>
				<div class="form-group">
				 <label>Fecha Nac.</label> <input type="date"
						name="fechaNacimiento" class="form-control" required></input> 
				</div>
				<div class="form-group">
				<label>Direccion</label> 
						<input type="text" name="direccion" required class="form-control"></input>
				</div>
				<div class="form-group">
				 <label>Localidad</label>
					<input type="text" name="localidad" required class="form-control"></input>
				</div>
				<div class="form-group">
					 <label>Provincia</label>
					<select type="text" name="provincia" required class="form-control">
						<%for (Provincia p : listaP) {%>
						<option value="<%=p.getCodigo()%>"><%=p.getDescripcion()%></option>
						<%}%>
					</select> 
				</div>
				<div class="form-group">
				<label>Email</label>
					<input type="email" name="Email" class="form-control" required></input> 
				</div>
				<div class="form-group">
				<label>Tel. fijo</label>
					<input type="tel" name="Telefono" class="form-control" required></input> 
				</div>

					<label>Tipo de Usuario</label>
						<div class="form-check">
							<input type="radio" id="show" name="tipousuario" class="form-check-input" required></input> 
							<label class="form-check-label">Médico</label>
						</div>
						<div class="form-check">
							<input type="radio" id="Hided" name="tipousuario" class="form-check-input" required></input>
							<label class="form-check-label">Administrador</label>
						</div>
				<div id="show-this" style="display:none">
					<div class="form-group">
					<label >Especialidades</label> 
						<select type="text" name="Especialidad" class="form-control">
							<% for (Especialidad esp : listaEsp) {%>
							<option value="<%=esp.getCodigo()%>"><%=esp.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
					<label>Dia de atencion</label> 
						<select type="text" name="dia" class="form-control">
							<% for (DiaSemana dia : listaDia) { %>
							<option value="<%=dia.getCodigo()%>"><%=dia.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
					<label>Hora Inicio</label> 
						<select type="text" name="horaInicio" class="form-control">
							  	<option value="8:00:00">8:00</option>
							  	<option value="8:30:00">8:30</option>
    						 	<option value="9:00:00">9:00</option>
    						 	<option value="9:30:00">9:30</option>
    							<option value="10:00:00">10:00</option>
    							<option value="10:30:00">10:30</option>					
    							<option value="11:00:00">11:00</option>
    						    <option value="11:30:00">11:30</option>
    							<option value="12:00:00">12:00</option>
    							<option value="12:30:00">12:30</option>
    							<option value="13:00:00">13:00</option>
    							<option value="13:30:00">13:30</option>
    							<option value="14:00:00">14:00</option>
    							<option value="14:30:00">14:30</option>
    							<option value="15:00:00">15:00</option>
    							<option value="15:30:00">15:30</option>
    							<option value="16:00:00">16:00</option>
    							<option value="16:30:00">16:30</option>    							
    							<option value="17:00:00">17:00</option>
    							<option value="17:30:00">17:30</option>
    							<option value="18:00:00">18:00</option>
    							<option value="18:30:00">18:30</option>
    							<option value="19:00:00">19:00</option>
    							<option value="19:30:00">19:30</option>  							
    							<option value="20:00:00">20:00</option>
    						   <option value="20:30:00">20:30</option>
    							<option value="12:00:00">21:00</option>
						</select>
					</div>
					<div class="form-group">
					<label>Hora Fin</label> 
						<select type="text" name="horaFin" class="form-control">
							  	<option value="8:00:00">8:00</option>
							  	<option value="8:30:00">8:30</option>
    						 	<option value="9:00:00">9:00</option>
    						 	<option value="9:30:00">9:30</option>
    							<option value="10:00:00">10:00</option>
    							<option value="10:30:00">10:30</option>					
    							<option value="11:00:00">11:00</option>
    						    <option value="11:30:00">11:30</option>
    							<option value="12:00:00">12:00</option>
    							<option value="12:30:00">12:30</option>
    							<option value="13:00:00">13:00</option>
    							<option value="13:30:00">13:30</option>
    							<option value="14:00:00">14:00</option>
    							<option value="14:30:00">14:30</option>
    							<option value="15:00:00">15:00</option>
    							<option value="15:30:00">15:30</option>
    							<option value="16:00:00">16:00</option>
    							<option value="16:30:00">16:30</option>    							
    							<option value="17:00:00">17:00</option>
    							<option value="17:30:00">17:30</option>
    							<option value="18:00:00">18:00</option>
    							<option value="18:30:00">18:30</option>
    							<option value="19:00:00">19:00</option>
    							<option value="19:30:00">19:30</option>  							
    							<option value="20:00:00">20:00</option>
    						   <option value="20:30:00">20:30</option>
    							<option value="12:00:00">21:00</option>
						</select>
					</div>
				</div>

				<div class="submit">
					<input type="submit" name="btnEnviar-empleados" value="Enviar"
						class="btn btn-light"></input>
				</div>
			</form>
			
			</div>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
const box = document.getElementById('show-this');

function handleRadioClick() {
  if (document.getElementById('show').checked) {
    box.style.display = 'block';
  } else {
    box.style.display = 'none';
  }
}

const radioButtons = document.querySelectorAll('input[name="tipousuario"]');
radioButtons.forEach(radio => {
  radio.addEventListener('click', handleRadioClick);
});
<% } %>
</script>


</html>