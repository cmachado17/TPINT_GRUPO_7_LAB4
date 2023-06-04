<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Home</title>
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
			<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Administrador</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=0" class="sub-menu">Alta Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=1" class="sub-menu">Alta Medicos</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=2" class="sub-menu">Asignacion Turnos</a></li>
					</ul>
			
			</li>
					<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Medico</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=3" >Mis turnos</a></li>
					</ul>
			

		</ul>
		</div>

</div>
<div class="parteDer"> 


<h2> Home </h2> </br>

</div>
</div>
</body>
</html>