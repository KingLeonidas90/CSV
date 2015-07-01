package Csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import AdressBook.ContactDetails;

public class CSVContactsReader {

	public static List<ContactDetails> readEntityList(String dateiname, String splitter) {
		Path source = Paths.get(dateiname);
		return readEntityList(dateiname, splitter);
	}
	public static List<ContactDetails> readEntityList(Path source, String splitter) {
		List<ContactDetails> target = new ArrayList<>();
		try {
		List<String> lines = Files.readAllLines(source);
		for (String line : lines){
			try{
				target.add(new ContactDetails(line.split(splitter)));
		
		} catch (Exception e) {e.printStackTrace(System.err);
			target.add(new ContactDetails());
			}
		}
	} catch (IOException e)	{e.printStackTrace(System.err);
		target.addAll(null);
		
	}
	return target;
	}
}
