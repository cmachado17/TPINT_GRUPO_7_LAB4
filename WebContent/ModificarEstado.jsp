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
<title>Modificar Estado</title>
</head>
<body>

<div class="encabezado">
<div class="sesion">
	<p class="user">Usuario logeado</p>
</div>
</div>

<div class="contenedor">

	<div class="parteIzq">
		<div class="menu">
			<ul>
				<li> <a href="PrincipalMedico.jsp"> <span class="fa fa-home"></span>Medicos</a> 				
					<ul>
						<li class="sub-menu"><a href="servletClinica?Param=0" class="sub-menu">Turnos asignados</a></li>
						
					</ul>	
				</li>
			</ul>
		</div>
	</div>

<div class="parteDer"> 

<h2 class="tituloForm"> Modificar Estado </h2> </br>

<form method="post" action="servletClinica">
<div class="formulario">
	<label>Estado</label>
	<select  name="estado"> 
		<option value="1">Ausente</option>
		<option value="2">Presente</option>
	</select>
		
		<br> <br>
		
    <div class="submit">
     <input type="submit" class="btn btn-light" name="btnVolver" value="Volver" ></input></br>
    </div>
    
</form>

</div>
</div>

</body>
</html>