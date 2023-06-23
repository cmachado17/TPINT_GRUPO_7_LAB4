package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EspecialidadNegocio;
import negocioImpl.EspecialidadNegocioImpl;

@WebServlet("/servletTurnos")
public class servletTurnos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	EspecialidadNegocio negEsp = new EspecialidadNegocioImpl();
	
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
		doGet(request, response);
	}

}
