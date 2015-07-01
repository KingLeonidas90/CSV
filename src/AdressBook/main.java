package AdressBook;
import SupportLine.SupportLine;


public class main {

	private static AdressBookExceptionsInterface meinAdressbuch = new AddressBook();
	
	
	public static void main(String[] args) {
		// **************** Testdaten bearbeiten *************
		testdata();
		
		// ************* ab hier Benutzerschnittstelle ********
		boolean cancel = false;
		String input = null, vorname = null, nachname = null, adresse = null;
		while (!cancel){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("Was möchten Sie tun? Bitte eins der folgenden Kommandos eingeben.");
			System.out.println("(b)ye 		-> 	Beendet das Adressbuch");
			System.out.println("(a)nzahl 	-> 	Gibt die Anzahl der Einträge aus");
			System.out.println("(n)eu 		-> 	Legt einen neuen Kontakt an");
			System.out.println("(s)uche 	-> 	Sucht nach eingegebenen Kontakt");
			System.out.println("(e)rneuern 	-> 	Ändert die Details zu einem Kontakt");
			System.out.println("(r)emove 	-> 	Löscht eingegebenen Kontakt");
			System.out.println("(l)iste 	-> 	Gibt alle Kontakte mit eingegebenen String zurück");
			System.out.println("--------------------------------------------------");
			
			input = SupportLine.InputReader();
			switch (input.toLowerCase()){
			case "b" :	
				cancel = true;
				break;
			case "a"	: 
				System.out.println("Anzahl der Kontakte: " + meinAdressbuch.getNumberOfEntries());
				break;
			case "n"	:
				System.out.println("Bitte Vornamen eingeben:");
				vorname = SupportLine.InputReader();
				System.out.println("Bitte Nachnamen eingeben:");
				nachname = SupportLine.InputReader();
				System.out.println("Bitte Adresse eingeben:");
				adresse = SupportLine.InputReader();
				try {
					meinAdressbuch.addDetails(new ContactDetails(nachname,vorname,adresse));
					System.out.println("Neuer Kontakt wurde angelegt.");
				} catch (DoppelException | ParamKeyIsNullException
						| ParamKeyIsEmptyException
						| ParamContactIsNullException | ParamContactIsEmptyException e2) {
					System.out.println(e2.getMessage());
				}

				break;
			case "s"	:
				System.out.println("Bitte Vornamen oder Nachnamen für die Suche iengeben:");
				input = SupportLine.InputReader();
				try {
					System.out.println(meinAdressbuch.getDetails(input).getVorname()+","+meinAdressbuch.getDetails(input).getName());
				} catch (KeinKontaktException | ParamKeyIsNullException
						| ParamKeyIsEmptyException e1) {
					System.out.println(e1.getMessage());
				}
				try {
					System.out.println(meinAdressbuch.getDetails(input).getAdresse());
				} catch (KeinKontaktException | ParamKeyIsNullException
						| ParamKeyIsEmptyException e1) {
					System.out.println(e1.getMessage());
				}
				break;
				
			case "e"	:
				System.out.println("Bitte Vornamen oder Nachnamen des Kontaktes, der geändert werden soll eingeben:");
				input = SupportLine.InputReader();
				System.out.println("Bitte neuen Vornamen eingeben:");
				vorname = SupportLine.InputReader();
				System.out.println("Bitte neuen Nachnamen eingeben:");
				nachname = SupportLine.InputReader();
				System.out.println("Bitte neue Adresse eingeben:");
				adresse = SupportLine.InputReader();
				try {
					meinAdressbuch.changeDetails(input,new ContactDetails(nachname,vorname, adresse));
				} catch (ParamKeyIsNullException | ParamKeyIsEmptyException
						| DoppelException | ParamContactIsNullException | ParamContactIsEmptyException | KeinKontaktException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case "l"	:
				System.out.println("Bitte Such-String eingeben (Case-Sensitive):");
				input = SupportLine.InputReader();
				try {
					//details = new ContactDetails(meinAdressbuch.search(input));
					for(ContactDetails detail : meinAdressbuch.search(input)){
							
						System.out.println(detail.getVorname() + ",\t" + detail.getName() + ",\t" + detail.getAdresse()); 
							//System.out.println(detail.getVorname());
					}

					
					
				} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case "r"	:
				System.out.println("Bitte Vornamen oder Nachnamen des Kontaktes eingeben, der entfernt werden soll:");
				input = SupportLine.InputReader();
				try {
					meinAdressbuch.removeDetails(input);
				} catch (ParamKeyIsNullException | ParamKeyIsEmptyException
						| KeinKontaktException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;

				
			}
			
		}
	}
	
	
	private static void testdata(){
		System.out.println(meinAdressbuch.getNumberOfEntries());
		System.out.println("1 | ERFOLGREICH");
		try {
			meinAdressbuch.addDetails(new ContactDetails("Fox", "Peter", "Fuchsbau"));
			System.out.println("2 | ERFOLGREICH");
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException | ParamContactIsEmptyException e1) {
			e1.getMessage();
			System.out.println("TEST FEHLERHAFT");
		}
		try {
			meinAdressbuch.addDetails(new ContactDetails("", "Ralf", "Hauptstrasse 1"));
			System.out.println("TEST FEHLERHAFT");
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException | ParamContactIsEmptyException e1) {
			e1.getMessage();
			System.out.println("3 | ERFOLGREICH");
		}
		try {
			meinAdressbuch.addDetails(new ContactDetails("Hans", "Peter", "Fuchsbau 1"));
			System.out.println("TEST FEHLERHAFT");
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException | ParamContactIsEmptyException e1) {
			e1.getMessage();
			System.out.println("4 | ERFOLGREICH");
		}
		try {
			meinAdressbuch.changeDetails("Fox", new ContactDetails("Frank", "Montana", "Gangway 1"));
			System.out.println("5 | ERFOLGREICH");
		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException
				| DoppelException | ParamContactIsNullException | ParamContactIsEmptyException | KeinKontaktException e1) {
			e1.getMessage();
			System.out.println("TEST FEHLERHAFT");
		}
		try {
			meinAdressbuch.changeDetails("Fox", new ContactDetails("Frank", "Montana", "Gangway 1"));
			System.out.println("TEST FEHLERHAFT");
		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException
				| DoppelException | ParamContactIsNullException | ParamContactIsEmptyException | KeinKontaktException e1) {
			e1.getMessage();
			System.out.println("6 | ERFOLGREICH");
		}
		try {
			for(ContactDetails result : meinAdressbuch.search("Mon")){
			System.out.println(result.getVorname());}
			System.out.println("7 | ERFOLGREICH");
		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
			e.getMessage();
			System.out.println("TEST FEHLERHAFT");
		}
		try {
			for(ContactDetails result : meinAdressbuch.search(null)){
			System.out.println(result.getVorname());}
			System.out.println("TEST FEHLERHAFT");
		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
			e.getMessage();
			System.out.println("8 | ERFOLGREICH");
		}
		System.out.println(meinAdressbuch.getNumberOfEntries());
		System.out.println("9 | ERFOLGREICH");
		try {
			meinAdressbuch.addDetails(null);
		} catch (DoppelException | ParamKeyIsNullException
				| ParamKeyIsEmptyException | ParamContactIsNullException | ParamContactIsEmptyException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		
		
		
//		ContactDetails a = new ContactDetails("Fox", "Peter","Fuchsbau 1");		
//		ContactDetails b = new ContactDetails("Walker", "Paul","Catwalk 1");
//		ContactDetails c = new ContactDetails("Walfred", "PJ","Hood 1");
//		a.setAdresse("Fuchsbau 4");
//		a.setAdresse("Fuchsbau 5");
//		b.setAdresse("Catwalk 99");
//		
//		try {
//			meinAdressbuch.addDetails(a);
//		} catch (DoppelException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		try {
//			meinAdressbuch.addDetails(b);
//		} catch (DoppelException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		try {
//			meinAdressbuch.addDetails(c);
//		} catch (DoppelException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		
//		try {
//			System.out.println(meinAdressbuch.getDetails("Peter").getAdresse());
//		} catch (KeinKontaktException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		try {
//			System.out.println(meinAdressbuch.getDetails("Paul").getAdresse());
//		} catch (KeinKontaktException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		
//		try {
//			meinAdressbuch.changeDetails("Fox",new ContactDetails("Montana", "Frank", "Gangway 6"));
//		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException
//				| DoppelException e) {
//			System.out.println(e);
//		}
//		//System.out.println(meinAdressbuch.getDetails("PeterFox").getAdresse());
//		//meinAdressbuch.removeDetails("PeterFox");
//		
//		try {
//			System.out.println(meinAdressbuch.getDetails("Montana").getAdresse());
//		} catch (KeinKontaktException | ParamKeyIsNullException
//				| ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		//System.out.println(meinAdressbuch.getDetails("PeterFox").getAdresse());
//		try {
//			meinAdressbuch.removeDetails("Frank");
//		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		
//		try {
//			meinAdressbuch.search("Walker");
//		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		try {
//			for(ContactDetails result : meinAdressbuch.search("Wa")){
//				System.out.println(result.getVorname());
//				System.out.println(result.getName());
//			}
//		} catch (ParamKeyIsNullException | ParamKeyIsEmptyException e) {
//			System.out.println(e);
//		}
//		
	}
	
}
