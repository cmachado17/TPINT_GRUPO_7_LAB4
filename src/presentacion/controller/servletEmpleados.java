package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.TurnoDaoImpl;
import entidad.Administrador;
import entidad.DiaSemana;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Nacionalidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.TipoUsuario;
import entidad.Usuario;
import negocio.DiaSemanaNegocio;
import negocio.EmpleadoNegocio;
import negocio.EspecialidadNegocio;
import negocio.MedicoNegocio;
import negocio.NacionalidadNegocio;
import negocio.ProvinciaNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.DiaSemanaNegocioImpl;
import negocioImpl.EmpleadoNegocioImpl;
import negocioImpl.EspecialidadNegocioImpl;
import negocioImpl.MedicoNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;


@WebServlet("/servletEmpleados")
public class servletEmpleados extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	EmpleadoNegocio negEmp = new EmpleadoNegocioImpl();
	UsuarioNegocio negUser = new UsuarioNegocioImpl();
	ProvinciaNegocio negProv = new ProvinciaNegocioImpl();
	NacionalidadNegocio negNac = new NacionalidadNegocioImpl();
	EspecialidadNegocio negEsp = new EspecialidadNegocioImpl();
	DiaSemanaNegocio negDia = new DiaSemanaNegocioImpl();
	MedicoNegocio medicoNegocio = new MedicoNegocioImpl();
	TurnoDaoImpl turnoDao = new TurnoDaoImpl();
	
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
				//Se carga la lista de provincias y nacionalidades
				request.setAttribute("listaProv", negProv.obtenerProvincias());
				request.setAttribute("listaNac", negNac.obtenerNacionalidades());
				request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
				request.setAttribute("listaDias", negDia.obtenerDiaSemana());
				dispatcher = "/AltaEmpleados.jsp";
				break;
			case "1":
				dispatcher = "/BajaEmpleados.jsp";
				break;
			case "2":
				dispatcher = "/ModificacionEmpleados.jsp";
				break;
			case "3":
				ArrayList<Medico> listaEmpleados = medicoNegocio.readAll();
				request.setAttribute("listaEmpleados", listaEmpleados);	
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
				
				request.setAttribute("MedicoModificable", medicoNegocio.buscarMedico(request.getParameter("txtDni")));
				//Se carga la lista de provincias, nacionalidades, especialidades y horas
				request.setAttribute("listaProv", negProv.obtenerProvincias());
				request.setAttribute("listaNac", negNac.obtenerNacionalidades());
				request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
				request.setAttribute("listaDias", negDia.obtenerDiaSemana());
				
				RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
			    rd.forward(request, response);  
				}
			
			
			if(request.getParameter("btnEliminar")!=null) {						
				int dni = Integer.parseInt(request.getParameter("txtDni"));			
				negEmp.delete(dni);
				turnoDao.anularTurnos(dni, "","");	//ANULA los turnos del médico dado de baja (los pone en estado=0, y cod_estado_turno=ANULADO). Si pasamos fechas anula ese rango de fechas.
				RequestDispatcher rd = request.getRequestDispatcher("/servletEmpleados?Param=3");
				rd.forward(request, response);
			}
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//alta empleado
		int filas = 0;
		
		if(request.getParameter("btnEnviar-empleados")!=null) 
		{
			int tipoUsuario = Integer.parseInt(request.getParameter("tipousuario"));
			Usuario usuario = new Usuario();
			usuario.setDni(Integer.parseInt(request.getParameter("DNI")));
			usuario.setClave(String.valueOf(usuario.getDni()));
//			usuario.setClave("1234");
			TipoUsuario tu = new TipoUsuario();
			tu.setCodigoTipoUsuario(tipoUsuario);			
			usuario.setTipoUser(tu);
			usuario.setEstado(true);
			
			Persona empleado = new Persona();
			empleado.setDni(Integer.parseInt(request.getParameter("DNI")));
			empleado.setNombre(request.getParameter("nombre"));
			empleado.setApellido(request.getParameter("apellido"));
			empleado.setSexo(request.getParameter("sexo"));
			empleado.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad"))));
			empleado.setFechaNacimiento(request.getParameter("fechaNacimiento"));
			empleado.setDireccion(request.getParameter("direccion"));
			empleado.setLocalidad(request.getParameter("localidad"));
			empleado.setProvincia(new Provincia (Integer.parseInt(request.getParameter("provincia"))));
			empleado.setEmail(request.getParameter("email"));
			empleado.setTelefono(request.getParameter("telefono"));
			empleado.setEstado(true);
			
			if(tipoUsuario==1) {			
				if(negEmp.insert(empleado)) {
					if(negUser.insert(usuario)) {
						filas=1;									
					}
				}
			}
			
			if(tipoUsuario==2) {
				Medico medico = new Medico();				
				
				//ESTA PARTE INSERTA UN NUEVO MEDICO POR ESPECIALIDAD
				medico.setDni(empleado.getDni());
				medico.setEspecialidad(new Especialidad (Integer.parseInt(request.getParameter("especialidad"))));
				medico.setDiaAtencion(new DiaSemana(Integer.parseInt(request.getParameter("dia"))));		
				medico.setHorarioInicioAtencion(request.getParameter("horaInicio"));
				medico.setHorarioFinAtencion(request.getParameter("horaFin"));
				medico.setEstado(empleado.getEstado());
				
				if(negEmp.insert(empleado)) {
					if(negEmp.insertMedicosPorEspecialidad(medico)) {
						if(negUser.insert(usuario)) {				//método para agregar un usuario al sistema al crear un médico o administrador			
							filas=1;		

							turnoDao.insert(medico);
						}
						
					}
					else {	//si puede insertar el medico pero no la especialidad por médico elimina al médico creado.
						negEmp.bajaFisica(empleado.getDni());	//creo el método bajaFisica hasta que veamos si hacemos trigger o no
						filas=0;
					}
				}
				
			}

			//REQUEST DISPATCHER
			request.setAttribute("insercion", filas);
			//Se carga la lista de provincias y nacionalidades
			request.setAttribute("listaProv", negProv.obtenerProvincias());
			request.setAttribute("listaNac", negNac.obtenerNacionalidades());
			request.setAttribute("listaEsp", negEsp.obtenerEspecialidades());
			request.setAttribute("listaDias", negDia.obtenerDiaSemana());
			RequestDispatcher rd = request.getRequestDispatcher("/AltaEmpleados.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			int tipoUsuario = Integer.parseInt(request.getParameter("tipousuario"));
			Usuario usuario = new Usuario();

			usuario.setDni(Integer.parseInt(request.getParameter("DNI")));
			usuario.setClave(String.valueOf(usuario.getDni()));
			TipoUsuario tu = new TipoUsuario();
			tu.setCodigoTipoUsuario(tipoUsuario);			
			usuario.setTipoUser(tu);
			usuario.setEstado(true);
			
			if(tipoUsuario==1) {
				
				Administrador administrador = new Administrador();
				administrador.setDni(Integer.parseInt(request.getParameter("DNI")));
				administrador.setNombre(request.getParameter("nombre"));
				administrador.setApellido(request.getParameter("apellido"));
				administrador.setSexo(request.getParameter("sexo"));
				administrador.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad"))));
				administrador.setFechaNacimiento(request.getParameter("fechaNacimiento"));
				administrador.setDireccion(request.getParameter("direccion"));
				administrador.setLocalidad(request.getParameter("localidad"));
				administrador.setProvincia(new Provincia (Integer.parseInt(request.getParameter("provincia"))));
				administrador.setEmail(request.getParameter("email"));
				administrador.setTelefono(request.getParameter("telefono"));
				administrador.setEstado(true);
				
				if(negEmp.update(administrador)) {
					if(negUser.update(usuario));
					filas=1;			
				}
			}
			
			if(tipoUsuario==2) {
			
			//SETEO EL MEDICO A ACTUALIZAR
			Medico medico = new Medico();
			medico.setDni(Integer.parseInt(request.getParameter("DNI")));
			medico.setNombre(request.getParameter("nombre"));
			medico.setApellido(request.getParameter("apellido"));
			medico.setSexo(request.getParameter("sexo"));
			medico.setNacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad"))));
			medico.setFechaNacimiento(request.getParameter("fechaNacimiento"));
			medico.setDireccion(request.getParameter("direccion"));
			medico.setLocalidad(request.getParameter("localidad"));
			medico.setProvincia(new Provincia (Integer.parseInt(request.getParameter("provincia"))));
			medico.setEmail(request.getParameter("email"));
			medico.setTelefono(request.getParameter("telefono"));
			medico.setEstado(true);
			
			//SETEO EL MEDICO POR ESPECIALIDAD A ACTUALIZAR
			medico.setEspecialidad(new Especialidad (Integer.parseInt(request.getParameter("especialidad"))));
			medico.setDiaAtencion(new DiaSemana(Integer.parseInt(request.getParameter("dia"))));		
			medico.setHorarioInicioAtencion(request.getParameter("horaInicio"));
			medico.setHorarioFinAtencion(request.getParameter("horaFin"));
			
			if(negEmp.update(medico)) {
				if(negEmp.updateMedicosEspecialidad(medico)) {			//si puede insertar el medico pero no la especialidad por médico elimina al médico creado.	
					if(negUser.update(usuario)) {			//método para modificar el usuario si cambia de médio a admin o viceversa
						filas=1;		
						//tendriamos que borrar todos los turnos?		
					}
				}
				else {
					//negEmp.bajaFisica(medico.getDni());	//creo el método bajaFisica hasta que veamos si hacemos trigger o no
					filas=0;
				}
			}
		}
			//Redirecciono al listado
			ArrayList<Medico> listaEmpleados = medicoNegocio.readAll();
			request.setAttribute("listaEmpleados", listaEmpleados);	
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoEmpleados.jsp");
			rd.forward(request, response);
		
		}
	}
}
