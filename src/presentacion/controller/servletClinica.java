package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.EstadoTurno;
import entidad.Turno;
import negocio.PacienteNegocio;
import negocio.TurnoNegocio;
import negocioImpl.PacienteNegocioImpl;
import negocioImpl.TurnoNegocioImpl;

@WebServlet("/servletClinica")
public class servletClinica extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	TurnoNegocio negTurn = new TurnoNegocioImpl();
	PacienteNegocio negPac = new PacienteNegocioImpl();
       
    public servletClinica() {
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
				String dniMedico = String.valueOf(request.getSession().getAttribute("Sesion"));
				ArrayList<Turno> listaTurnos = negTurn.turnosAsignadosPorMedico(dniMedico);
				request.setAttribute("listaTurnos", listaTurnos);	
				dispatcher = "/TurnosAsignados.jsp";
				break;
			
			default:
				dispatcher = "/Principal.jsp";
				break;
			}
				
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
			if(request.getParameter("btnVer")!=null) {
				String dispatcher="/VerPaciente.jsp";
			
				RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
			    rd.forward(request, response);  
				}
			
		
			if(request.getParameter("btnEditarEstado")!=null) {
				String dispatcher="/ModificarEstado.jsp";
				
				//Busco el turno con los parametros y lo guardo en la session
				String paciente= request.getParameter("paciente");
				String medico = String.valueOf(request.getSession().getAttribute("Sesion"));
				String dia = request.getParameter("dia");
				String hora =request.getParameter("hora");
				Turno turno = negTurn.buscarTurno(paciente, medico, hora, dia);
				
				request.getSession().setAttribute("turno", turno);
				
				RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
			    rd.forward(request, response);  
				}
			
			// VER PACIENTE
			if(request.getParameter("btnVerPaciente")!=null) {
				String dispatcher="/VerPaciente.jsp";
				
				request.setAttribute("VerPaciente", negPac.buscarPaciente(request.getParameter("txtDni")));
			
				RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
			    rd.forward(request, response);  
				}	
		

		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		if(request.getParameter("btnVolver")!=null) {
			String dispatcher="/TurnosAsignados.jsp";
		
			String dniMedico = String.valueOf(request.getSession().getAttribute("Sesion"));
			ArrayList<Turno> listaTurnos = negTurn.turnosAsignadosPorMedico(dniMedico);
			request.setAttribute("listaTurnos", listaTurnos);	
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		if(request.getParameter("btnActualizar")!=null) {
			String dispatcher="/TurnosAsignados.jsp";
			//Obtengo el medico de la sesion para el listado
			String dniMedico = String.valueOf(request.getSession().getAttribute("Sesion"));
			
			//armo el turno
			Turno turno = (Turno) request.getSession().getAttribute("turno");
			
			//Le agrego lo enviando en el front
			turno.setComentario(request.getParameter("comentario").toString());
			turno.setEstadoTurno(new EstadoTurno(Integer.parseInt(request.getParameter("estado").toString())));
			//Actualizo
			negTurn.updatePorMedico(turno);
			
			//recargo el listado de los turnos del medico
			ArrayList<Turno> listaTurnos = negTurn.turnosAsignadosPorMedico(dniMedico);
			request.setAttribute("listaTurnos", listaTurnos);	
			//Redirijo a listado de turnos asignados del medico
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
	}

}
