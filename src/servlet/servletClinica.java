package servlet;

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
				dispatcher = "/AltaPacientes.jsp";
				break;
			case "1":
				dispatcher = "/BajaPacientes.jsp";
				break;
			case "2":
				dispatcher = "/ModificacionPacientes.jsp";
				break;
			case "3":
				dispatcher = "/ListadoPacientes.jsp";
				break;
			default:
				dispatcher = "/Principal.jsp";
				break;
			}
				
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
		    rd.forward(request, response);  
			}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
