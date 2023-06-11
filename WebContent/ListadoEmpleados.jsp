<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
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

<title>Listado de empleados</title>
</head>
<body>

<div class="encabezado">
<div class="sesion">
	<p class="user" >Usuario logeado</p>
</div>
</div>

<div class="contenedor">
	<div class="parteIzq">
		<div class="menu">
			<ul>
				<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Pacientes</a> 				
					<ul>
						<li class="sub-menu"><a href="servletPacientes?Param=0" class="sub-menu">Alta Pacientes</a></li>
						<!-- <li class="sub-menu"><a href="servletPacientes?Param=1" class="sub-menu">Baja Pacientes</a></li> -->
						<!--<li class="sub-menu"><a href="servletPacientes?Param=2" class="sub-menu">Modificacion Pacientes</a></li>-->
						<li class="sub-menu"><a href="servletPacientes?Param=3" class="sub-menu">Listado Pacientes</a></li>
					</ul>	
				</li>
				<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Empleados</a> 				        
					<ul>
					    <li class="sub-menu"><a href="servletEmpleados?Param=0" class="sub-menu">Alta Empleados</a></li>
						<!--<li class="sub-menu"><a href="servletEmpleados?Param=1" class="sub-menu">Baja Empleados</a></li>-->
						<!--<li class="sub-menu"><a href="servletEmpleados?Param=2" class="sub-menu">Modificacion Empleados</a></li>-->
						<li class="sub-menu"><a href="servletEmpleados?Param=3" class="sub-menu">Listado Empleados</a></li>
															
					</ul>
				</li>					
				<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Turnos</a> 				
					<ul>
						<li class="sub-menu"><a href="servletTurnos?Param=0" >Asignar Turno</a></li>
						<li class="sub-menu"><a href="servletTurnos?Param=1" >Listado Turnos</a></li>
						<!--<li class="sub-menu"><a href="servletTurnos?Param=2" >Anular Turno</a></li>-->
					</ul>
				</li>
			</ul>
		</div>
	</div>
		
<div class="parteDer"> 

<h2 class="tituloForm"> Listado de Empleados </h2> </br>
	<table id="table_id" class="display table table-striped">
		<thead>
			<tr>
				<th scope="col">Legajo</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido</th>
				<th scope="col">Sexo</th>
				<th scope="col">Nacionalidad</th>
				<th scope="col">Fecha Nacimiento</th>
				<th scope="col">Correo electronico</th>
				<th scope="col">Especialidad</th>
				
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td scope="row">111111</td>
				<td>Carlos</td>
				<td>Luna</td>
				<td>Hombre</td>
				<td>Argentina</td>
				<td>11/08/1980</td>
				<td>cluna@gmail.com</td>
				<td>Clinica</td>
				<!-- Codigo comentado: Observar que utilizo el onClick al servlet y le paso de parámetro el nombre del boton con otros atributos -->
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletMedicos?btnEliminar=1'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletMedicos?btnEditar=1'"/></td>
			</tr>
					<tr>
				<td scope="row">111111</td>
				<td>Carlos</td>
				<td>Luna</td>
				<td>Hombre</td>
				<td>Argentina</td>
				<td>11/08/1980</td>
				<td>cluna@gmail.com</td>
				<td>Clinica</td>
				<!-- Codigo comentado: Observar que utilizo el onClick al servlet y le paso de parámetro el nombre del boton con otros atributos -->
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletMedicos?btnEliminar=1'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletMedicos?btnEditar=1'"/></td>
			</tr>
		</tbody>
	</table>


</div>
</div>

</body>
</html>