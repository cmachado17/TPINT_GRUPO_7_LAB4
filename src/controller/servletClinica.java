package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletClinica")
public class servletClinica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletClinica() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			String dispatcher="";
			
			switch(request.getParameter("Param")) {
			case "0":
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
			
				RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
			    rd.forward(request, response);  
				}
		

		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		if(request.getParameter("btnVolver")!=null) {
			String dispatcher="/TurnosAsignados.jsp";
		
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
	}

}
