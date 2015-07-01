package AdressBook;


public class ContactDetails {
private String vorname = null;
private String name = null;
private String adresse = null;

//Konstruktor
	public ContactDetails(String vorname,String name,String adresse) {
		this.vorname = vorname;
		this.name = name;
		this.adresse = adresse;
	}
	
	
	
	//get Methode
	
	


	public String getName() {
		return name;
	}
	public String getVorname() {
		return vorname;
	}
	public String getAdresse() {
		return adresse;
	}

	//set-Methode

	public void setName(String name) {
		this.name = name;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
