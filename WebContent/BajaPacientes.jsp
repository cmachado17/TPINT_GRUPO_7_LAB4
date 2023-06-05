<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% request.setCharacterEncoding("UTF-8"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>

<title>Baja Pacientes</title>
</head>
<body>

<div class="encabezado">
<div class="sesion">
	<p>Usuario logueado</p>
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

<h2> Baja de pacientes </h2> </br>

<form method="post" action="ServletHTML">
<input type="text" name="buscar">
<input type="submit" name="btnBuscar" value="Buscar">
</form>

<br> <br>


<form method="post" action="ServletHTML">
<div class="formulario">
    <label>DNI</label>
    <input type="number" name="DNI" disabled ></input>
        <label>Nombre</label>
    <input type="text" name="nombre" disabled ></input>
        <label>Apellido</label>
    <input type="text" name="apellido" disabled></input>
        <label>Nacionalidad</label>
   <input type="text" name="nacionalidad" disabled></input>
        <label>Fecha</label>
    <input type="date" name="fechaNacimiento" disabled></input>
        <label>Direccion</label>
    <input type="text" name="direccion" disabled></input>
        <label>Localidad</label>
    <input type="text" name="localidad" disabled></input>
        <label>Provincia</label>
    <input type="text" name="provincia" disabled></input>
       <label>Email</label>
     <input type="email" name="Email" disabled></input>
       <label>Telefono</label>
   <input type="tel" name="Telefono" disabled></input>
    </div>
    <div class="submit">
     <input type="submit" name="btnEnviar" value="Enviar" ></input></br>
    </div>
</form>

</div>
</div>

</body>
</html>