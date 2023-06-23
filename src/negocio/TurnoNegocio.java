package negocio;

import java.util.ArrayList;

import entidad.Turno;

public interface TurnoNegocio {
	public ArrayList<Turno> turnosMedico(String dni);
}
