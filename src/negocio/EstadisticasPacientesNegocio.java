package negocio;

import java.util.ArrayList;

import excepciones.ReadAllException;

public interface EstadisticasPacientesNegocio {
	public ArrayList<entidad.EstadisticasPacientes> obtenerEstadisticasRangoEdades() throws ReadAllException;
	public ArrayList<entidad.EstadisticasPacientes> obtenerEstadisticasTurnosXEsp() throws ReadAllException;

}
