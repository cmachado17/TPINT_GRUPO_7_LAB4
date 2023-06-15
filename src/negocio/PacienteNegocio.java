package negocio;

import java.util.ArrayList;

import entidad.Paciente;


public interface PacienteNegocio {

	public boolean insert(Paciente paciente);
	public boolean delete(Paciente paciente_a_eliminar);
	public boolean update(Paciente paciente);
	public ArrayList<Paciente> readAll();
	public boolean dniNoExiste(Paciente paciente);
	public Paciente buscarPaciente(String dni);
}
