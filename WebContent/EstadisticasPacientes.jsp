<%@page import="entidad.EstadisticasPacientes"%>
<%@page import="entidad.Paciente"%>
<%@page import="java.util.ArrayList"%>
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
<title>Estadísticas de Pacientes</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="Principal.jsp"><i class="far fa-hospital px-2"></i>Sistema Clinica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <%
       if(session.getAttribute("Sesion") == null){ 
    	   response.sendRedirect("Home.jsp"); 
       }
       else{
      %>
      
     <% if(Integer.parseInt(session.getAttribute("tipoUsuario").toString()) == 1){ %>
     	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="fa fa-home"></span>Pacientes
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletPacientes?Param=0" class="dropdown-item">Alta Pacientes</a></li>
            <li><a href="servletPacientes?Param=3" class="dropdown-item">Listado Pacientes</a></li>            
            <li><a href="servletPacientes?Param=1" class="dropdown-item">Estadísticas Pacientes</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             <span class="fa fa-home"></span>Empleados
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletEmpleados?Param=0" class="dropdown-item">Alta Empleados</a></li>
            <li><a href="servletEmpleados?Param=3" class="dropdown-item">Listado Medicos</a></li>
             <li><a href="servletEmpleados?Param=4" class="dropdown-item">Listado Empleados</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <span class="fa fa-home"></span>Turnos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="servletTurnos?Param=0" class="dropdown-item">Alta Turno</a></li>
            <li><a href="servletTurnos?Param=1" class="dropdown-item">Listado Turnos</a></li>
          </ul>
        </li>
      </ul>
     <%}else if(Integer.parseInt(session.getAttribute("tipoUsuario").toString()) == 2){ %>
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
      <%}%>
      <div class="text-light pt-2">
      <% if(session.getAttribute("Sesion") != null){ %>
      	<p class="user"><%= session.getAttribute("Sesion") %> - <%= session.getAttribute("DescripcionTipoUsuario") %></p>
      	
      	<a class="user2" href="servletUsuarios?logout=1">Logout</a>
      <%}else{ %>
      	<p class="user">No logueado</p>
      	<%} %>
      </div>
    </div>
  </div>
</nav>

<div class="container"> 
	<div class="text-bg-light p-3 contenedor-principal">
		<h2 class="tituloForm">Estadísticas de Pacientes</h2>
		<div class="chart-container">
  			<div class="chart">
    			<h3>Por rango etareo</h3>
    			<canvas id="grafCantidadPacientesXEdad"></canvas>
  			</div>
  			<div class="chart">
    			<h3>Por especialidades (Turnos)</h3>
    			<label for="mes">Mes:</label>
				  <select id="mes" onchange="actualizarGraficoDeTorta()">
				    <option value="0">Todos</option>
				    <option value="1">Enero</option>
				    <option value="2">Febrero</option>
				    <option value="3">Marzo</option>
				    <option value="4">Abril</option>
				    <option value="5">Mayo</option>
				    <option value="6">Junio</option>
				    <option value="7">Julio</option>
				    <option value="8">Agosto</option>
				    <option value="9">Septiembre</option>
				    <option value="10">Octubre</option>
				    <option value="11">Noviembre</option>
				    <option value="12">Diciembre</option>
				  </select>
				
				  <label for="anio">Año:</label>
				  <select id="anio" onchange="actualizarGraficoDeTorta()">
				    <option value="0">Todos</option>
				    <option value="2021">2021</option>
				    <option value="2022">2022</option>
				    <option value="2023">2023</option>
				  </select>
    			<canvas id="grafCantidadTurnosXEspecialidad"></canvas>
  			</div>
		</div>
  <%
    // Obtener los datos
  ArrayList <EstadisticasPacientes> estadisticasRangoEdades = null;
  if(request.getAttribute("estadisticasRangoEdades") != null){
	  estadisticasRangoEdades = (ArrayList <EstadisticasPacientes>) request.getAttribute("estadisticasRangoEdades");
  }
  
  ArrayList <EstadisticasPacientes> estadisticasTurnosXEsp = null;
  if(request.getAttribute("estadisticasTurnosXEsp") != null){
	  estadisticasTurnosXEsp = (ArrayList <EstadisticasPacientes>) request.getAttribute("estadisticasTurnosXEsp");
  }
  %>
  <script>
    // Convierte los datos de Java a un formato adecuado para Chart.js
    var labels = [];
    var valores = [];
    <% if(estadisticasRangoEdades != null)
		for(EstadisticasPacientes paciente : estadisticasRangoEdades){%>
      	labels.push("<%= paciente.getRangoEdad() %>");
      	valores.push(<%= paciente.getCantidadRangoEdad() %>);
    <% } %>
    
    // Configura y crea el gráfico de barras utilizando Chart.js
    var ctx = document.getElementById('grafCantidadPacientesXEdad').getContext('2d');
    var chart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: labels,
        datasets: [{
          label: 'Cantidad',
          data: valores,
          backgroundColor: "white",
          borderColor: "rgba(54, 162, 235, 1)", // Color del borde de las barras
          borderWidth: 1
        }]
      },
      options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
              color: "white",
              ticks: {
                color: "black",
                stepSize: 1
              }
            },
            x: {
              grid: {
                color: "rgba(255, 255, 255, 0.2)"
              },
              ticks: {
                color: "black",
              }
            }
          },
          plugins: {
            legend: {
              labels: {
                color: "black" // Cambia el color de las etiquetas de la leyenda a negro
              }
            }
          }
        }
    });
    
   
 	// Datos para el gráfico de torta
 	var graficoTorta;
	function obtenerColoresDinamicos(cantidad) {
      var colores = [];
      // Asignar colores de forma dinámica
      for (var i = 0; i < cantidad; i++) {
        colores.push(generarColorAleatorio());
      }
      return colores;
    }

    function generarColorAleatorio() {
      // Generar un color aleatorio en formato hexadecimal
      var letrasHexadecimales = '0123456789ABCDEF';
      var color = '#';
      for (var i = 0; i < 6; i++) {
        color += letrasHexadecimales.charAt(Math.floor(Math.random() * 16));
      }
      return color;
    }
	    
    var labelsTorta = [];
    var valoresTorta = [];
    var datosTorta;
    var mesSeleccionado;
    var mesSelectElement;
    var anioSeleccionado;        
    var colores;

    function actualizarGraficoDeTorta() { 

        if (graficoTorta) {
          // Si el gráfico ya existe, destruirlo antes de crear uno nuevo
          graficoTorta.destroy();
        }
        
        mesSelectElement = document.getElementById("mes");
        mesSeleccionado = mesSelectElement.value;
        anioSeleccionado = document.getElementById('anio').value;           
        
        labelsTorta = [];
	    valoresTorta = [];
	    
	 
        <% if(estadisticasTurnosXEsp != null)
    		for(EstadisticasPacientes paciente : estadisticasTurnosXEsp){%>    		
    			var mesTurno = "<%= paciente.getMesTurno()%>"
    			var mesTurnoText = mesSelectElement.options[<%= paciente.getMesTurno()%>].text
    			var anioTurno = "<%= paciente.getAnioTurno()%>"
    			var especialidad = "<%= paciente.getEspecialidadTurno()%>"
    			var cantidad = <%= paciente.getCantidadTurno() %>
    				
	    		if(mesTurno === mesSeleccionado && anioTurno === anioSeleccionado){
	    			labelsTorta.push(especialidad + " ( " + mesTurnoText + "/" + anioTurno + " )");
	    			valoresTorta.push(cantidad);
	    		} else if ( mesSeleccionado === "0" && anioSeleccionado === anioTurno ) {
	    			labelsTorta.push(especialidad + " ( " + mesTurnoText + "/" + anioTurno + " )");
	    			valoresTorta.push(cantidad);
	    		} else if ( anioSeleccionado === "0" && mesSeleccionado === mesTurno ) {
	    			labelsTorta.push(especialidad + " ( " + mesTurnoText + "/" + anioTurno + " )");
	    			valoresTorta.push(cantidad);
	    		} else if ( anioSeleccionado === "0" && mesSeleccionado === "0" ) {
	    			labelsTorta.push(especialidad + " ( " + mesTurnoText + "/" + anioTurno + " )");
	    			valoresTorta.push(cantidad);
	    		}  
        <% } %>   
        
        datosTorta = {
	    	      labels: labelsTorta,
	    	      datasets: [
	    	        {
	    	          data: valoresTorta,
	    	          backgroundColor: obtenerColoresDinamicos(labelsTorta.length),
	    	        },
	    	      ],
	    	    };

        var contextoTorta = document.getElementById('grafCantidadTurnosXEspecialidad').getContext('2d');
		graficoTorta = new Chart(contextoTorta, {
   	 	type: 'pie',
        	data: datosTorta,
        	options: {
	       	    responsive: true,
	       	    title: {
	       	      display: true,
	       	      text: 'Gráfico de Torta',
	       	      fontColor: 'black' // Cambia el color de la fuente del título
	       	    },
	       	    plugins: {
	       	      legend: {
	       	        labels: {
	       	          color: 'white' // Cambia el color de la fuente de las leyendas a blanco
	       	        }
	     	      }
	       	    }
      	  	}
   		});
    }
   
	 // Inicializar el gráfico de torta al cargar la página
    actualizarGraficoDeTorta();
  </script>
		<br>
	</div>
</div>
<% } %>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>