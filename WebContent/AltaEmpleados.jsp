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
<title>Alta Empleados</title>
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
						<!--<li class="sub-menu"><a href="servletEmpleadoss?Param=1" class="sub-menu">Baja Empleados</a></li>-->
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

<h2 class="tituloForm"> Alta de Empleados </h2> </br>

<form method="post" action="ServletHTML">
<div class="formulario">
    <label>DNI</label>
    <input type="number" name="DNI" required></input>
        <label>Nombre</label>
    <input type="text" name="nombre" required></input>
        <label>Apellido</label>
    <input type="text" name="apellido" required></input>
        <label>Sexo</label>
    <input type="text" name="sexo" required></input>
        <label>Nacionalidad</label>
   <input type="text" name="nacionalidad" required></input>
        <label>Fecha Nac.</label>
    <input type="date" name="fechaNacimiento"></input>
        <label>Direccion</label>
    <input type="text" name="direccion" required></input>
        <label>Localidad</label>
    <input type="text" name="localidad" required></input>
        <label>Provincia</label>
    <input type="text" name="provincia" required></input>
       <label>Email</label>
     <input type="email" name="Email"></input>
       <label>Tel. fijo</label>
   <input type="tel" name="Telefono"></input>
       <label>Celular</label>
   <input type="tel" name="Celular"></input>
       <label>Tipo de Usuario</label>     	 
    	 <ul>
			<td> <input type="checkbox" name="Medico"></input> M�dico</td>
			<td> <input type="checkbox" name="Admin"></input> Administrador</td>
		</ul>
        <label>Especialidades</label>
   <input type="text" name="Especialidad"></input>
    </div>
    <div class="submit">
     <input type="submit" name="btnEnviar" value="Enviar" class="btn btn-light"></input>
    </div>
</form>

</div>
</div>

</body>
</html>