package negocioImpl;

import java.util.ArrayList;

import dao.EspecialidadesDao;
import daoImpl.EspecialidadesDaoImpl;
import entidad.Especialidad;
import negocio.EspecialidadNegocio;

public class EspecialidadNegocioImpl implements EspecialidadNegocio{
	
	EspecialidadesDao eDao = new EspecialidadesDaoImpl();

	@Override
	public ArrayList<Especialidad> obtenerEspecialidades() {
		return eDao.obtenerEspecialidades();
	}

}
