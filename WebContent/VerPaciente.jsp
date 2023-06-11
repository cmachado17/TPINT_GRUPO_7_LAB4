<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% request.setCharacterEncoding("UTF-8"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&display=swap" rel="stylesheet">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Paciente</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="Principal.jsp"><i class="far fa-hospital px-2"></i>Sistema Clinica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="fa fa-home"></span>Medicos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletClinica?Param=0" class="dropdown-item">Turnos asignados</a></li>
          </ul>
        </li>
      </ul>
      <div class="text-light pt-2">
      	<p>Usuario logeado</p>
      </div>
    </div>
  </div>
</nav>

<div class="container"> 
	<div class="p-3 contenedor-principal">
	<h2 class="tituloForm mb-3"> Detalle paciente </h2>
<form method="post" action="servletClinica">
<div class="formulario">
    <label>DNI</label>
    <input type="number" name="DNI" disabled ></input>
        <label>Nombre</label>
    <input type="text" name="nombre" disabled ></input>
        <label>Apellido</label>
    <input type="text" name="apellido" disabled></input>
        <label>Sexo</label>
    <input type="text" name="sexo" disabled></input>
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
       <label>Tel. fijo</label>
   <input type="tel" name="Telefono" disabled></input>
       <label>Celular</label>
   <input type="tel" name="Celular" disabled></input>
    </div>
    <div class="submit">
     <input type="submit" class="btn btn-light" name="btnVolver" value="Volver" ></input></br>
    </div>
</form>
</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>