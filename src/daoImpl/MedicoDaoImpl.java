package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MedicoDao;
import entidad.Medico;

public class MedicoDaoImpl implements MedicoDao{

	//private static final String insert  = "INSERT INTO empleados (DNI, NOMBRE, APELLIDO, SEXO, COD_NACIONALIDAD, FECHA_NAC, DIRECCION, LOCALIDAD, PROVINCIA, EMAIL, TELEFONO, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String insertMedicoXEspecialidad  = "INSERT INTO medico_por_especialidad (DNI, COD_ESPECIALIDAD, DIASEMANA, HORAINICIO, HORAFIN, ESTADO) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String insert  = "CALL INSERTMEDICO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
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
			statement.setInt(5, medico.getCodNacionalidad().getCodigo());
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
	public boolean insertMedicoXEspecilidad(Medico medico) {
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			PreparedStatement statement = conexion.prepareStatement(insertMedicoXEspecialidad);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Medico> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
