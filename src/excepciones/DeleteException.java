package excepciones;

import java.io.IOException;

public class DeleteException extends IOException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo eliminar el registro de la base de datos";
	}
}
