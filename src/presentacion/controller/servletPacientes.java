package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.PacienteDaoImpl;
import entidad.Nacionalidad;
import entidad.Paciente;
import entidad.Provincia;
import negocio.NacionalidadNegocio;
import negocio.PacienteNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.PacienteNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

@WebServlet("/servletPacientes")
public class servletPacientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ProvinciaNegocio negProv = new ProvinciaNegocioImpl();
	NacionalidadNegocio negNac = new NacionalidadNegocioImpl();
       
    public servletPacientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("Sesion") == null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Principal.jsp");  
		    rd.forward(request, response); 
		}
		
		if(request.getParameter("Param")!=null ) {
			String dispatcher="";
			
			switch(request.getParameter("Param")) {
			case "0":
				//Se carga la lista de provincias y nacionalidades
				request.setAttribute("listaProv", negProv.obtenerProvincias());
				request.setAttribute("listaNac", negNac.obtenerNacionalidades());
				dispatcher = "/AltaPacientes.jsp";
				break;
			case "1":
				dispatcher = "/BajaPacientes.jsp";
				break;
			case "2":
				dispatcher = "/ModificacionPacientes.jsp";
				break;
			case "3":				
				PacienteNegocio pacienteNegocio = new PacienteNegocioImpl();
				ArrayList<Paciente> listaPacientes = pacienteNegocio.readAll();
				request.setAttribute("listaPacientes", listaPacientes);	
				dispatcher = "/ListadoPacientes.jsp";
				break;
			default:
				dispatcher = "/Principal.jsp";
				break;
			}
				
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		if(request.getParameter("btnEditar")!=null) {
			String dispatcher="/ModificacionPacientes.jsp";
			
			PacienteNegocio pacienteNegocio = new PacienteNegocioImpl();
			//Paciente paciente = new Paciente();
			
			request.setAttribute("PacienteModificable", pacienteNegocio.buscarPaciente(request.getParameter("txtDni")));
			//Se carga la lista de provincias y nacionalidades
			request.setAttribute("listaProv", negProv.obtenerProvincias());
			request.setAttribute("listaNac", negNac.obtenerNacionalidades());
		
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		
		if(request.getParameter("btnModificar")!=null)
		{
			//boolean camposCompletos=true;
			
			int dni = Integer.parseInt(request.getParameter("DNI"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String sexo = request.getParameter("sexo");
			int codNacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
			String fecha = request.getParameter("fechaNacimiento");
			String direccion = request.getParameter("direccion");
			String localidad = request.getParameter("localidad");
			int provinciaForm = Integer.parseInt(request.getParameter("provincia"));
			String email = request.getParameter("Email");
			String telefono = request.getParameter("Telefono");
			
			Paciente paciente = new Paciente();
			Nacionalidad nacionalidad = new Nacionalidad();
			Provincia provincia = new Provincia();
			
			nacionalidad.setCodigo(codNacionalidad);
			provincia.setCodigo(provinciaForm);
			
			paciente.setDni(dni);
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setSexo(sexo);
			paciente.setFechaNacimiento(fecha);
			paciente.setDireccion(direccion);
			paciente.setLocalidad(localidad);
			paciente.setEmail(email);
			paciente.setTelefono(telefono);
			paciente.setCodNacionalidad(nacionalidad);
			paciente.setProvincia(provincia);
			
			
			PacienteDaoImpl pacienteDao = new PacienteDaoImpl();
			
			if(pacienteDao.update(paciente)) {
				//REQUEST DISPATCHER
				request.setAttribute("modificacion", 1);
				PacienteNegocio pacienteNegocio = new PacienteNegocioImpl();
				ArrayList<Paciente> listaPacientes = pacienteNegocio.readAll();
				request.setAttribute("listaPacientes", listaPacientes);	
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
				rd.forward(request, response);
			}

			
		}
		
		if(request.getParameter("btnEliminar")!=null) {			
            PacienteDaoImpl pacienteDao = new PacienteDaoImpl();			
			int dni = Integer.parseInt(request.getParameter("txtDni"));			
			pacienteDao.delete(dni);	
			RequestDispatcher rd = request.getRequestDispatcher("/servletPacientes?Param=3");
			rd.forward(request, response);
		}
		
		int filas=0;
		if(request.getParameter("btnEnviar-pacientes")!=null)
		{			
			int dni = Integer.parseInt(request.getParameter("DNI"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String sexo = request.getParameter("sexo");
			Nacionalidad codNacionalidad = new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad")));
			String fecha = request.getParameter("fechaNacimiento").toString();
			String direccion = request.getParameter("direccion");
			String localidad = request.getParameter("localidad");
			Provincia provincia = new Provincia (Integer.parseInt(request.getParameter("provincia")));
			String email = request.getParameter("email");
			String telefono = request.getParameter("telefono");
			
			Paciente paciente = new Paciente();
			paciente.setDni(dni);
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setSexo(sexo);
			paciente.setCodNacionalidad(codNacionalidad);
			paciente.setFechaNacimiento(fecha);
			paciente.setDireccion(direccion);
			paciente.setLocalidad(localidad);
			paciente.setProvincia(provincia);
			paciente.setEmail(email);
			paciente.setTelefono(telefono);
			paciente.setEstado(true);
			
			PacienteDaoImpl pacienteDao = new PacienteDaoImpl();
			
			if(!pacienteDao.insert(paciente)) {
				filas=0;			
			}
			else {
				filas=1;
			}

			//REQUEST DISPATCHER
			request.setAttribute("insercion", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaPacientes.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
