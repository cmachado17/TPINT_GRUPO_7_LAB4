package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PacienteDao;
import entidad.Paciente;

public class PacienteDaoImpl implements PacienteDao{
	
	private static final String insert  = "INSERT INTO pacientes (DNI, NOMBRE, APELLIDO, SEXO, COD_NACIONALIDAD, FECHA_NAC, DIRECCION, LOCALIDAD, PROVINCIA, EMAIL, TELEFONO, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete  = "DELETE FROM pacientes WHERE Dni = ?";
	private static final String readall = "SELECT * FROM pacientes";
	private static final String update  = "UPDATE pacientes SET Nombre = ? , Apellido = ?, Sexo = ?, Cod_Nacionalidad = ?,"
		+	"Fecha_Nac = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, Telefoo = ?, Estado = ? WHERE Dni = ?";
	private static final String dniExiste= "SELECT * FROM pacientes WHERE Dni = ?";

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
			statement.setInt(5, paciente.getCodNacionalidad());
			statement.setString(6, paciente.getFechaNacimiento());
			statement.setString(7, paciente.getDireccion());
			statement.setString(8, paciente.getLocalidad());
			statement.setInt(9, paciente.getProvincia());
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
	public boolean delete(Paciente paciente_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, paciente_a_eliminar.getDni());
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
			statement.setInt(1, paciente.getDni());
			statement.setString(2, paciente.getNombre());
			statement.setString(3, paciente.getApellido());
			statement.setString(4, paciente.getSexo());
			statement.setInt(5, paciente.getCodNacionalidad());
			statement.setString(3, paciente.getFechaNacimiento());
			statement.setString(3, paciente.getDireccion());
			statement.setString(3, paciente.getLocalidad());
			statement.setInt(3, paciente.getProvincia());
			statement.setString(3, paciente.getEmail());
			statement.setString(3, paciente.getTelefono());
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
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(dniExiste);
			statement.setInt(1,Integer.parseInt(dni));
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				encontrado.setDni(resultSet.getInt(2));
				encontrado.setNombre(resultSet.getString(3));
				encontrado.setApellido(resultSet.getString(4));
				encontrado.setSexo(resultSet.getString(5));
				encontrado.setCodNacionalidad(resultSet.getInt(6));
				encontrado.setFechaNacimiento(resultSet.getString(7));
				encontrado.setDireccion(resultSet.getString(8));
				encontrado.setLocalidad(resultSet.getString(9));
				encontrado.setProvincia(resultSet.getInt(10));
				encontrado.setEmail(resultSet.getString(11));
				encontrado.setTelefono(resultSet.getString(12));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
		}

}
