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
import entidad.Paciente;
import negocio.PacienteNegocio;
import negocioImpl.PacienteNegocioImpl;

@WebServlet("/servletPacientes")
public class servletPacientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
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
			int provincia = Integer.parseInt(request.getParameter("provincia"));
			String email = request.getParameter("Email");
			String telefono = request.getParameter("Telefono");
			
			Paciente paciente = new Paciente();
			paciente.setDni(dni);
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setSexo(sexo);
			paciente.getCodNacionalidad().setCodigo(codNacionalidad);
			paciente.setFechaNacimiento(fecha);
			paciente.setDireccion(direccion);
			paciente.setLocalidad(localidad);
			paciente.getProvincia().setCodigo(provincia);
			paciente.setEmail(email);
			paciente.setTelefono(telefono);
			
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
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
