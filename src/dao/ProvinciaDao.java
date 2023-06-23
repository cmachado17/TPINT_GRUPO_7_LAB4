package dao;

import java.util.ArrayList;

import entidad.Provincia;
import excepciones.ReadAllException;

public interface ProvinciaDao {

	public ArrayList<Provincia> obtenerProvincias()throws ReadAllException;
}
