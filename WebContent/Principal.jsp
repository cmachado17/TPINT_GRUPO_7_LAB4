<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% request.setCharacterEncoding("UTF-8"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

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
						<li class="sub-menu"><a href="servletClinica?Param=0" class="sub-menu">Alta Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=1" class="sub-menu">Baja Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=2" class="sub-menu">Modificacion Pacientes</a></li>
						<li class="sub-menu"><a href="servletClinica?Param=3" class="sub-menu">Listado Pacientes</a></li>
					</ul>
			
			</li>
					<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Medicos</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=3" >Mis turnos</a></li>
					</ul>
					
					<li> <a href="Principal.jsp"> <span class="fa fa-home"></span>Turnos</a> 
			
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=3" >Mis turnos</a></li>
					</ul>
			

		</ul>
		</div>

</div>
<div class="parteDer"> 

<form class="login">
<div class="mb-3">
  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Ingrese su usuario" requiered>
</div>
<div class="mb-3">
 <input  type="text" class="form-control" id="exampleFormControlInput1" placeholder="Ingrese su clave" requiered>
</div>
<div class="mb-3">
 <input type="submit" class="btn btn-primary" class="form-control" id="exampleFormControlInput1" value="Ingresar" name="btnIngresar">
</div>
</form>


</div>





</div>




</body>
</html>