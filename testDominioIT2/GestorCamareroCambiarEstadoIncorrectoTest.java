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
public class GestorCamareroCambiarEstadoIncorrectoTest {
	private String estado;
	private long idMesa;
	private boolean expectError;
	static GestorCamarero gestor;

	@Parameters
	public static Iterable<Object[]> getData(){
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {"En preparacion", -5});
		obj.add(new Object[] {"Servidos", -5});
		obj.add(new Object[] {"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", -5});
		obj.add(new Object[] {"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", 10});
		obj.add(new Object[] {"Pagando", 2147483648L});
		obj.add(new Object[] {"Ocupada", 2147483648L});
		obj.add(new Object[] {"Libre", -5});
		obj.add(new Object[] {"Pidiendo", 2147483648L});
		obj.add(new Object[] {"Libre", 2147483648L});
		obj.add(new Object[] {"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", 2147483648L});
		obj.add(new Object[] {"En preparación", 2147483648L});
		obj.add(new Object[] {"Esperando la cuenta", 2147483648L});
		obj.add(new Object[] {"Reservada", 2147483648L});
		obj.add(new Object[] {"Esperando la cuenta", -5});
		obj.add(new Object[] {"Servidos", 2147483648L});
		obj.add(new Object[] {"En espera de comida", 2147483648L});
		obj.add(new Object[] {"Ocupada", -5});
		obj.add(new Object[] {"Pagando", -5});
		obj.add(new Object[] {"Pidiendo", -5});
		obj.add(new Object[] {"En espera de comida", -5});
		obj.add(new Object[] {"Reservada", -5});
		return obj;
	}

	public GestorCamareroCambiarEstadoIncorrectoTest(String estado, long idMesa) {
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

