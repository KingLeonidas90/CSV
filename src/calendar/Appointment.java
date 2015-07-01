package calendar;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointment {

	/// ### TERMINKATEGORIE ###///
	private StringProperty terminKategorie = new SimpleStringProperty();
	public String getTerminkategorie() {return terminKategorie.get();}
	public void setTerminkategorie(String terminKategorie) {this.terminKategorie.set(terminKategorie);}

	//### DATUM  #### ///
	//private ObjectProperty<LocalDate> datum = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	private ObjectProperty<LocalDate> datum = new SimpleObjectProperty<LocalDate>();
	public LocalDate getDatum() {return datum.get();}
	public void setDatum(LocalDate date) {	this.datum.set(date);	}

	//### STARTUHRZEIT ###///
	private ObjectProperty<LocalTime> startUhrzeit = new SimpleObjectProperty<LocalTime>();
	public LocalTime getStartUhrzeit() {return startUhrzeit.get();}
	public void setStartUhrzeit(LocalTime startTime) {this.startUhrzeit.set(startTime);}

	/// ### ENDUHRZEIT ###/// // 1B //
	private ObjectProperty<LocalTime> endUhrzeit = new SimpleObjectProperty<LocalTime>();
	public LocalTime getEndUhrzeit() {return endUhrzeit.get();}
	public void setEndUhrzeit(LocalTime endTime) throws BeforeException {
		if(endTime.isBefore(getStartUhrzeit())) throw new BeforeException();
		this.endUhrzeit.set(endTime);}

	/// ### TERMINBEZEICHNUNG ###///
	private StringProperty terminBezeichnung = new SimpleStringProperty();
	public String getTerminBezeichnung(){return terminBezeichnung.get();}
	public void setTerminBezeichnung(String terminBezeichnung){this.terminBezeichnung.set(terminBezeichnung);}
	private StringProperty terminBeschreibung = new SimpleStringProperty();
	
	/// ### TERMINBESCHREIBUNG ###///
	public String getTerminBeschreibung(){return terminBeschreibung.get();}
	public void setTerminBeschreibung(String terminBeschreibung){this.terminBeschreibung.set(terminBeschreibung);}

	/// ### MAIN METHODE ###/// // 1B //
	public static void main(String[] args) {
		Appointment termin = new Appointment();
		termin.setTerminBezeichnung("Bez-ONE");
		termin.setStartUhrzeit(LocalTime.of(12, 20));
		try {
			termin.setEndUhrzeit(LocalTime.of(11, 20));
		} catch (BeforeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		termin.setDatum(LocalDate.of(2015, 05, 29));
		System.out.println(termin.getStartUhrzeit());
		System.out.println(termin.getEndUhrzeit());
		System.out.println(termin.getTerminBezeichnung());
		System.out.println(termin.getDatum());
	}
	
}
