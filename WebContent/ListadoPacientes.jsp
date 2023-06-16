<%@ page import="entidad.Paciente"%>
<%@ page import="java.util.ArrayList" %>
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>


<!-- Agrega los enlaces a SweetAlert2 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.15.5/dist/sweetalert2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

<script>
    // Función para mostrar el cartel de confirmación
    function confirmarEliminacion(dni) {

        Swal.fire({
            title: 'Confirmación',
            text: '¿Estás seguro de que deseas eliminar este registro?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Eliminar'
        }).then((result) => {
            if (result.isConfirmed) {
                // Si el usuario confirma la eliminación, envía el formulario
                //event.target.submit();
                window.location.href='servletPacientes?btnEliminar=1&txtDni='+ dni
                		
            }
        });
    }
</script>


<title>Listado de Pacientes</title>
</head>
<%
ArrayList <Paciente> listaPacientes = null;
if(request.getAttribute("listaPacientes") != null){
	listaPacientes = (ArrayList <Paciente>) request.getAttribute("listaPacientes");
}
%>
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

			<h2 class="tituloForm">Listado de Pacientes</h2>
			</br>
			<table id="table_id" class="display table table-striped bg-light">
				<thead>
					<tr>
						<th scope="col">Dni</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>	
					<% if(listaPacientes != null)
						for(Paciente paciente : listaPacientes){%>
						<tr>			
							<td scope="row"><%=paciente.getDni() %> </td>
							<td scope="row"><%= paciente.getNombre()%></td>
							<td scope="row"><%= paciente.getApellido() %></td>
							<td><input type="submit" value="Eliminar" name="btnEliminar"
								onclick="confirmarEliminacion(<%= paciente.getDni()%>)" /></td>
							<td><input type="submit" value="Editar" name="btnEditar"
								onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=<%=paciente.getDni() %>&txtNombre=<%= paciente.getNombre()%>&txtApellido=<%= paciente.getApellido() %>'" /></td>
						</tr>
					<%} %>					
				</tbody>
			</table>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>
