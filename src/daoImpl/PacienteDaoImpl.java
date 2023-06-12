package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.PacienteDao;
import entidad.Paciente;

public class PacienteDaoImpl implements PacienteDao{
	
	private static final String insert  = "INSERT INTO pacientes(Dni, Nombre, Apellido, Sexo, Cod_Nacionalidad,"
			+ "Fecha_Nac, Direccion, Localidad, Pronvincia, Email, Telefono, Estado) VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?)";
	private static final String delete  = "DELETE FROM pacientes WHERE Dni = ?";
	private static final String readall = "SELECT * FROM pacientes";
	private static final String update  = "UPDATE pacientes SET Nombre = ? , Apellido = ?, Sexo = ?, Cod_Nacionalidad = ?,"
		+	"Fecha_Nac = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, Telefoo = ?, Estado = ? WHERE Dni = ?";
	private static final String dniExiste= "SELECT * FROM pacientes WHERE Dni = ?";

	@Override
	public boolean insert(Paciente paciente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, paciente.getDni());
			statement.setString(2, paciente.getNombre());
			statement.setString(3, paciente.getApellido());
			statement.setString(4, paciente.getSexo());
			statement.setInt(5, paciente.getCodNacionalidad());
			//statement.setDate(3, paciente.getFechaNacimiento());
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
			//statement.setDate(3, paciente.getFechaNacimiento());
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
	public List<Paciente> readAll() {
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
				pacientes.add(getPacientes(resultSet));
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
	

}
