package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TurnosDao;
import entidad.Especialidad;
import entidad.EstadoTurno;
import entidad.Medico;
import entidad.Nacionalidad;
import entidad.Paciente;
import entidad.Provincia;
import entidad.Turno;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public class TurnoDaoImpl implements TurnosDao {
	
	private static final String insert  = "CALL INSERTTURNOS(?,?,?,?,?)";
	private static final String update = "UPDATE turnos SET COD_PACIENTE = ?, COD_ESTADO_TURNO = ? WHERE DNIMEDICO = ? AND "
			+ "DIA = ? AND HORARIO = ? ";
	private static final String turnosPorMedico = "SELECT * FROM TURNOS WHERE COD_PACIENTE IS NULL AND ESTADO = 1 AND DNIMEDICO = ?";
	private static final String turnosAsignadosPorMedico = "SELECT T.DNIMEDICO, T.DIA, T.HORARIO, T.COD_PACIENTE, T.COD_ESTADO_TURNO, EST_TURNOS.DESCRIPCION AS DESC_ESTADO_TURNO,\r\n" + 
			"P.DNI AS DNI_PACIENTE, P.NOMBRE AS NOMBRE_PACIENTE, P.APELLIDO AS APELLIDO_PACIENTE, P.SEXO AS SEXO_PACIENTE, P.COD_NACIONALIDAD AS COD_NACIONALIDAD_PACIENTE, NAC.DESCRIPCION AS DESC_NACIONALIDAD_PACIENTE,\r\n" + 
			"P.FECHA_NAC AS FEC_NAC_PACIENTE, P.DIRECCION AS DIR_PACIENTE, P.LOCALIDAD AS LOC_PACIENTE, P.PROVINCIA AS COD_PROV_PACIENTE, PROV.DESCRIPCION AS DESC_PROV_PACIENTE,P.EMAIL AS EMAIL_PACIENTE,\r\n" + 
			" P.TELEFONO AS TEL_PACIENTE, P.ESTADO AS ESTADO_PACIENTE\r\n" + 
			"FROM TURNOS T\r\n" + 
			"INNER JOIN ESTADOS_TURNOS EST_TURNOS ON EST_TURNOS.CODIGO = T.COD_ESTADO_TURNO\r\n" + 
			"INNER JOIN PACIENTES P ON P.CODIGO = T.COD_PACIENTE\r\n" + 
			"INNER JOIN NACIONALIDADES NAC ON NAC.CODIGO = P.COD_NACIONALIDAD\r\n" + 
			"INNER JOIN PROVINCIAS PROV ON PROV.CODIGO = P.PROVINCIA\r\n" + 
			"WHERE T.ESTADO = 1 AND COD_PACIENTE IS NOT NULL AND T.DNIMEDICO = ?";
	
	private static final String readall = "SELECT T.DNIMEDICO, T.DIA, T.HORARIO, T.COD_PACIENTE, T.COD_ESPECIALIDAD, T.COD_ESTADO_TURNO, ET.DESCRIPCION AS DESC_ESTADO, T.ESTADO, M.COD_ESPECIALIDAD, E.NOMBRE, E.APELLIDO, "
			+ "Esp.DESCRIPCION as DESC_ESPECIALIDAD, PA.Codigo, PA.Nombre, PA.Apellido FROM Turnos AS T INNER JOIN medico_por_especialidad as M ON M.DNIMedico= T.DNIMEDICO "
			+ "INNER JOIN especialidades AS Esp ON M.COD_ESPECIALIDAD = Esp.CODIGO "
			+ "INNER JOIN empleados AS E ON E.DNI = T.DNIMEDICO "
			+ "INNER JOIN estados_turnos AS ET ON ET.CODIGO = T.COD_ESTADO_TURNO "
			+ "LEFT JOIN Pacientes AS PA ON PA.Codigo = T.COD_PACIENTE "
			+ "WHERE T.ESTADO=1 ";
	private static final String updatePorMedico = "UPDATE turnos SET COD_ESTADO_TURNO = ?, COMENTARIO = ? WHERE DNIMEDICO = ? AND "
			+ "DIA = ? AND HORARIO = ? ";
	private static final String buscarTurno = "SELECT * FROM TURNOS WHERE DNIMEDICO = ? AND DIA = ? AND HORARIO = ? AND COD_PACIENTE = ? AND ESTADO = 1";
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
	public ArrayList<Turno> readAll() throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{							
				Turno turno = new Turno();
				turno.setMedico(new Medico(Integer.parseInt(resultSet.getString("DNIMEDICO"))));
				turno.getMedico().setNombre(resultSet.getString("NOMBRE"));
				turno.getMedico().setApellido(resultSet.getString("APELLIDO"));		
				turno.setPaciente(new Paciente(Integer.parseInt(resultSet.getString("PA.Codigo") != null ? resultSet.getString("PA.Codigo") : "0")));
				turno.getPaciente().setNombre(resultSet.getString("PA.Nombre"));
				turno.getPaciente().setApellido(resultSet.getString("PA.Apellido"));
				turno.setDia(resultSet.getString("DIA"));
				turno.setHorario(resultSet.getString("HORARIO"));
				turno.setEspecialidad(new Especialidad(resultSet.getInt("COD_ESPECIALIDAD"), resultSet.getString("DESC_ESPECIALIDAD")));
				turno.setEstadoTurno(new EstadoTurno(resultSet.getInt("COD_ESTADO_TURNO"),resultSet.getString("DESC_ESTADO")));
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

	@Override
	public ArrayList<Turno> turnosAsignadosPorMedico(String dni) throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(turnosAsignadosPorMedico);
			statement.setString(1,dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{							
				Turno turno = new Turno();
				turno.setMedico(new Medico(Integer.parseInt(resultSet.getString("DNIMEDICO"))));
				turno.setHorario(resultSet.getString("HORARIO"));
				turno.setDia(resultSet.getString("DIA"));
				turno.setEstadoTurno(new EstadoTurno(Integer.parseInt(resultSet.getString("COD_ESTADO_TURNO")), resultSet.getString("DESC_ESTADO_TURNO")));
				Paciente paciente = new Paciente();
				paciente.setCodPaciente(Integer.parseInt(resultSet.getString("COD_PACIENTE")));
				paciente.setDni(Integer.parseInt(resultSet.getString("DNI_PACIENTE")));
				paciente.setNombre(resultSet.getString("NOMBRE_PACIENTE"));
				paciente.setApellido(resultSet.getString("APELLIDO_PACIENTE"));
				paciente.setSexo(resultSet.getString("SEXO_PACIENTE"));
				paciente.setNacionalidad(new Nacionalidad(Integer.parseInt(resultSet.getString("COD_NACIONALIDAD_PACIENTE")), resultSet.getString("DESC_NACIONALIDAD_PACIENTE")));
				paciente.setFechaNacimiento(resultSet.getString("FEC_NAC_PACIENTE"));
				paciente.setDireccion(resultSet.getString("DIR_PACIENTE"));
				paciente.setLocalidad(resultSet.getString("LOC_PACIENTE"));
				paciente.setProvincia(new Provincia(Integer.parseInt(resultSet.getString("COD_PROV_PACIENTE")), resultSet.getString("DESC_PROV_PACIENTE")));
				paciente.setEmail(resultSet.getString("EMAIL_PACIENTE"));
				paciente.setTelefono(resultSet.getString("TEL_PACIENTE"));
				paciente.setEstado(Boolean.parseBoolean(resultSet.getString("ESTADO_PACIENTE")));
				turno.setPaciente(paciente);
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
	public boolean updatePorMedico(Turno turno) throws UpdateException {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(updatePorMedico);

			statement.setInt(1, turno.getEstadoTurno().getCodigo());
			statement.setInt(3, turno.getMedico().getDni());
			statement.setString(4, turno.getDia());
			statement.setString(5, turno.getHorario());
			
			if(turno.getEstadoTurno().getCodigo() == 4) {
				//presente
				statement.setString(2, turno.getComentario());
			}else {
				//ausente, no requiere comentario
				statement.setString(2, "-");
			}
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

	@Override
	public Turno buscarTurno(String paciente, String medico, String hora, String dia) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Turno turno = new Turno();
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(buscarTurno);
			statement.setString(1,medico);
			statement.setString(2,dia);
			statement.setString(3,hora);
			statement.setString(4,paciente);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{							
				turno.setMedico(new Medico(Integer.parseInt(resultSet.getString("DNIMEDICO"))));
				turno.setPaciente(new Paciente(Integer.parseInt(resultSet.getString("COD_PACIENTE"))));
				turno.setHorario(resultSet.getString("HORARIO"));
				turno.setDia(resultSet.getString("DIA"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return turno;
	}	
}


