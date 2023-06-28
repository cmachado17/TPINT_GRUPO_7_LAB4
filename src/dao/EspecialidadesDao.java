package dao;

import java.util.ArrayList;

import entidad.Especialidad;
import excepciones.ReadAllException;

public interface EspecialidadesDao {
	public ArrayList<Especialidad> obtenerEspecialidades() throws ReadAllException;;
}
