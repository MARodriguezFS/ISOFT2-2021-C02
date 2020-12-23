package Dominio;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestIT1Dominio {

	private int idMesa;
	private int turno;
	private String fecha;
	private String nombreCliente;
	
	public TestIT1Dominio(int idMesa, int turno, String fecha, String nombreCliente) {
		this.idMesa = idMesa;
		this.turno = turno;
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
	}

	@Parameters
	public static Iterable<Object[]> ReservasTest() {
		return (Arrays.asList(new Object[][] {
			
				{ 1, 3, "2020-03-14", "Ana" }, { 5, 6, "2020-02 - 30", "Juan" },
				{ 2, 4, "2020-02-30", "Antonio" }, { 3, 1, "2020-01-02", "Juan" },
				{ 3, 2, "2020-01-02", "Pepe" }, { 1, 4, "2020-01-02", "Pepe" },
				{ 2, 2, "2020-02-30", "Maria" }, { 2, 2, "2022-05-29", "Juan" },
				{ 1, 2, "2020-01-01", "Maria" }, { 1, 3, "2020-01-01", "Maria" },
				{ 1, 3, "2020-01-02", "Maria" }, { 3, 3, "2022-05-29", "Antonio" },
				{ 4, 3, "2019-12-31", "Ana" }, { 4, 3, "2022-05-29", "Pepe" },
				{ 2, 2, "2019-12-31", "Juan" }, { 5, 4, "2020-02-30", "Juan" },
				{ 5, 6, "2020-01-02", "Antonio" }, { 2, 1, "2020-01-01", "Pepe" },
				{ 2, 1, "2022-05-29", "Maria" }, { 3, 6, "2019-12-31", "Ana" },
				{ 1, 1, "2020-02-30", "Ana" }, { 1, 4, "2019-12-31", "Antonio" },
				{ 3, 1, "2019-12-31", "Juan" }, { 1, 6, "2020-02-30", "Pepe" },
				{ 2, 6, "2022-05-29", "Antonio" }, { 5, 2, "2020-01-02", "Pepe" },
				{ 1, 4, "2020-01-01", "Maria" }, { 2, 4, "2019-12-31", "Juan" },
				{ 4, 6, "2022-05-29", "Juan" }, { 2, 1, "2019-12-31", "Maria" },
				{ 5, 6, "2020-01-01", "Antonio" }, { 1, 4, "2022-05-29", "Ana" },
				{ 3, 6, "2019-12-31", "Juan" }, { 3, 1, "2022-05-29", "Maria" },
				{ 1, 2, "2020-02-30", "Antonio" }, { 5, 1, "2019-12-31", "Maria" },
				{ 2, 3, "2020-02-30", "Juan" }, { -1, 4, "2020-01-02", "Pepe" },
				{ 2, 2, "2020-01-01", "Antonio" }, { 2, 3, "2020-01-02", "Ana" },
				{ 4, 6, "2020-01-01", "Ana" }, { 27, 4, "2020-01-01", "Pepe" } }));
	}

	@Test
	public void reservaTest() throws Exception {
		GestorReservas gestor = new GestorReservas();
		boolean insertado = false;
		DateTime fecha1 = new DateTime(fecha);
		insertado = gestor.nuevaReserva(idMesa, turno, fecha1, nombreCliente);
		assertTrue(insertado);
	}
	
	@Test
	public void eliminaReservaTest() throws Exception {
		GestorReservas gestor = new GestorReservas();
		boolean eliminado = false;
		for(int i = 8; i<24; i++) {
		eliminado = gestor.eliminarReserva(i);
		assertTrue(eliminado);
		}
	}
	
	@Test
	public void mesaTest() throws Exception {
		GestorMesa gestor = new GestorMesa();
		boolean insertado = false;
		insertado = gestor.nuevaMesa();
		assertTrue(insertado);
	}
	
	@Test 
	public void cambiarEstadoTest() throws Exception {
		GestorJefeSala gestor = new GestorJefeSala();
		boolean cambiado = false;
		cambiado = gestor.cambiar_estado(3, "Pidiendo");
		assertTrue(cambiado);
	}
	
	
	@Test 
	public void asignarCamareroTest() throws Exception {
		GestorJefeSala gestor = new GestorJefeSala();
		boolean asignado = false;
		asignado = gestor.asignar_camarero(3, 5);
		assertTrue(asignado);
	}
	
	@Test
	public void eliminarTest() throws Exception {
		GestorMesa gestor = new GestorMesa();
		boolean eliminado = false;
		eliminado = gestor.eliminarMesa(6);
		assertTrue(eliminado);
	}

}
