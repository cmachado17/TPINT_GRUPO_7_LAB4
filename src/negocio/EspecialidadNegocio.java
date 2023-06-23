package negocio;

import java.util.ArrayList;

import entidad.Especialidad;
import excepciones.ReadAllException;

public interface EspecialidadNegocio {
	public ArrayList<Especialidad> obtenerEspecialidades() throws ReadAllException;
}
