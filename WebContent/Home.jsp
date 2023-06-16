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


<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {			//script para hacer que el cartel de "Paciente agregado correctamente" se desvanezca a los 3 seg luego de aparecer
    setTimeout(function() {
        $(".content").fadeOut(1500);
    },3000);
});
</script>


<title>Home</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="Home.jsp"><i class="far fa-hospital px-2"></i>Sistema Clinica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    </div>
</nav>

<div class="container"> 
	<div class="text-bg-light p-3 contenedor-principal">
	<% if(session.getAttribute("Sesion") == null){ %>
		<form class="login" method="post" action="servletUsuarios">
			<div class="mb-3">
		 		<H1>User: </H1>
			  		<input type="number"  min="1111111" max="99999999"  class="form-control" id="exampleFormControlInput1" placeholder="Ingrese su DNI" name="txtUsuario" required>
			</div>
			<div class="mb-3">
				<H1>Password: </H1>
			 		<input  type="password" type="number"  class="form-control" id="exampleFormControlInput1" placeholder="Ingrese su clave" name="txtClave" required>
			</div>
			<div class="mb-3">
				<input type="submit" class="btn btn-primary" class="form-control" id="exampleFormControlInput1" value="Ingresar" name="btnIngresar-login">
			</div>
		</form>
		<%}%>
	
	</div>
</div>
<%
	int filas =0;
	String mensaje = "";

	if(request.getAttribute("estadoLogin")!=null){
		filas=Integer.parseInt(request.getAttribute("estadoLogin").toString());
		if(filas==0) {
			mensaje= "Error al iniciar sesión, datos incorrectos. Intente nuevamente.";
		}

	} 
	
	
%>
<!-- <div style="text-align: center;"> -->
<%-- 		<%=mensaje %> --%>
<div class="content" style="text-align: center; font-weight: bold;"><%=mensaje %></div>		<!-- Lo que mostrará el timer -->

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>