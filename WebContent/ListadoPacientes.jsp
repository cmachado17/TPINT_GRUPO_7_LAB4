<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Pacientes</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

</head>
<body>

<div class="encabezado">
<div class="sesion">
	<p>Usuario logeado</p>
</div>
</div>

<div class="contenedor">
<div class="parteIzq">

		<div class="menu">
		<ul>
			<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Pacientes</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=0" class="sub-menu">Alta Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=1" class="sub-menu">Baja Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=2" class="sub-menu">Modificacion Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=3" class="sub-menu">Listado Pacientes</a></li>
					</ul>
			
			</li>
					<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Medicos</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=4" >Mis turnos</a></li>
					</ul>
					
					<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Turnos</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=3" >Mis turnos</a></li>
					</ul>
			

		</ul>
		</div>

</div>



<div class="parteDer"> 

<h2> Listado de Pacientes </h2> </br>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>111111</td>
				<td>Carlos</td>
				<td>Luna</td>
				<!-- Codigo comentado: Observar que utilizo el onClick al servlet y le paso de par�metro el nombre del boton con otros atributos -->
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=111111&txtNombre=Carlos&txtApellido=Luna'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=111111&txtNombre=Carlos&txtApellido=Luna'"/></td>
			</tr>
			<tr>
				<td>222222</td>
				<td>Martin</td>
				<td>Galmarini</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=222222&txtNombre=Martin&txtApellido=Galmarini'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=222222&txtNombre=Martin&txtApellido=Galmarini'"/></td>
			</tr>
			<tr>
				<td>333333</td>
				<td>Diego</td>
				<td>Morales</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=333333&txtNombre=Diego&txtApellido=Morales'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=333333&txtNombre=Diego&txtApellido=Morales'"/></td>
			</tr>
			<tr>
				<td>444444</td>
				<td>Gonzalo</td>
				<td>Marinelli</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=444444&txtNombre=Gonzalo&txtApellido=Marinelli'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=444444&txtNombre=Gonzalo&txtApellido=Marinelli'"/></td>
			</tr>
			<tr>
				<td>555555</td>
				<td>Lucas</td>
				<td>Menossi</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=555555&txtNombre=Lucas&txtApellido=Menossi'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=555555&txtNombre=Lucas&txtApellido=Menossi'"/></td>
			</tr>
			<tr>
				<td>666666</td>
				<td>Lucas</td>
				<td>Janson</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=666666&txtNombre=Lucas&txtApellido=Janson'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=666666&txtNombre=Lucas&txtApellido=Janson'"/></td>
			</tr>
			<tr>
				<td>777777</td>
				<td>Federico</td>
				<td>Gonzalez</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=777777&txtNombre=Federico&txtApellido=Gonzalez'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=777777&txtNombre=Federico&txtApellido=Gonzalez'"/></td>
			</tr>
			<tr>
				<td>888888</td>
				<td>Walter</td>
				<td>Montillo</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=888888&txtNombre=Walter&txtApellido=Montillo'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=888888&txtNombre=Walter&txtApellido=Montillo'"/></td>
			</tr>
			<tr>
				<td>999999</td>
				<td>Nestor</td>
				<td>Gorosito</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=999999&txtNombre=Nestor&txtApellido=Gorosito'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=999999&txtNombre=Nestor&txtApellido=Gorosito'"/></td>
			</tr>
			<tr>
				<td>101010</td>
				<td>Juani</td>
				<td>Cavalaro</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=101010&txtNombre=Juani&txtApellido=Cavalaro'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=101010&txtNombre=Juani&txtApellido=Cavalaro'"/></td>
			</tr>
			<tr>
				<td>122222</td>
				<td>Gerardo</td>
				<td>Alcoba</td>
				<td><input type="submit" value="Eliminar" name="btnEliminar" onclick="window.location.href='servletPacientes?btnEliminar=1&txtDni=122222&txtNombre=Gerardo&txtApellido=Alcoba'"/></td>
				<td><input type="submit" value="Editar" name="btnEditar" onclick="window.location.href='servletPacientes?btnEditar=1&txtDni=122222&txtNombre=Gerardo&txtApellido=Alcoba'"/></td>
			</tr>
		</tbody>
	</table>


</div>
</div>

</body>
</html>
