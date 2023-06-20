package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.MedicoDaoImpl;
import entidad.DiaSemana;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Nacionalidad;
import entidad.Provincia;
import negocio.DiaSemanaNegocio;
import negocio.EspecialidadNegocio;
import negocio.NacionalidadNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.DiaSemanaNegocioImpl;
import negocioImpl.EspecialidadNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;


@WebServlet("/servletEmpleados")
public class servletEmpleados extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	ProvinciaNegocio negProv = new ProvinciaNegocioImpl();
	NacionalidadNegocio negNac = new NacionalidadNegocioImpl();
	EspecialidadNegocio negEsp = new EspecialidadNegocioImpl();
	DiaSemanaNegocio negDia = new DiaSemanaNegocioImpl();
   
    public servletEmpleados() {
        super();
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("Sesion") == null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Principal.jsp");  
		    rd.forward(request, response); 
		}
		
		
		if(request.getParameter("Param")!=null) {
			String dispatcher="";
			
			switch(request.getParameter("Param")) {
			case "0":
				//Se carga la lista de provincias y nacionalidades
				request.setAttribute("listaProv", negProv.obtenerProvincias());
				request.setAttribute("listaNac", negNac.obtenerNacionalidades());
				request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
				request.setAttribute("listaDias", negDia.obtenerDiaSemana());
				dispatcher = "/AltaEmpleados.jsp";
				break;
			case "1":
				dispatcher = "/BajaEmpleados.jsp";
				break;
			case "2":
				dispatcher = "/ModificacionEmpleados.jsp";
				break;
			case "3":	
				dispatcher = "/ListadoEmpleados.jsp";
				break;
			default:
				dispatcher = "/Principal.jsp";
				break;
			}
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
		    }
				
		
		if(request.getParameter("btnEditar")!=null) {
			String dispatcher="/ModificacionEmpleados.jsp";
		
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filas = 0;
		
		if(request.getParameter("btnEnviar-empleados")!=null) {
			Medico medico = new Medico();
			
			medico.setDni(Integer.parseInt(request.getParameter("DNI")));
			medico.setNombre(request.getParameter("nombre"));
			medico.setApellido(request.getParameter("apellido"));
			medico.setSexo(request.getParameter("sexo"));
			medico.setCodNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad"))));
			medico.setFechaNacimiento(request.getParameter("fechaNacimiento"));
			medico.setDireccion(request.getParameter("direccion"));
			medico.setLocalidad(request.getParameter("localidad"));
			medico.setProvincia(new Provincia (Integer.parseInt(request.getParameter("provincia"))));
			medico.setEmail(request.getParameter("email"));
			medico.setTelefono(request.getParameter("telefono"));
			medico.setEstado(true);
			medico.setEspecialidad(new Especialidad(Integer.parseInt(request.getParameter("Especialidad"))));
			medico.setDiaAtencion(new DiaSemana(Integer.parseInt(request.getParameter("dia"))));
			medico.setHorarioInicioAtencion(request.getParameter("horaIncio"));
			medico.setHorarioFinAtencion(request.getParameter("horaFin"));
		
		MedicoDaoImpl medicoDao = new MedicoDaoImpl();
		
		if(!medicoDao.insert(medico)) {
			filas=0;			
		}
		else {
			filas=1;
		}

		//REQUEST DISPATCHER
		request.setAttribute("insercion", filas);
		RequestDispatcher rd = request.getRequestDispatcher("/AltaEmpleados.jsp");
		rd.forward(request, response);
		}
	}

}
