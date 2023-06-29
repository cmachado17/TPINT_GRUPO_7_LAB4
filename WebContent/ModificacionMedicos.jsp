<%@page import="java.util.logging.Formatter"%>
<%@page import="entidad.Medico"%>
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
    <%
       if(session.getAttribute("Sesion") == null){ 
    	   response.sendRedirect("Home.jsp"); 
       }
       else{
      %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<!-- Agrega los enlaces a SweetAlert2 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.js"></script>

<script>
    // Función para mostrar el mensaje de confirmación
    function confirmarModificacion() {
        Swal.fire({
            title: 'Confirmación',
            text: '¿Estás seguro de que deseas modificar este registro?',
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Modificar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
            	Swal.fire({
            		  position: 'center',
            		  icon: 'success',
            		  title: 'Registro modificado!',
            		  showConfirmButton: false,
            		  timer: 1500
            		})
            		setTimeout(function(){
            			document.getElementById('formularioModificacion').submit()
					}, 1500);
            }
        });
    }
    
    function validarHorario() {
        var horaInicio = parseInt(document.getElementById('horaInicio').value.split(':')[0]);
        var horaFin = parseInt(document.getElementById('horaFin').value.split(':')[0]);

        if (horaInicio >= horaFin) {
            Swal.fire({
                title: 'Error',
                text: 'La hora de fin debe ser mayor a la hora de inicio!',
                icon: 'error',
                confirmButtonText: 'Aceptar'
            });
            return false;
        }
        return true;
    }
    
	 // Función para interceptar el envío del formulario
    function interceptarEnvioFormulario(event) {
        event.preventDefault(); // Evita que el formulario se envíe automáticamente
        if (validarHorario()){ // valido horarios de inicio y fin 
        	 confirmarModificacion(); // Muestra el mensaje de confirmación
        }        
    }
</script>
<title>Modificacion Medicos</title>

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
            <li><a href="servletPacientes?Param=1" class="dropdown-item">Estadísticas Pacientes</a></li>
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
			<h2 class="tituloForm">Modificacion Medicos</h2>

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
		
		Medico medico = null;
		if(request.getAttribute("MedicoModificable") != null) {
			medico = (Medico)request.getAttribute("MedicoModificable");
		}
		
%>
		<div class="d-flex justify-content-center text-light">
			<form method="POST" action="servletEmpleados?btnModificar=1" id="formularioModificacion" onsubmit="interceptarEnvioFormulario(event)" class="w-75">
				<div class="form-group">
					<label>DNI</label> <input type="number" name="DNI" min="1111111" max="99999999" class="form-control" readonly="readonly" value="<%=medico.getDni()%>" style="background-color: lightgrey;"></input>
					<label>Nombre</label> <input type="text" name="nombre" minlength="3" maxlength="20"  class="form-control"required value="<%=medico.getNombre()%>"></input>
					<label>Apellido</label> <input type="text" name="apellido"  minlength="3" maxlength="30" class="form-control" required value="<%=medico.getApellido()%>"></input>
					<label>Sexo</label>    
				 	<select name="sexo" required class="form-select">
    					<option value="M" <% if (medico.getSexo() == "M") {%>selected <%}%>>M</option>
    					<option value="F" <% if (medico.getSexo()  == "F") {%>selected <%}%>>F</option>
   		 			</select> 
					<label>Nacionalidad</label> 
   		 			<select name="nacionalidad" required class="form-select custom-select">
  					<%for (Nacionalidad n : listaN) {%>
						<option value="<%=n.getCodigo()%>" <% if (medico.getNacionalidad().getCodigo()    == n.getCodigo()) {%>selected <%}%>><%=n.getDescripcion()%></option>
					<%}%>
					</select> 
					<label>Fecha Nac.</label> <input type="date" name="fechaNacimiento" required class="form-control" value="<%=medico.getFechaNacimiento()%>"></input> 
					<label>Direccion</label> <input type="text" name="direccion" minlength="3" maxlength="40"  required class="form-control" value="<%=medico.getDireccion() %>"></input>
					<label>Localidad</label><input type="text" name="localidad" minlength="3" maxlength="20" required class="form-control" value="<%=medico.getLocalidad() %>"></input>
					 <label>Provincia</label>
					<select type="text" name="provincia" required class="form-select">
						<%for (Provincia p : listaP) {%>
							<option value="<%=p.getCodigo()%>" <% if (medico.getProvincia().getCodigo()== p.getCodigo()) {%>selected <%}%>><%=p.getDescripcion()%></option>
						<%}%>
					</select> 
					<label>Email</label> <input type="email" name="email"  minlength="3" maxlength="40" required class="form-control" value="<%=medico.getEmail() %>"></input> 
					<label>Telefono</label> <input type="tel" name="telefono" minlength="6" maxlength="15" required class="form-control" value="<%=medico.getTelefono() %>"></input> 
					</div>
						
							
					<div id="show-this">
					<div class="form-group">
					<label >Especialidades</label> 
						<select type="text" name="especialidad" class="form-select">
							<% for (Especialidad esp : listaEsp) {%>
							<option value="<%=esp.getCodigo()%>" <% if (medico.getEspecialidad().getCodigo() == esp.getCodigo()) {%>selected <%}%>><%=esp.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
					<label>Dia de atencion</label> 
						<select type="text" name="dia" class="form-select">
							<% for (DiaSemana dia : listaDia) { %>
							<option value="<%=dia.getCodigo()%>" <% if (medico.getDiaAtencion().getCodigo() == dia.getCodigo()) {%>selected<%}%>><%=dia.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
					<label>Hora Inicio</label> 
						<select type="text" name="horaInicio"  id="horaInicio" class="form-select">
							  	<option value="8:00:00" <% if (medico.getHorarioInicioAtencion().equals(("08:00:00").toString())) {%> selected<%}%>>8:00</option>
    						 	<option value="9:00:00" <% if (medico.getHorarioInicioAtencion().equals(("09:00:00").toString())) {%> selected<%}%>>9:00</option>
    							<option value="10:00:00" <% if (medico.getHorarioInicioAtencion().equals(("10:00:00").toString())) {%> selected<%}%>>10:00</option>			
    							<option value="11:00:00" <% if (medico.getHorarioInicioAtencion().equals(("11:00:00").toString())) {%> selected<%}%>>11:00</option>
    							<option value="12:00:00"<% if (medico.getHorarioInicioAtencion().equals(("12:00:00".toString()))) {%> selected<%}%>>12:00</option>
    							<option value="13:00:00"<% if (medico.getHorarioInicioAtencion().equals(("13:00:00".toString()))) {%> selected<%}%>>13:00</option>
    							<option value="14:00:00"<% if (medico.getHorarioInicioAtencion().equals(("14:00:00".toString()))) {%> selected<%}%>>14:00</option>
    							<option value="15:00:00"<% if (medico.getHorarioInicioAtencion().equals(("15:00:00".toString()))) {%> selected<%}%>>15:00</option>
    							<option value="16:00:00"<% if (medico.getHorarioInicioAtencion().equals(("16:00:00".toString()))) {%> selected<%}%>>16:00</option>  							
    							<option value="17:00:00"<% if (medico.getHorarioInicioAtencion().equals(("17:00:00".toString()))) {%> selected<%}%>>17:00</option>
    							<option value="18:00:00"<% if (medico.getHorarioInicioAtencion().equals(("18:00:00".toString()))) {%> selected<%}%>>18:00</option>
								<option value="19:00:00"<% if (medico.getHorarioInicioAtencion().equals(("19:00:00".toString()))) {%> selected<%}%>>19:00</option>
								<option value="20:00:00"<% if (medico.getHorarioInicioAtencion().equals(("20:00:00".toString()))) {%> selected<%}%>>20:00</option>
								<option value="21:00:00"<% if (medico.getHorarioInicioAtencion().equals(("21:00:00".toString()))) {%> selected<%}%>>21:00</option>
						</select>
					</div>
					<div class="form-group">
					<label>Hora Fin</label> 
						<select type="text" name="horaFin" id="horaFin" class="form-select">
							  	<option value="8:00:00" <% if (medico.getHorarioFinAtencion().equals(("08:00:00".toString()))) {%> selected<%}%>>8:00</option>
    						 	<option value="9:00:00" <% if (medico.getHorarioFinAtencion().equals(("09:00:00".toString()))) {%> selected<%}%>>9:00</option>
    							<option value="10:00:00" <% if (medico.getHorarioFinAtencion().equals(("10:00:00".toString()))) {%> selected<%}%>>10:00</option>			
    							<option value="11:00:00" <% if (medico.getHorarioFinAtencion().equals(("11:00:00".toString()))) {%> selected<%}%>>11:00</option>
    							<option value="12:00:00"<% if (medico.getHorarioFinAtencion().equals(("12:00:00".toString()))) {%> selected<%}%>>12:00</option>
    							<option value="13:00:00"<% if (medico.getHorarioFinAtencion().equals(("13:00:00".toString()))) {%> selected<%}%>>13:00</option>
    							<option value="14:00:00"<% if (medico.getHorarioFinAtencion().equals(("14:00:00").toString())) {%> selected<%}%>>14:00</option>
    							<option value="15:00:00"<% if (medico.getHorarioFinAtencion().equals(("15:00:00".toString()))) {%> selected<%}%>>15:00</option>
    							<option value="16:00:00"<% if (medico.getHorarioFinAtencion().equals(("16:00:00").toString())) {%> selected<%}%>>16:00</option>  							
    							<option value="17:00:00"<% if (medico.getHorarioFinAtencion().equals(("17:00:00".toString()))) {%> selected<%}%>>17:00</option>
    							<option value="18:00:00"<% if (medico.getHorarioFinAtencion().equals(("18:00:00".toString()))) {%> selected<%}%>>18:00</option>
								<option value="19:00:00"<% if (medico.getHorarioFinAtencion().equals(("19:00:00".toString()))) {%> selected<%}%>>19:00</option>
								<option value="20:00:00"<% if (medico.getHorarioFinAtencion().equals(("20:00:00".toString()))) {%> selected<%}%>>20:00</option>
								<option value="21:00:00"<% if (medico.getHorarioFinAtencion().equals(("21:00:00".toString()))) {%> selected<%}%>>21:00</option>
						</select>
					</div>
				</div>
				<div class="submit">
					<input type="submit" class="btn btn-light" name="btnModificar"
						value="Modificar"></input>
				</div>
			</form>
		</div>
	</div>
</body>
<% } %>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
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

</script>
</html>