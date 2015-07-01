package CsvTerminkalender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import calendar.Appointment;


public class CSVTerminReader {
	
	public static List<Appointment> readAppointment(String dateiname, String splitter) {
		Path source = Paths.get(dateiname);
		return readAppointment(dateiname, splitter);
	}
	
	public static List<Appointment> readAppointment(Path source, String splitter) {
		List<Appointment> target = new ArrayList<>();
		try {
		List<String> lines = Files.readAllLines(source);
		for (String line : lines){
			try{
				target.add(new Appointment(line.split(splitter)));
		
		} catch (Exception e) {e.printStackTrace(System.err);
			target.add(new Appointment());
			}
		}
	} catch (IOException e)	{e.printStackTrace(System.err);
		target.addAll(null);
		
	}
	return target;
	}
}


