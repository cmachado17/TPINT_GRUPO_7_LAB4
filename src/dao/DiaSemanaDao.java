package dao;

import java.util.ArrayList;

import entidad.DiaSemana;
import excepciones.ReadAllException;

public interface DiaSemanaDao {
	public ArrayList<DiaSemana> obtenerDiaSemana() throws ReadAllException ;
}
