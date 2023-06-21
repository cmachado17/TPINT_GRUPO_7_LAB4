package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.EmpleadoDaoImpl;
import daoImpl.MedicoDaoImpl;
import daoImpl.TurnoDaoImpl;
import entidad.Administrador;
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
		
		if(request.getParameter("btnEnviar-empleados")!=null) 
		{
			int tipoUsuario = Integer.parseInt(request.getParameter("tipousuario"));
			
			if(tipoUsuario==1) {
				
				Administrador administrador = new Administrador();
				administrador.setDni(Integer.parseInt(request.getParameter("DNI")));
				administrador.setNombre(request.getParameter("nombre"));
				administrador.setApellido(request.getParameter("apellido"));
				administrador.setSexo(request.getParameter("sexo"));
				administrador.setCodNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad"))));
				administrador.setFechaNacimiento(request.getParameter("fechaNacimiento"));
				administrador.setDireccion(request.getParameter("direccion"));
				administrador.setLocalidad(request.getParameter("localidad"));
				administrador.setProvincia(new Provincia (Integer.parseInt(request.getParameter("provincia"))));
				administrador.setEmail(request.getParameter("email"));
				administrador.setTelefono(request.getParameter("telefono"));
				administrador.setEstado(true);
				
				EmpleadoDaoImpl empleadoDao = new EmpleadoDaoImpl();
				
				if(empleadoDao.insert(administrador)) {
					filas=1;			
				}
			}
			
			if(tipoUsuario==2) {
				
				//ESTA PARTE INSERTA UN NUEVO MÉDICO EN LA TABLA MÉDICOS
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
				
				
				//ESTA PARTE INSERTA UN NUEVO MEDICO POR ESPECIALIDAD
				medico.setEspecialidad(new Especialidad (Integer.parseInt(request.getParameter("especialidad"))));
				medico.setDiaAtencion(new DiaSemana(Integer.parseInt(request.getParameter("dia"))));		
				medico.setHorarioInicioAtencion(request.getParameter("horaInicio"));
				medico.setHorarioFinAtencion(request.getParameter("horaInicio"));
				
				EmpleadoDaoImpl empleadoDao = new EmpleadoDaoImpl();
				
				if(empleadoDao.insert(medico)) {
					if(empleadoDao.insertMedicosPorEspecilidad(medico)) {				
						filas=1;		
						TurnoDaoImpl turnoDao = new TurnoDaoImpl();
						turnoDao.insert(medico);
						
					}
					else {
						empleadoDao.delete(medico.getDni());
						filas=0;
					}
				}
				
			}

			//REQUEST DISPATCHER
			request.setAttribute("insercion", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaEmpleados.jsp");
			rd.forward(request, response);
		}
	}
}
