package negocioImpl;

import java.util.ArrayList;

import daoImpl.EstadisticasPacientesDaoImpl;
import entidad.EstadisticasPacientes;
import excepciones.ReadAllException;

public class EstadisticasPacientesNegocioImpl implements negocio.EstadisticasPacientesNegocio  {
	
	
	EstadisticasPacientesDaoImpl eDao = new EstadisticasPacientesDaoImpl();
	@Override
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasRangoEdades() throws ReadAllException {
		return eDao.obtenerEstadisticasRangoEdades();
	}
	@Override
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasTurnosXEsp() throws ReadAllException {
		return eDao.obtenerEstadisticasTurnosXEsp();
	}
	

}
