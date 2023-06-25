package dao;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Turno;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;


public interface TurnosDao {
	public boolean insert(Medico medico)throws InsertException;
	public boolean update(Turno turno) throws UpdateException;
	public ArrayList<Turno> readAll()throws ReadAllException;
	public ArrayList<Turno> turnosMedico(String dni)throws ReadAllException;
	public ArrayList<Turno> turnosAsignadosPorMedico(String dni)throws ReadAllException;
}
