package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletEmpleados")
public class servletEmpleados extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
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
	
	}

}
