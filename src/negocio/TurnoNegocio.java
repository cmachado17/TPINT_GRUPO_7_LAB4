package negocio;

import java.util.ArrayList;

import entidad.Persona;
import entidad.Turno;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public interface TurnoNegocio {
	
	public boolean update(Turno turno) throws UpdateException;
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException;
	public ArrayList<Turno> turnosAsignadosPorMedico(String dni) throws ReadAllException;
	public ArrayList<Turno> readAll() throws ReadAllException;
	public boolean updatePorMedico(Turno turno)throws UpdateException;
	public Turno buscarTurno(String paciente, String medico, String hora, String dia);
}
