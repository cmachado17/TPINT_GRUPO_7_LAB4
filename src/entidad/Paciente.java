package entidad;

import java.sql.Date;

public class Paciente extends Persona {

	private int codPaciente;

	public Paciente() {
		
	}

	public int getCodPaciente() {
		return codPaciente;
	}


	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}


	@Override
	public String toString() {
		return "Paciente [Cod. del paciente =\" + codPaciente + \", Dni=" + getDni() + ", Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Sexo=" + getSexo()
				+ ", CodNacionalidad=" + getCodNacionalidad() + ", FechaNacimiento=" + getFechaNacimiento() + ", Direccion="
				+ getDireccion() + ", Localidad=" + getLocalidad() + ", Provincia=" + getProvincia() + ", Email=" + getEmail()
				+ ", Telefono=" + getTelefono() + ", Estado=" + getEstado() + "]";
	}
	
	
	
}
