package SupportLine;
import java.util.List;


public interface ResponseMapInterface {

	public String get(String key);
	//null, if key not found
	
	public void put (String key, String msg);
	// Exception if key in use
	
	public boolean contains(String key);
	
	public List<String> allKeys();
	
	public int size();
}
