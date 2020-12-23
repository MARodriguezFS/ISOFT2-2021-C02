package dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GestorCamareroCrearComandaIncorrectaTest {
	private long primero, segundo, postre, bebida, entrantes, idCamarero, idMesa;
	static GestorCamarero gestor;
	
	@Parameters
	public static Iterable<Object[]> getData(){
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {-5, 2147483648L, -5, 10, -5, 10, 2147483648L});
		obj.add(new Object[] {2147483648L, -5, 10, -5, -5, 2147483648L, -5});
		obj.add(new Object[] {-5, 10, 2147483648L, 2147483648L, 2147483648L, -5, 10});
		obj.add(new Object[] {10, 2147483648L, 2147483648L, -5, 10, 10, 10});
		obj.add(new Object[] {10, -5, 2147483648L, 2147483648L, 10, 2147483648L, 2147483648L});
		obj.add(new Object[] {10, 10, 10, 10, 2147483648L, 10, -5});
		obj.add(new Object[] {2147483648L, -5, -5, 2147483648L, -5, 10, 10});
		obj.add(new Object[] {2147483648L, -5, 10, 10, 10, -5, 2147483648L});
		obj.add(new Object[] {10, 10, -5, -5, -5, -5, 2147483648L});
		obj.add(new Object[] {-5, 2147483648L, -5, 2147483648L, 2147483648L, 2147483648L, -5});
		obj.add(new Object[] {2147483648L, 2147483648L, 2147483648L, -5, 2147483648L, -5, -5});
		obj.add(new Object[] {-5, 10, 2147483648L, 10, 10, 2147483648L, -5});
		obj.add(new Object[] {-5, -5, 10, 10, 2147483648L, 2147483648L, 10});
		obj.add(new Object[] {2147483648L, 10, -5, -5, 10, 10, -5});
		obj.add(new Object[] {-5, 2147483648L, 10, 2147483648L, 2147483648L, 2147483648L, 2147483648L});
		obj.add(new Object[] {-5, -5, 2147483648L, -5, -5, -5, 2147483648L});
		return obj;
	}
	
	public GestorCamareroCrearComandaIncorrectaTest(long primero, long segundo, long postre, long bebida, long entrantes, long idCamarero, long idMesa) {
		this.primero = primero;	
		this.segundo = segundo;
		this.postre = postre;
		this.bebida = bebida;
		this.entrantes = entrantes;
		this.idCamarero = idCamarero;
		this.idMesa = idMesa;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GestorCamarero gestor = new GestorCamarero();
	}

	@Test(expected = Exception.class)
	public void testCrearComanda() throws Exception {
		boolean creada = gestor.crearComanda((int)primero, (int)segundo, (int)postre, (int)bebida, (int)entrantes, (int)idCamarero, (int)idMesa);
		assertFalse(creada);
	}


}
