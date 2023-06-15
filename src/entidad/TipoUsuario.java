package entidad;

public class TipoUsuario {
	private int CodigoTipoUsuario;
	private String Descripcion;
	
	public TipoUsuario() {}
	
	public int getCodigoTipoUsuario() {
		return CodigoTipoUsuario;
	}
	public void setCodigoTipoUsuario(int codigoTipoUsuario) {
		CodigoTipoUsuario = codigoTipoUsuario;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoUsuario [CodigoTipoUsuario=" + CodigoTipoUsuario + ", Descripcion=" + Descripcion + "]";
	}
	
	
}
