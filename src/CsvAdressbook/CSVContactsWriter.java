package CsvAdressbook;

import AdressBook.ContactDetails;
import application.ObservableContactDetails;
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

	final static Charset ENCODING = StandardCharsets.UTF_8;

	public void writeEntityList(List<ObservableContactDetails> contact,
			String filename, String splitter) throws IOException {
		Path path = Paths.get("ausgabe/" + filename + ".csv");
		writeEntityList(contact, path, splitter);
	}

	public void writeEntityList(List<ObservableContactDetails> contact,
			Path path, String splitter) throws IOException {
		List<String> lines = new ArrayList<>();
		for (ObservableContactDetails contacts : contact) {
			lines.add(ObservableContactDetailsAsCSVLine(contacts, splitter));
		}
		Files.write(path, lines, ENCODING);
	}

	private String ObservableContactDetailsAsCSVLine(
			ObservableContactDetails c, String splitter) {
		return c.getName() + splitter + c.getVorname() + splitter
				+ c.getAdresse() + splitter;

	}

}
