package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PacienteDao;
import entidad.Nacionalidad;
import entidad.Paciente;
import entidad.Provincia;

public class PacienteDaoImpl implements PacienteDao{
	
	private static final String insert  = "INSERT INTO pacientes (DNI, NOMBRE, APELLIDO, SEXO, COD_NACIONALIDAD, FECHA_NAC, DIRECCION, LOCALIDAD, PROVINCIA, EMAIL, TELEFONO, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete  = "UPDATE pacientes SET ESTADO=0 WHERE Dni = ?";
	private static final String readall = "SELECT * FROM pacientes where estado = 1";
	private static final String update  = "UPDATE pacientes SET Nombre = ? , Apellido = ?, Sexo = ?, Cod_Nacionalidad = ?,"
		+	"Fecha_Nac = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, Telefono = ? WHERE Dni = ?";
	private static final String dniExiste= "SELECT * FROM pacientes WHERE Dni = ?";
	private static final String buscarPaciente= "SELECT pa.DNI, PA.Nombre, PA.Apellido, PA.Sexo"
			+ ", PA.FECHA_NAC, PA.DIRECCION, PA.LOCALIDAD, PA.EMAIL, PA.TELEFONO, PRO.CODIGO, PRO.DESCRIPCION,"
			+ "NAC.CODIGO, NAC.DESCRIPCION FROM pacientes pa "
			+ "INNER JOIN PROVINCIAS PRO ON PRO.CODIGO = PA.PROVINCIA "
			+ "INNER JOIN NACIONALIDADES NAC ON NAC.CODIGO = PA.COD_NACIONALIDAD WHERE pa.Dni = ?";
	
	@Override
	public boolean insert(Paciente paciente) {
		
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			PreparedStatement statement = conexion.prepareStatement(insert);
			statement.setInt(1, paciente.getDni());
			statement.setString(2, paciente.getNombre());
			statement.setString(3, paciente.getApellido());
			statement.setString(4, paciente.getSexo());
			statement.setInt(5, paciente.getNacionalidad().getCodigo());
			statement.setString(6, paciente.getFechaNacimiento());
			statement.setString(7, paciente.getDireccion());
			statement.setString(8, paciente.getLocalidad());
			statement.setInt(9, paciente.getProvincia().getCodigo());
			statement.setString(10, paciente.getEmail());
			statement.setString(11, paciente.getTelefono());
			statement.setBoolean(12, paciente.getEstado());
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
	public boolean update(Paciente paciente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, paciente.getNombre());
			statement.setString(2, paciente.getApellido());
			statement.setString(3, paciente.getSexo());
			statement.setInt(4, paciente.getNacionalidad().getCodigo());
			statement.setString(5, paciente.getFechaNacimiento());
			statement.setString(6, paciente.getDireccion());
			statement.setString(7, paciente.getLocalidad());
			statement.setInt(8, paciente.getProvincia().getCodigo());
			statement.setString(9, paciente.getEmail());
			statement.setString(10, paciente.getTelefono());
			statement.setInt(11, paciente.getDni());
			
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
	public ArrayList<Paciente> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Paciente paciente = new Paciente();
				paciente.setDni(resultSet.getInt("DNI"));
				paciente.setNombre(resultSet.getString("NOMBRE"));
				paciente.setApellido(resultSet.getString("APELLIDO"));
				pacientes.add(paciente);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pacientes;
	}

	@Override
	public int dniNoExiste(Paciente paciente) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Paciente encontrado = new Paciente();
		int filas=0;
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(dniExiste);
			statement.setInt(1,paciente.getDni());
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
	public Paciente BuscarPaciente(String dni) {
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
				
				encontrado.setNacionalidad(nacionalidad);
				encontrado.setProvincia(provincia);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
		}

}
