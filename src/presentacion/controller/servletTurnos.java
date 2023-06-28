package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.EstadoTurno;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
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
				ArrayList<Turno> listaTurnos = negTurn.readAll();
				request.setAttribute("listaTurnos", listaTurnos);	
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
		if(request.getParameter("btnBuscar")!=null) {
			String dispatcher="/AsignarTurnos.jsp";
			
			List<Medico> listaMedicos = new ArrayList<Medico>();
			listaMedicos = negMed.medicosPorEspecialidad(Integer.parseInt(request.getParameter("especialidad").toString()));
			
			if(listaMedicos.isEmpty()) {
				//medicos filtrados
				request.setAttribute("listaMedicos", null);
			}else {
				//medicos filtrados
				request.setAttribute("listaMedicos", listaMedicos);
			}
			
			//guardo la especialidad para usar despues
			request.getSession().setAttribute("EspecialidadTurno", Integer.parseInt(request.getParameter("especialidad").toString()));
			//volver a cargar las especialidades
			request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
		   
			}
		
		if(request.getParameter("btnBuscar2")!=null) {
			String dispatcher="/AsignarTurnos.jsp";
			
			List<Turno> listaTurnos = new ArrayList<Turno>();
			listaTurnos = negTurn.turnosMedico(request.getParameter("medico").toString());
			
			if(listaTurnos.isEmpty()) {
				//turnos del medico elegido
				request.setAttribute("turnosMedico", null);
				System.out.println("entro aca");
			}else {
				//turnos del medico elegido
				request.setAttribute("turnosMedico", listaTurnos);
			}
			
			//guardo el medico para usarlo despues
			request.getSession().setAttribute("MedicoTurno", request.getParameter("medico"));
			
			//cargar pacientes
			request.setAttribute("listaPac", negPac.readAll());
		
			//volver a cargar las especialidades
			request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
			//vuelvo a cargar los medicos de esa especialidad 
			request.setAttribute("listaMedicos",negMed.medicosPorEspecialidad(Integer.parseInt(request.getSession().getAttribute("EspecialidadTurno").toString())));
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		
		if(request.getParameter("btnEnviar")!=null) {
			
			Turno turno = new Turno();
			Medico medico = new Medico();
			Paciente paciente = new Paciente();
			medico.setDni(Integer.parseInt(request.getSession().getAttribute("MedicoTurno").toString()));
			paciente.setCodPaciente(Integer.parseInt(request.getParameter("paciente").toString()));
			turno.setMedico(medico);
			turno.setPaciente(paciente);
			
			//Parseo el dia y hora
			String[] diayhora = request.getParameter("turno").toString().split(" ");
			
			turno.setDia(diayhora[0]);
			turno.setHorario(diayhora[2]);
			
			//Le paso el estado destino, "ocupado"
			turno.setEstadoTurno(new EstadoTurno(2));
			
			int filas = 0;
			
			if(!negTurn.update(turno)) {
				filas=1;			
			}
			else {
				filas=2;
			}
			
			request.setAttribute("insercion", filas);
			request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
			RequestDispatcher rd = request.getRequestDispatcher("/AsignarTurnos.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
