package negocio;

import java.util.ArrayList;

import entidad.Turno;
import excepciones.ReadAllException;

public interface TurnoNegocio {
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException;
}
