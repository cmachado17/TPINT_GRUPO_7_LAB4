<%@ page import="entidad.Paciente"%>
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
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Modificacion Paciente</title>

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
            confirmButtonText: 'Modificar'
        }).then((result) => {
            if (result.isConfirmed) {
                // Si el usuario confirma la modificación, envía el formulario
                document.getElementById('formularioModificacion').submit();
            }
        });
    }
    
	 // Función para interceptar el envío del formulario
    function interceptarEnvioFormulario(event) {
        event.preventDefault(); // Evita que el formulario se envíe automáticamente
        confirmarModificacion(); // Muestra el mensaje de confirmación
    }
</script>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="Principal.jsp"><i
			class="far fa-hospital px-2"></i>Sistema Clinica</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> <span
						class="fa fa-home"></span>Pacientes
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a href="servletPacientes?Param=0" class="dropdown-item">Alta
								Pacientes</a></li>
						<li><a href="servletPacientes?Param=3" class="dropdown-item">Listado
								Pacientes</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> <span
						class="fa fa-home"></span>Empleados
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a href="servletEmpleados?Param=0" class="dropdown-item">Alta
								Empleados</a></li>
						<li><a href="servletEmpleados?Param=3" class="dropdown-item">Listado
								Empleados</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> <span
						class="fa fa-home"></span>Turnos
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a href="servletTurnos?Param=0" class="dropdown-item">Alta
								Turno</a></li>
						<li><a href="servletTurnos?Param=1" class="dropdown-item">Listado
								Turnos</a></li>
					</ul></li>
			</ul>
			<div class="text-light pt-2">
				 <% if(session.getAttribute("Sesion") != null){ %>
      	<p><%= session.getAttribute("Sesion") %></p>
      	<a href="servletUsuarios?logout=1">Logout</a>
      <%}else{ %>
      	<p>No logeado</p>
      	<%} %>
			</div>
		</div>
	</div>
	</nav>


	<div class="container">
		<div class="p-3 contenedor-principal">

			<h2 class="tituloForm">Modificacion Paciente</h2>

			<!--<form method="post" action="ServletHTML">
<div class="formulario">
<input type="text" name="buscar">
<input type="submit" class="btn btn-light" name="btnBuscar" value="Buscar">
</div>
</form> -->

			<br>
			<% Paciente paciente = null;
			if(request.getAttribute("PacienteModificable") != null) {
				paciente = (Paciente)request.getAttribute("PacienteModificable");
			%>
			<form method="POST" action="servletPacientes?btnModificar=1" id="formularioModificacion" onsubmit="interceptarEnvioFormulario(event)">
				<div class="formulario">
					<label>DNI</label> <input type="number" name="DNI" readonly="readonly" value="<%=paciente.getDni() %>" style="background-color: lightgrey;"></input>
					<label>Nombre</label> <input type="text" name="nombre" required value="<%=paciente.getNombre() %>"></input>
					<label>Apellido</label> <input type="text" name="apellido" required value="<%=paciente.getApellido() %>"></input>
					<label>Sexo</label> <select name="sexo" required >
						<option value="1" <% if (paciente.getSexo() == "M") {%>selected <%}%>>Hombre</option>
						<option value="2" <% if (paciente.getSexo()  == "F") {%>selected <%}%>>Mujer</option>
					</select> <label>Nacionalidad</label> <select name="nacionalidad" required>
						<!-- Se cargan desde la BD -->
						<option value="1" <% if (paciente.getCodNacionalidad().getCodigo()== 1) {%>selected <%}%>>Argentina</option>
						<option value="2" <% if (paciente.getCodNacionalidad().getCodigo() == 2) {%>selected <%}%>>Chile</option>
						<option value="3" <% if (paciente.getCodNacionalidad().getCodigo() == 3) {%>selected <%}%>>Uruguay</option>
						<option value="4" <% if (paciente.getCodNacionalidad().getCodigo() == 4) {%>selected <%}%>>Bolivia</option>
					</select> <label>Fecha</label> 
					<input type="date" name="fechaNacimiento" value="<%=paciente.getFechaNacimiento()%>"></input>
					<label>Direccion</label> 
					<input type="text" name="direccion" required value="<%=paciente.getDireccion() %>"></input>
					<label>Localidad</label> 
					<input type="text" name="localidad" required value="<%=paciente.getLocalidad()%>"></input> 
					<label>Provincia</label>
					 <input type="text" name="provincia" required value="<%=paciente.getProvincia()%>"></input> 
					<label>Email</label>
					<input type="email" name="Email" value="<%=paciente.getEmail() %>"></input> 
					<label>Tel. fijo</label>
					<input type="tel" name="Telefono" value="<%=paciente.getTelefono() %>"></input> 
				</div>
				<div class="submit">
					<input type="submit" class="btn btn-light" name="btnModificar"></input></br>
				</div>
			</form>
<%} %>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</html>