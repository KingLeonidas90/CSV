package CsvTerminkalender;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import calendar.Appointment;

public class CSVTerminWriter {

	final static Charset ENCODING = StandardCharsets.UTF_8;

	public void writeAppointment(List<Appointment> appointment,
			String filename, String splitter) throws IOException {
		Path path = Paths.get( filename);
		writeAppointment(appointment, path, splitter);
	}

	public void writeAppointment(List<Appointment> appointment, Path path,
			String splitter) throws IOException {
		List<String> lines = new ArrayList<>();
		for (Appointment index : appointment) {
			lines.add(formatAppointmentToCSV(index, splitter));
		}
		Files.write(path, lines, ENCODING);
	}

	private String formatAppointmentToCSV(Appointment appointment,
			String splitter) {
		return appointment.getDatum() + splitter
				+ appointment.getTerminBezeichnung() + splitter
				+ appointment.getStartUhrzeit() + splitter
				+ appointment.getEndUhrzeit() + splitter
				+ appointment.getTerminkategorie() + splitter;

	}

	public void writeAppointment(Appointment appointment, String filename,
			String splitter) throws IOException {
		Path path = Paths.get("output/" + filename + ".csv");
		writeAppointment(appointment, path, splitter);
	}

	public void writeAppointment(Appointment appointment, Path path,
			String splitter) throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add(formatAppointmentToCSV(appointment, splitter));
		Files.write(path, lines, ENCODING);
	}
}
