package Csv;

import AdressBook.ContactDetails;
import calendar.Appointment;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;




public class CSVContactsWriter {
	// Attribut
		final static Charset ENCODING = StandardCharsets.UTF_8;
		
		//Helferklasse, die aus String-Dateinamen einen Pfad bastelt
		//Dann wird die zweite Methode (Methodenüberladung) aufgerufen die einen Pfad verlangt
		// Diese Methode ruft die untere Methode auf
		public void writeEntityList(List<ContactDetails> contact, String filename, String splitter) throws IOException {
			Path path = Paths.get("ausgabe/" + filename + ".csv");
			writeEntityList(contact, path, splitter);
		}
		
		
		//Collection von Appointments wird entgegengenommen und durchiteriert.
		//Jeder Index entspricht einem Temrin, dieser wird in's richtige Format gebracht und einer zweiten Collection übergeben.
		//Anschließend wird letztere Collection in die Datei geschrieben.
		public void writeEntityList(List<ContactDetails> contact, Path path, String splitter) throws IOException {
			List<String> lines = new ArrayList<>();
			for (ContactDetails contacts : contact ) {
				lines.add(contactsAsCSVLine(contacts, splitter));
			}
			Files.write(path, lines, ENCODING);
		}

		//CSV-Formatierung:
		//aus einem gegebenem Objekt werden alle Attribute ausgelesen und von Trennzeichen getrennt, in einem String zusammengefasst.
		private String contactsAsCSVLine(ContactDetails c, String splitter) {
			return c.getName()+ splitter
					+ c.getVorname() + splitter
					+ c.getAdresse() + splitter;
					
		}
//		
//		//Helferklasse, die aus String-Dateinamen einen Pfad bastelt
//		//Dann wird die zweite Methode aufgerufen die einen Pfad verlangt
//		public void writeAppointment(Appointment appointment, String filename, String splitter) throws IOException {
//			Path path = Paths.get("output/" + filename + ".csv");
//			writeAppointment(appointment, path, splitter);
//		}
//		
//		//Einzelnes Appointment wird geschrieben
//		public void writeAppointment(Appointment appointment, Path path, String splitter) throws IOException {
//			List<String> lines = new ArrayList<>();
//			lines.add(formatAppointmentToCSV(appointment, splitter));
//			Files.write(path, lines, ENCODING);
//		}
	
}
