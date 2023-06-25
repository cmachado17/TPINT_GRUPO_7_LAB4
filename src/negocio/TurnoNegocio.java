package negocio;

import java.util.ArrayList;

import entidad.Turno;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public interface TurnoNegocio {
	
	public boolean update(Turno turno) throws UpdateException;
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException;
}
