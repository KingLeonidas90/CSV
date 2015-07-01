package application;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Callback;
import AdressBook.ContactDetails;

public class ObservableContactDetails extends ContactDetails {
	private StringProperty nameProperty ;
	private StringProperty vornameProperty;
	private StringProperty adresseProperty;
	

	public ObservableContactDetails(String vorname, String name, String adresse) {
		// constructor , super ruft alte ContactDetails mit auf. 
		super(vorname, name, adresse);
		
		nameProperty = new SimpleStringProperty(name);
		vornameProperty = new SimpleStringProperty(vorname);
		adresseProperty = new SimpleStringProperty(adresse);
		
		
		
		
		
	}
	
	//Returns
	public static Callback<ObservableContactDetails, Observable[]> getObsContactDetails() {
		   return (ObservableContactDetails p) -> new Observable[]{p.nameProperty, p.vornameProperty, p.adresseProperty};
		}
	


public StringProperty getNameProperty(){return nameProperty;}
public void setName(String nachname){nameProperty.set(nachname);}

public StringProperty getVornameProperty(){return vornameProperty;}
public void setVorname(String vorName){vornameProperty.set(vorName);}

public StringProperty getAdresseProperty(){return adresseProperty;}
public void setAdresse(String anschrift) {adresseProperty.set(anschrift);}

//public String toString() {
//
//    return vornameProperty.getValue();
//}


}
