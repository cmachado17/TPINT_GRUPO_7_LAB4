package dao;

import java.util.ArrayList;

import entidad.EstadisticasPacientes;
import excepciones.ReadAllException;

public interface EstadisticasPacientesDao {
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasRangoEdades() throws ReadAllException;
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasTurnosXEsp() throws ReadAllException;
}
