package AdressBook;

// erzeugt ein Adressbuch mit Beispieldaten
public class AdressBookDefault extends AddressBook {
	// Konstruktor führt Methoden aus Elternklasse aus
	public AdressBookDefault() {
		
		super();
		fillDefaultData();
	}
	
	// Methode um Beispieldaten einzufügen
	private void fillDefaultData() {
		try {
			addDetails(new ContactDetails("Peter", "Pan", "Nimmerland 3"));
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException
				| ParamContactIsEmptyException e) {
			e.printStackTrace();
		}
		try {
			addDetails(new ContactDetails("Francho", "Santana", "Gangway 1"));
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException
				| ParamContactIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addDetails(new ContactDetails("Frank", "The Tank", "Miltiaryaprom 2"));
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException
				| ParamContactIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addDetails(new ContactDetails("Sepp", "Blatter", "Korruptionsweg 900"));
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException
				| ParamContactIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addDetails(new ContactDetails("Frodo", "Beutling", "Auenland 4"));
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException
				| ParamContactIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
