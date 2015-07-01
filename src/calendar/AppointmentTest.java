/**
 * 
 */
package calendar;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import AdressBook.KeinKontaktException;

/**
 * @author rocko
 *
 */
public class AppointmentTest {
	
	Appointment termin = new Appointment();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		termin.setTerminBezeichnung("Testbezeichnung");
		termin.setStartUhrzeit(LocalTime.of(12, 20));
		termin.setEndUhrzeit(LocalTime.of(18, 59));
		termin.setDatum(LocalDate.of(2015, 05, 29));
		//termin.setEndUhrzeit("18:00");
	}

	@Test
	public void SetterStartzeit() {
		termin.setStartUhrzeit(LocalTime.of(18, 00));		
	}
	
	//Startzeit-test
	@Test
	public void Startzeit() {
		//termin.setStartUhrzeit(LocalTime.of(18, 00));
		assertTrue(termin.getStartUhrzeit().equals(LocalTime.of(12, 20)));
		
//		assertTrue(termin.getStartUhrzeit()=="19:30");
//		assertTrue(termin.getEndUhrzeit()=="18:00");
//		assertTrue(termin.getTerminBezeichnung()=="Bez-ONE");
	}
	
	//Endzeit-test
	@Test
	public void Endzeit() {
		//termin.setStartUhrzeit(LocalTime.of(18, 00));
		assertTrue(termin.getEndUhrzeit().equals(LocalTime.of(18, 59)));
	}
	
	//BeforeException-test
	@Test (expected = BeforeException.class)
	public void BeforeException() throws calendar.BeforeException {
			termin.setEndUhrzeit(LocalTime.of(10, 00));
	}
	
	//Datum-test
	@Test
	public void Datum() {
		//termin.setStartUhrzeit(LocalTime.of(18, 00));
		assertTrue(termin.getDatum().equals(LocalDate.of(2015, 05, 29)));
	}
}
