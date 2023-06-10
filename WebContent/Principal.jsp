<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% request.setCharacterEncoding("UTF-8"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&display=swap" rel="stylesheet">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Home</title>
</head>
<body>
|
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
	
	<div class="text-bg-light p-3">
		<form class="login">
			<div class="mb-3">
		 		<H1>User: </H1>
			  		<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="clinica@utn.com" requiered>
			</div>
			<div class="mb-3">
				<H1>Password: </H1>
			 		<input  type="password" class="form-control" id="exampleFormControlInput1" placeholder="************" requiered>
			</div>
			<div class="mb-3">
				<input type="submit" class="btn btn-primary" class="form-control" id="exampleFormControlInput1" value="Ingresar" name="btnIngresar">
			</div>
		</form>
		
</div>

</div>
</div>

</body>
</html>