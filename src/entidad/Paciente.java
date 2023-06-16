package entidad;

public class Paciente extends Persona {

	private int codPaciente;

	public Paciente() {
		super();
		
	}

	public Paciente(int codPaciente) {
		super();
		this.codPaciente = codPaciente;
	}

	public int getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	@Override
	public String toString() {
		return "Paciente [codPaciente=" + codPaciente + "]";
	}

	
	
	
}
