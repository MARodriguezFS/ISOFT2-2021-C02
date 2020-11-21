package dominio;

public class GestorCamarero implements EstadosMesas{
	
	public GestorCamarero() {
	}
	
	public static void preparar_mesa(int id_mesa) throws MesaNoExisteException{
		Mesa mesa = new Mesa(id_mesa);
		mesa.cambiarEstado(PREPARACION);
	}
	
	public static void servir_mesa(int id_mesa) throws MesaNoExisteException{
		Mesa mesa = new Mesa(id_mesa);
		mesa.cambiarEstado(SERVIDA);
	}
	
	public static void cobrar(int id_mesa) throws MesaNoExisteException{
		//TODO
	}
	
	public void recoger_comanda(int id_mesa) {
		//TODO
	}
	public static boolean autenticar(String login, String password) throws Exception{
		boolean autenticado = false;
		Usuario u = new Usuario(login, password);
		if(u.read(login, password) != null)
			autenticado = true;
		return autenticado;
	}

	public static boolean nuevoUsuario(String login, String password) throws Exception{
		boolean insertado = false;
		Usuario u = new Usuario(login, password);
		if(u.insert(login, password) ==1)
			insertado = true;
		return insertado;		
	}

	public static boolean eliminarUsuario(String login, String password) throws Exception{
		boolean eliminado = false;
		Usuario u = new Usuario(login, password);
		if(u.delete(login, password) ==1)
			eliminado = true;
		return eliminado;		
	}
	
	public static boolean cambiarPass(String login, String password, String newPassword) throws Exception{
		boolean cambiado = false;
		Usuario u = new Usuario(login, password);
		if(u.cambiarPass(newPassword) ==1)
			cambiado = true;
		return cambiado;		
	}
	

}
