package dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GestorCamareroCambiarEstadoTest {
	private String estado;
	private long idMesa;
	private boolean expectError;
	static GestorCamarero gestor;

	@Parameters
	public static Iterable<Object[]> getData(){
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {"En espera de comida", 10});
		obj.add(new Object[] {"Servidos", 10});
		obj.add(new Object[] {"Libre", 10});
		obj.add(new Object[] {"Reservada", 10});
		obj.add(new Object[] {"Pidiendo", 10});
		obj.add(new Object[] {"En preparacion", 10});
		obj.add(new Object[] {"Esperando la cuenta", 10});
		obj.add(new Object[] {"Pagando", 10});
		obj.add(new Object[] {"Ocupada", 10});
		return obj;
	}

	public GestorCamareroCambiarEstadoTest(String estado, long idMesa) {
		this.estado = estado;	
		this.idMesa = idMesa;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GestorCamarero gestor = new GestorCamarero();
	}
	
	@Test
	public void testCambiarEstado() throws Exception {
		boolean creada = gestor.cambiarEstado(estado, (int)idMesa);
		assertFalse(creada);
	}
}
