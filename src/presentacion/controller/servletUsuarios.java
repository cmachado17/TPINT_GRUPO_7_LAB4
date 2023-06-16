package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;


@WebServlet("/servletUsuarios")
public class servletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("Sesion") == null) {
			RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");  
		    rd.forward(request, response); 
		}
		
		if(request.getParameter("logout")!= null) {
			
			request.getSession().invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("btnIngresar-login") != null) {
			UsuarioDaoImpl uDao = new UsuarioDaoImpl();
			
			Usuario u = new Usuario();
			
			u.setDni(Integer.parseInt(request.getParameter("txtUsuario")));
			u.setClave(request.getParameter("txtClave"));
			
			u = uDao.Login(u);
			
			if(u != null) {		
				request.getSession().setAttribute("Sesion", u.getDni());
				request.getSession().setAttribute("tipoUsuario", u.getTipoUser().getCodigoTipoUsuario());
				request.getSession().setAttribute("DescripcionTipoUsuario", u.getTipoUser().getDescripcion());
				//REQUEST DISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("/Principal.jsp");
				rd.forward(request, response);
			}else {
				request.getSession().invalidate();
				request.setAttribute("estadoLogin", 0);
				//REQUEST DISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
			}

		}
	}

}
