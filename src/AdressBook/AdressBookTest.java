package AdressBook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class AdressBookTest {
	// Adressbuch anlegen,
	static AddressBook meinAdressbuch;	
	static ContactDetails neuerKontakt = new ContactDetails("Sam", "Som", "Adresse1");
	//einen Kontakt für tests anlegen,
	@Before
	public void setupBefore() throws Exception {
		meinAdressbuch = new AddressBook();
		meinAdressbuch.addDetails(neuerKontakt);
	}

	//Test1 getDetails muss KeinKontaktException liefern
	@Test (expected = KeinKontaktException.class)
	public void testGetDetails () throws KeinKontaktException, ParamKeyIsNullException, ParamKeyIsEmptyException {
		meinAdressbuch.getDetails("nix");
	}
	
	//Test2 keyinUse muss ParamKeyIsNullException liefern
	@Test (expected = ParamKeyIsNullException.class)
	public void testkeyinuseNull () throws KeinKontaktException, ParamKeyIsNullException, ParamKeyIsEmptyException {
		meinAdressbuch.keyInUse(null);
	}
	
	//Test3 keyinUse muss ParamKeyIsEmptyException liefern
	@Test (expected = ParamKeyIsEmptyException.class)
	public void testkeyinuseEmpty () throws ParamKeyIsNullException, ParamKeyIsEmptyException{
		meinAdressbuch.keyInUse("");
	}

	//Test4 addDetails muss ParamContactIsNullException liefern
	@Test (expected = ParamContactIsNullException.class)
	public void testadddetailsNull () throws DoppelException, ParamKeyIsNullException, ParamKeyIsEmptyException, ParamContactIsNullException, ParamContactIsEmptyException{
		meinAdressbuch.addDetails(null);
	}
	
	//Test5 addDetails muss DoppelException liefern bei doppelt eingegebenen Vornamen
	@Test (expected = DoppelException.class)
	public void testadddetailsVornameDoppel () throws DoppelException, ParamKeyIsNullException, ParamKeyIsEmptyException, ParamContactIsNullException, ParamContactIsEmptyException{
		meinAdressbuch.addDetails(new ContactDetails("Peter", "Sam", "adr1"));
	}
	
	//Test6 addDetails muss DoppelException liefern bei doppelt eingegebenen Nachnamen
	@Test (expected = DoppelException.class)
	public void testadddetailsNachnameDoppel () throws DoppelException, ParamKeyIsNullException, ParamKeyIsEmptyException, ParamContactIsNullException, ParamContactIsEmptyException  {
		meinAdressbuch.addDetails(new ContactDetails("Pan", "Som", "adr2"));
	}
	
	//Test7 addDetails muss ParamKeyIsNullException liefern 
	@Test (expected = ParamKeyIsNullException.class)
	public void testchangeNull () throws ParamKeyIsNullException, ParamKeyIsEmptyException, DoppelException, ParamContactIsNullException, ParamContactIsEmptyException, KeinKontaktException{	
		meinAdressbuch.changeDetails(null, new ContactDetails("fail", "wrong", "street"));
	}
	
	//Test8 changeDetails muss ParamKeyIsEmptyException liefern 
	@Test (expected = ParamKeyIsEmptyException.class)
	public void testchangeEmpty () throws ParamKeyIsNullException, ParamKeyIsEmptyException, DoppelException, ParamContactIsNullException, ParamContactIsEmptyException, KeinKontaktException{
		meinAdressbuch.changeDetails("", new ContactDetails("fail", "wrong", "street"));
	}

	//Test9 getNumberofEntries muss 1 liefern 
	@Test
	public void TestgetNumberofEntries() {
		assertTrue(meinAdressbuch.getNumberOfEntries()==1);
		
	}
		
	//Test10 remove muss  ParamKeyIsNullException bei null liefern
	@Test (expected = ParamKeyIsNullException.class)
	public void testremoveNull() throws ParamKeyIsNullException, ParamKeyIsEmptyException, KeinKontaktException {		
		meinAdressbuch.removeDetails(null);
	}
	
	//Test11 remove muss  ParamKeyIsEmptyException bei null liefern
	@Test (expected = ParamKeyIsEmptyException.class)
	public void testremoveEmpty() throws ParamKeyIsNullException, ParamKeyIsEmptyException, KeinKontaktException {		
		meinAdressbuch.removeDetails("");
	}
	
	//Test12 search muss  ParamKeyIsNullException bei null liefern
	@Test (expected = ParamKeyIsNullException.class)
	public void testsearchNull() throws ParamKeyIsNullException, ParamKeyIsEmptyException {		
		meinAdressbuch.search(null);
	}
	
	//Test13 search muss  ParamKeyIsEmptyException bei "" liefern
	@Test (expected = ParamKeyIsEmptyException.class)
	public void testsearchEmpty() throws ParamKeyIsNullException, ParamKeyIsEmptyException {		
		meinAdressbuch.search("");
	}
	
	//Test14 prüfen auf Inkosistenz
	@Test (expected = KeinKontaktException.class)
	public void testremove() throws ParamKeyIsNullException, ParamKeyIsEmptyException, KeinKontaktException {		
		meinAdressbuch.removeDetails("Sam");
		assertNotEquals(neuerKontakt, meinAdressbuch.getDetails("Sam"));
	}
	
	
}
