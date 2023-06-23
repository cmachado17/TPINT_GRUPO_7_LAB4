package negocioImpl;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daoImpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;
import excepciones.ReadAllException;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio{

	NacionalidadDao nDao = new NacionalidadDaoImpl();
	
	@Override
	public ArrayList<Nacionalidad> obtenerNacionalidades() throws ReadAllException {
		
		return nDao.obtenerNacionalidades();
	}

}
