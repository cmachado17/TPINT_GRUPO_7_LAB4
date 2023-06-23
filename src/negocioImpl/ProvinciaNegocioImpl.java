package negocioImpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidad.Provincia;
import excepciones.ReadAllException;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio{

	ProvinciaDao pDao = new ProvinciaDaoImpl();
	
	@Override
	public ArrayList<Provincia> obtenerProvincias() throws ReadAllException {
		return pDao.obtenerProvincias();
	}

}
