package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EspecialidadNegocio;
import negocio.MedicoNegocio;
import negocio.PacienteNegocio;
import negocio.TurnoNegocio;
import negocioImpl.EspecialidadNegocioImpl;
import negocioImpl.MedicoNegocioImpl;
import negocioImpl.PacienteNegocioImpl;
import negocioImpl.TurnoNegocioImpl;

@WebServlet("/servletTurnos")
public class servletTurnos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	EspecialidadNegocio negEsp = new EspecialidadNegocioImpl();
	PacienteNegocio negPac = new PacienteNegocioImpl();
	MedicoNegocio negMed = new MedicoNegocioImpl();
	TurnoNegocio negTurn = new TurnoNegocioImpl();
	
    public servletTurnos() {
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
				request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
				dispatcher = "/AsignarTurnos.jsp";
				break;
			case "1":
				dispatcher = "/ListadoTurnos.jsp";
				break;
			default:
				dispatcher = "/Principal.jsp";
				break;
			}
				
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		if(request.getParameter("btnEditar")!=null) {
			String dispatcher="/ModificacionTurnos.jsp";
		
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnEnviar")!=null) {
			String dispatcher="/AsignarTurnos1.jsp";
			
			//medicos filtrados
			request.setAttribute("listaMedicos",negMed.medicosPorEspecialidad(Integer.parseInt(request.getParameter("especialidad").toString())));
			//guardo la especialidad para usar despues
			request.getSession().setAttribute("EspecialidadTurno", Integer.parseInt(request.getParameter("especialidad").toString()));
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		if(request.getParameter("btnEnviar-1")!=null) {
			String dispatcher="/AsignarTurnos2.jsp";
			
			//turnos del medico elegido
			request.setAttribute("turnosMedico",negTurn.turnosMedico(request.getParameter("medico").toString()));
			//guardo el medico para usarlo despues
			request.getSession().setAttribute("MedicoTurno", request.getParameter("medico"));
		
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
	}

}
