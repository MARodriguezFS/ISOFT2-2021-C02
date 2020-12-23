package Persistencia;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
public class ReservaTest {

	@Test
	public void testConstructGettersSetters() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime fecha = formatter.parseDateTime("2020-03-14 13:00:00");
		Reserva r = new Reserva(1,1,fecha,"Fernando");
		Reserva r1 = new Reserva(1);
		Assert.assertNotNull(r);
		Assert.assertNotNull(r1);
		assertEquals(1, r1.getIdReserva());
		
	}
	
	@Test
	public void testGetListaReservas() throws Exception {
		LinkedList<Reserva> listaReservas = new LinkedList<Reserva>();
		listaReservas = Reserva.getListaReservas();
		Assert.assertNotNull(listaReservas);
	}
	
	@Test
	public void testInsert() throws Exception {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime fecha = formatter.parseDateTime("2020-03-14 13:00:00");
		Reserva r = new Reserva(1,1,fecha,"Fernando");
		assertEquals(1, r.insert());
	}
	
	@Test
	public void testDelete() throws Exception {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime fecha = formatter.parseDateTime("2020-03-14 13:00:00");
		Reserva r = new Reserva(1,1,fecha,"Fernando");
		assertEquals(1, r.delete());
	}
}
