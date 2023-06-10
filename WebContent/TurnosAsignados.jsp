<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&display=swap" rel="stylesheet">
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
<title>Turnos asignados</title>
</head>
<body>

<div class="encabezado">
<div class="sesion">
	 <p class="user"> Usuario logeado</p>
</div>
</div>

<div class="contenedor">

	<div class="parteIzq">
		<div class="menu">
			<ul>
				<li> <a href="PrincipalMedico.jsp"> <span class="fa fa-home"></span>Medicos</a> 				
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=0" class="sub-menu">Listado de turnos</a></li>
						
					</ul>	
				</li>
			</ul>
		</div>
	</div>


<div class="parteDer"> 

<h2 class="tituloForm"> Turnos asignados </h2> </br>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Dia y Horario</th>
				<th>Paciente</th>
				<th></th>
				<th>Estado</th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>17/06/2023 17:00 HS</td>
				<td>Roberto Gomez</td>
				<td><input type="submit" class="btn btn-light" value="Ver" name="btnVer" onclick="window.location.href='servletClinica?btnVer'"/></td>
				<td>Ocupado</td>
				<td><input type="submit" class="btn btn-light" value="Editar" name="btnEditarEstado" onclick="window.location.href='servletClinica?btnEditarEstado'"/></td>
			</tr>
		</tbody>
	</table>


</div>
</div>

</div>

</body>
</html>