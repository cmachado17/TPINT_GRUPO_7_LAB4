package entidad;

public class Usuario {
	private int CodigoUsuario;
	private int Dni;
	private String Clave;
	private boolean Estado;
	
	public Usuario() {}
	
	public int getCodigoUsuario() {
		return CodigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		CodigoUsuario = codigoUsuario;
	}
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
}
