package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MedicoDao;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Nacionalidad;

public class MedicoDaoImpl implements MedicoDao{

	private static final String insert  = "CALL INSERTMEDICO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String delete  = "UPDATE Empleados SET ESTADO=0 WHERE Dni = ?";
	private static final String readall = "SELECT E.DNI, E.NOMBRE, E.APELLIDO, E.SEXO, E.COD_NACIONALIDAD, N.DESCRIPCION AS DESC_NACIONALIDAD, "
			+ "E.FECHA_NAC, E.EMAIL, M.COD_ESPECIALIDAD, Esp.DESCRIPCION as DESC_ESPECIALIDAD "
			+ "FROM empleados AS E inner join medico_por_especialidad as M ON M.DNIMEDICO= E.DNI inner join nacionalidades as N ON E.COD_NACIONALIDAD = N.CODIGO "
			+ "inner join especialidades as Esp ON M.COD_ESPECIALIDAD = Esp.CODIGO where E.ESTADO= 1;";
	private static final String update  = "CALL EDITMEDICO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
;
	
	@Override
	public boolean insert(Medico medico) {
		
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			CallableStatement statement = conexion.prepareCall(insert);
			statement.setInt(1, medico.getDni());
			statement.setString(2, medico.getNombre());
			statement.setString(3, medico.getApellido());
			statement.setString(4, medico.getSexo());
			statement.setInt(5, medico.getNacionalidad().getCodigo());
			statement.setString(6, medico.getFechaNacimiento());
			statement.setString(7, medico.getDireccion());
			statement.setString(8, medico.getLocalidad());
			statement.setInt(9, medico.getProvincia().getCodigo());
			statement.setString(10, medico.getEmail());
			statement.setString(11, medico.getTelefono());
			statement.setBoolean(12, medico.getEstado());
			statement.setInt(13, medico.getEspecialidad().getCodigo());
			statement.setInt(14, medico.getDiaAtencion().getCodigo());
			statement.setString(15, medico.getHorarioInicioAtencion());
			statement.setString(16, medico.getHorarioFinAtencion());
		
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
	public boolean update(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	
	public ArrayList<Medico> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{							
				Medico medico = new Medico();
				medico.setDni(resultSet.getInt("DNI"));
				medico.setNombre(resultSet.getString("NOMBRE"));
				medico.setApellido(resultSet.getString("APELLIDO"));
				medico.setSexo(resultSet.getString("SEXO"));
				medico.setFechaNacimiento(resultSet.getString("FECHA_NAC"));
				medico.setEmail(resultSet.getString("EMAIL"));
				medico.setNacionalidad(new Nacionalidad(resultSet.getInt("COD_NACIONALIDAD"), resultSet.getString("DESC_NACIONALIDAD")));
				medico.setEspecialidad(new Especialidad(resultSet.getInt("COD_ESPECIALIDAD"), resultSet.getString("DESC_ESPECIALIDAD")));				
				medicos.add(medico);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return medicos;
	}
	

	
}
