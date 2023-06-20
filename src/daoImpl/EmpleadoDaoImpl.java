package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EmpleadoDao;
import dao.PacienteDao;
import entidad.Medico;
import entidad.Nacionalidad;
import entidad.Paciente;
import entidad.Persona;
import entidad.Provincia;

public class EmpleadoDaoImpl implements EmpleadoDao{
	
	private static final String insert  = "INSERT INTO empleados (DNI, NOMBRE, APELLIDO, SEXO, COD_NACIONALIDAD, FECHA_NAC, DIRECCION, LOCALIDAD, PROVINCIA, EMAIL, TELEFONO, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String insertMedEspec  = "INSERT INTO medico_por_especialidad (DNIMEDICO, COD_ESPECIALIDAD, DIASEMANA, HORAINICIO, HORAFIN, ESTADO) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String delete  = "UPDATE empleados SET ESTADO=0 WHERE Dni = ?";
	private static final String readall = "SELECT * FROM empleados where estado = 1";
	private static final String update  = "UPDATE empleados SET Nombre = ? , Apellido = ?, Sexo = ?, Cod_Nacionalidad = ?,"
		+	"Fecha_Nac = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, Telefono = ? WHERE Dni = ?";
	private static final String dniExiste= "SELECT * FROM empleados WHERE Dni = ?";
	private static final String buscarPaciente= "SELECT empl.DNI, empl.Nombre, empl.Apellido, empl.Sexo"
			+ ", empl.FECHA_NAC, empl.DIRECCION, empl.LOCALIDAD, empl.EMAIL, empl.TELEFONO, PRO.CODIGO, PRO.DESCRIPCION,"
			+ "NAC.CODIGO, NAC.DESCRIPCION FROM empleados empl "
			+ "INNER JOIN PROVINCIAS PRO ON PRO.CODIGO = empl.PROVINCIA "
			+ "INNER JOIN NACIONALIDADES NAC ON NAC.CODIGO = empl.COD_NACIONALIDAD WHERE empl.Dni = ?";
	
	@Override
	public boolean insert(Persona empleado) {
		
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			PreparedStatement statement = conexion.prepareStatement(insert);
			statement.setInt(1, empleado.getDni());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setString(4, empleado.getSexo());
			statement.setInt(5, empleado.getCodNacionalidad().getCodigo());
			statement.setString(6, empleado.getFechaNacimiento());
			statement.setString(7, empleado.getDireccion());
			statement.setString(8, empleado.getLocalidad());
			statement.setInt(9, empleado.getProvincia().getCodigo());
			statement.setString(10, empleado.getEmail());
			statement.setString(11, empleado.getTelefono());
			statement.setBoolean(12, empleado.getEstado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isOk;
	}

	@Override
	public boolean insertMedicosPorEspecilidad(Medico medico) {
		
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			PreparedStatement statement = conexion.prepareStatement(insertMedEspec);
			statement.setInt(1, medico.getDni());
			statement.setInt(2, medico.getEspecialidad().getCodigo());
			statement.setInt(3, medico.getDiaAtencion().getCodigo());
			statement.setString(4, medico.getHorarioInicioAtencion());
			statement.setString(5, medico.getHorarioFinAtencion());
			statement.setBoolean(6, medico.getEstado());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isOk;
	}

	@Override
	public boolean delete(int dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, dni);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isOk;
	}

	@Override
	public boolean update(Persona empleado) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellido());
			statement.setString(3, empleado.getSexo());
			statement.setInt(4, empleado.getCodNacionalidad().getCodigo());
			statement.setString(5, empleado.getFechaNacimiento());
			statement.setString(6, empleado.getDireccion());
			statement.setString(7, empleado.getLocalidad());
			statement.setInt(8, empleado.getProvincia().getCodigo());
			statement.setString(9, empleado.getEmail());
			statement.setString(10, empleado.getTelefono());
			statement.setInt(11, empleado.getDni());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isOk;
	}

	@Override
	public ArrayList<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Persona> empleados = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Persona empleado = new Paciente();
				empleado.setDni(resultSet.getInt("DNI"));
				empleado.setNombre(resultSet.getString("NOMBRE"));
				empleado.setApellido(resultSet.getString("APELLIDO"));
				empleados.add(empleado);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public int dniNoExiste(Persona persona) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Paciente encontrado = new Paciente();
		int filas=0;
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(dniExiste);
			statement.setInt(1,persona.getDni());
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				encontrado.setDni(resultSet.getInt(1));
				filas=encontrado.getDni();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return filas;
	}
	

	@Override
	public Paciente BuscarEmpleado(String dni) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Paciente encontrado = new Paciente();
		Nacionalidad nacionalidad = new Nacionalidad();
		Provincia provincia = new Provincia();
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(buscarPaciente);
			statement.setInt(1,Integer.parseInt(dni));
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				encontrado.setDni(resultSet.getInt(1));
				encontrado.setNombre(resultSet.getString(2));
				encontrado.setApellido(resultSet.getString(3));
				encontrado.setSexo(resultSet.getString(4));
				encontrado.setFechaNacimiento(resultSet.getString(5));
				encontrado.setDireccion(resultSet.getString(6));
				encontrado.setLocalidad(resultSet.getString(7));
				encontrado.setEmail(resultSet.getString(8));
				encontrado.setTelefono(resultSet.getString(9));
				
				nacionalidad.setCodigo(resultSet.getInt("NAC.CODIGO"));
				nacionalidad.setDescripcion(resultSet.getString("NAC.DESCRIPCION"));
				
				provincia.setCodigo(resultSet.getInt("PRO.CODIGO"));
				provincia.setDescripcion(resultSet.getString("PRO.DESCRIPCION"));
				
				encontrado.setCodNacionalidad(nacionalidad);
				encontrado.setProvincia(provincia);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
		}

}
