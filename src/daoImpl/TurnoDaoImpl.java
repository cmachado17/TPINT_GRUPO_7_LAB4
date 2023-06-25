package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TurnosDao;
import entidad.Medico;
import entidad.Persona;
import entidad.Turno;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public class TurnoDaoImpl implements TurnosDao {
	
	private static final String insert  = "CALL INSERTTURNOS(?,?,?,?,?)";
	private static final String update = "UPDATE turnos  SET COD_PACIENTE = ?, COD_ESTADO_TURNO = ? WHERE DNIMEDICO = ? AND"
			+ "DIA = ? AND HORARIO = ? ";
	private static final String turnosPorMedico = "SELECT * FROM TURNOS WHERE COD_PACIENTE IS NULL AND ESTADO = 1 AND DNIMEDICO = ?";

	@Override
	public boolean insert(Medico medico) throws InsertException {
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try{
			CallableStatement statement = conexion.prepareCall(insert);
			statement.setInt(1, medico.getDni());
			statement.setInt(2, medico.getDiaAtencion().getCodigo());
			statement.setString(3, medico.getHorarioInicioAtencion());
			statement.setString(4, medico.getHorarioFinAtencion());
			statement.setInt(5, medico.getEspecialidad().getCodigo());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		}catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new InsertException();
			}
		}
		
		return isOk;

	}

	@Override
	public ArrayList<Turno> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(turnosPorMedico);
			statement.setString(1,dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{							
				Turno turno = new Turno();
				turno.setMedico(new Medico(Integer.parseInt(resultSet.getString("DNIMEDICO"))));
				turno.setHorario(resultSet.getString("HORARIO"));
				turno.setDia(resultSet.getString("DIA"));
				turnos.add(turno);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		return turnos;
	}
	
	@Override
	public boolean update(Turno turno) throws UpdateException {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(update);
			
			statement.setInt(1, turno.getPaciente().getCodPaciente());
			statement.setInt(2, turno.getEstadoTurno().getCodigo());
			statement.setInt(3, turno.getMedico().getDni());
			statement.setString(4, turno.getDia());
			statement.setString(5, turno.getHorario());
			
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
				throw new UpdateException();
			}
		}
		return isOk;
	}
}


