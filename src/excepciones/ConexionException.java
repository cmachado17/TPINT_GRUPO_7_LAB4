package excepciones;

import java.io.IOException;

public class ConexionException extends IOException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo establecer la conexion con la base de datos";
	}
}
