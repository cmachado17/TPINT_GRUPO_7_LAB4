package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.PacienteDaoImpl;
import entidad.Paciente;

/**
 * Servlet implementation class ServletHTML
 */
@WebServlet("/ServletHTML")
public class ServletHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHTML() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas=0;

		if(request.getParameter("btnEnviar")!=null)
		{
			boolean camposCompletos=true;
			
			int dni = Integer.parseInt(request.getParameter("DNI"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String sexo = request.getParameter("sexo");
			int codNacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
			String fecha = request.getParameter("fechaNacimiento");
			String direccion = request.getParameter("direccion");
			String localidad = request.getParameter("localidad");
			int provincia = Integer.parseInt(request.getParameter("provincia"));
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
				filas=Integer.parseInt(null);			
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
}
