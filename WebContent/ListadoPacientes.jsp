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

<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

<title>Listado de Pacientes</title>
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
				<p>Usuario logeado</p>
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
					<tr>
						<td scope="row">111111</td>
						<td>Carlos</td>
						<td>Luna</td>
						<!-- Codigo comentado: Observar que utilizo el onClick al servlet y le paso de parámetro el nombre del boton con otros atributos -->
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=111111&txtNombre=Carlos&txtApellido=Luna'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=111111&txtNombre=Carlos&txtApellido=Luna'" /></td>
					</tr>
					<tr>
						<td scope="row">222222</td>
						<td>Martin</td>
						<td>Galmarini</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=222222&txtNombre=Martin&txtApellido=Galmarini'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=222222&txtNombre=Martin&txtApellido=Galmarini'" /></td>
					</tr>
					<tr>
						<td scope="row">333333</td>
						<td>Diego</td>
						<td>Morales</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=333333&txtNombre=Diego&txtApellido=Morales'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=333333&txtNombre=Diego&txtApellido=Morales'" /></td>
					</tr>
					<tr>
						<td scope="row">444444</td>
						<td>Gonzalo</td>
						<td>Marinelli</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=444444&txtNombre=Gonzalo&txtApellido=Marinelli'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=444444&txtNombre=Gonzalo&txtApellido=Marinelli'" /></td>
					</tr>
					<tr>
						<td scope="row">555555</td>
						<td>Lucas</td>
						<td>Menossi</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=555555&txtNombre=Lucas&txtApellido=Menossi'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=555555&txtNombre=Lucas&txtApellido=Menossi'" /></td>
					</tr>
					<tr>
						<td scope="row">666666</td>
						<td>Lucas</td>
						<td>Janson</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=666666&txtNombre=Lucas&txtApellido=Janson'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=666666&txtNombre=Lucas&txtApellido=Janson'" /></td>
					</tr>
					<tr>
						<td scope="row">777777</td>
						<td>Federico</td>
						<td>Gonzalez</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=777777&txtNombre=Federico&txtApellido=Gonzalez'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=777777&txtNombre=Federico&txtApellido=Gonzalez'" /></td>
					</tr>
					<tr>
						<td scope="row">888888</td>
						<td>Walter</td>
						<td>Montillo</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=888888&txtNombre=Walter&txtApellido=Montillo'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=888888&txtNombre=Walter&txtApellido=Montillo'" /></td>
					</tr>
					<tr>
						<td scope="row">999999</td>
						<td>Nestor</td>
						<td>Gorosito</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=999999&txtNombre=Nestor&txtApellido=Gorosito'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=999999&txtNombre=Nestor&txtApellido=Gorosito'" /></td>
					</tr>
					<tr>
						<td scope="row">101010</td>
						<td>Juani</td>
						<td>Cavalaro</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=101010&txtNombre=Juani&txtApellido=Cavalaro'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=101010&txtNombre=Juani&txtApellido=Cavalaro'" /></td>
					</tr>
					<tr>
						<td scope="row">122222</td>
						<td>Gerardo</td>
						<td>Alcoba</td>
						<td><input type="submit" value="Eliminar" name="btnEliminar"
							onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=122222&txtNombre=Gerardo&txtApellido=Alcoba'" /></td>
						<td><input type="submit" value="Editar" name="btnEditar"
							onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=122222&txtNombre=Gerardo&txtApellido=Alcoba'" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>
