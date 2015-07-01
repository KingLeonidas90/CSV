package AdressBook;

public interface AddressBookInterface {
	
	public ContactDetails getDetails(String key);
	
	public boolean keyInUse(String key);
	
	public void addDetails(ContactDetails details);
	
	public void changeDetails(String oldKey, ContactDetails details);
	
	public int getNumberOfEntries();
	
	public void removeDetails(String key);

	public ContactDetails[] search(String keyPrefix);
}
