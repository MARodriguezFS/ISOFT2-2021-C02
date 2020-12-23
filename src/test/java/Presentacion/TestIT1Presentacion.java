package Presentacion;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



public class TestIT1Presentacion {
	

	
	@Test
	public void interfazTest() {
		IUConectar interfaz = new IUConectar();
		String[] string = {"",""};
		interfaz.main(string);
	}
	
	@Test
	public void interfazTest2() {
		IUJefeDeSala interfaz = new IUJefeDeSala();
		interfaz.set_visible(true);
	}
	
	@Test
	public void interfazTest3() {
		IUCancelarReserva interfaz = new IUCancelarReserva();
	}

}