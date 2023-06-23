package negocio;

import java.util.ArrayList;

import entidad.DiaSemana;
import excepciones.ReadAllException;

public interface DiaSemanaNegocio {
	public ArrayList<DiaSemana> obtenerDiaSemana() throws ReadAllException;
}
