package excepciones;

import java.io.IOException;

public class BuscarException extends IOException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo obtener el registro de la base de datos";
	}
}
