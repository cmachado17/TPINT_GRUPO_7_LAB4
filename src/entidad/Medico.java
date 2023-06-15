package entidad;

import java.sql.Date;

public class Medico extends Persona {

	private int tipoUsuario;
	private Especialidad especialidad;
	private String diaAtencion;
	int horarioInicioAtencion;
	int horarioFinAtencion;

	public Medico() {
		
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getDiaAtencion() {
		return diaAtencion;
	}

	public void setDiaAtencion(String diaAtencion) {
		this.diaAtencion = diaAtencion;
	}

	public int getHorarioInicioAtencion() {
		return horarioInicioAtencion;
	}

	public void setHorarioInicioAtencion(int horarioInicioAtencion) {
		this.horarioInicioAtencion = horarioInicioAtencion;
	}

	public int getHorarioFinAtencion() {
		return horarioFinAtencion;
	}

	public void setHorarioFinAtencion(int horarioFinAtencion) {
		this.horarioFinAtencion = horarioFinAtencion;
	}

	@Override
	public String toString() {
		return "Medico [tipoUsuario=" + tipoUsuario + ", especialidad=" + especialidad + ", diaAtencion=" + diaAtencion
				+ ", horarioInicioAtencion=" + horarioInicioAtencion + ", horarioFinAtencion=" + horarioFinAtencion
				+ "]";
	}
	
}
