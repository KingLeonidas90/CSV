package AdressBook;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;


public class AddressBook implements AdressBookExceptionsInterface {
	private TreeMap<String, ContactDetails> meinetreemap = new TreeMap<>();

	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#getDetails(java.lang.String)
	 */
	@Override
	public ContactDetails getDetails(String key) throws KeinKontaktException, ParamKeyIsNullException, ParamKeyIsEmptyException {
		// Prüfen ob Key schon in TreeMap
		if (!this.keyInUse(key))
			throw new KeinKontaktException("Kontakt nicht vorhanden");
		return meinetreemap.get(key);
	}

	
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#keyInUse(java.lang.String)
	 */
	@Override
	public boolean keyInUse(String key) throws ParamKeyIsNullException, ParamKeyIsEmptyException {
		if (key == null) throw new ParamKeyIsNullException ("Der Key ist null");  
		else if (key.isEmpty()) throw new ParamKeyIsEmptyException("Der Key ist leer");
		else return meinetreemap.containsKey(key);
	}

	
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#addDetails(ContactDetails)
	 */
	@Override
	public void addDetails(ContactDetails details) throws DoppelException, ParamKeyIsNullException, ParamKeyIsEmptyException, ParamContactIsNullException, ParamContactIsEmptyException {
		// Prüfen auf vorhandensein beider Schlüssel
		if (details == null) throw new ParamContactIsNullException("ContactDetails ist null");
		if (details.equals("")) throw new ParamContactIsEmptyException("ContactDetails ist Empty");
		if (this.keyInUse(details.getVorname())) throw new DoppelException("Der Vorname ist schon vorhanden");
		else if (this.keyInUse(details.getName())) throw new DoppelException("Der Nachname ist schon vorhanden");
		else
		// zwei Einträge mit verschiedenen Schlüsseln
		meinetreemap.put(details.getName(), details);
		meinetreemap.put(details.getVorname(), details);
	}

	
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#changeDetails(java.lang.String, ContactDetails)
	 */
	@Override
	public void changeDetails(String oldKey, ContactDetails details) throws ParamKeyIsNullException, ParamKeyIsEmptyException, DoppelException, ParamContactIsNullException, ParamContactIsEmptyException, KeinKontaktException {
		if (oldKey == null) throw new ParamKeyIsNullException ("Der alte Key ist null"); 
		else if (oldKey.isEmpty()) throw new ParamKeyIsEmptyException("Der alte Key ist leer"); 
			// alten EIntrag entfernen
			this.removeDetails(oldKey);
			// neuer Eintrag
			this.addDetails(details);
		}


	
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#getNumberOfEntries()
	 */
	@Override
	public int getNumberOfEntries() {
		if ((meinetreemap.size() % 2) > 0) throw new InkonsistentException("Adressbuch ist fehlerhaft, ungerade Anzahl von Einträgen");
		// Rückgabe der Größe geteilt durch zwei,
		// da alle Details doppelt eingetragen sind
		return meinetreemap.size() / 2;
	}
	
	/* (non-Javadoc)
	 * @see 
	 */
	// gibt alle Keys aus dem Adressbuch zurück
	public Set<String> allKeys() {
		return meinetreemap.keySet();
	}
	//gibt alle ContactDetails Objekte aus dem Adressbuch zurück
	public Collection<ContactDetails> allDetails() {
		return meinetreemap.values();
	}
	
	
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#removeDetails(java.lang.String)
	 */
	@Override
	public void removeDetails(String key) throws ParamKeyIsNullException, ParamKeyIsEmptyException, KeinKontaktException {
		// prüfen ob Key überhaupt vorhanden
		if(key == null)	throw new ParamKeyIsNullException("Lösch-Key war null");
		if(key.isEmpty())	throw new ParamKeyIsEmptyException("Lösch-Key war leer");
		if (this.keyInUse(key)){
			// Vorname und Name aus den Details lesen um beide EInträge
			// entfernen zu können
			String name = meinetreemap.get(key).getName();
			String vorname = meinetreemap.get(key).getVorname();
			meinetreemap.remove(name);
			meinetreemap.remove(vorname);			
		}
		else throw new KeinKontaktException("Kein Kontakt zum löschen vorhanden");
			

			
			
		}
	/* (non-Javadoc)
	 * @see AdressBookInterfaceException#search(java.lang.String)
	 */
	@Override
	public ContactDetails[] search(String keyPrefix) throws ParamKeyIsNullException, ParamKeyIsEmptyException {
		if (keyPrefix == null) throw new ParamKeyIsNullException ("Der Such-Key ist null"); 
		else if (keyPrefix.isEmpty()) throw new ParamKeyIsEmptyException("Der Such-Key ist leer"); 
		List<ContactDetails> found = new ArrayList<ContactDetails>();
		for (String key : meinetreemap.keySet()) {
			if (key.contains(keyPrefix)) {
				found.add(meinetreemap.get(key));
			}
		}
		return (found.toArray(new ContactDetails[found.size()]));
	}
}
