package SupportLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ResponseHashMap implements ResponseMapInterface {
	private HashMap<String, String> meinehashmap = new HashMap<String, String>();
	//private ArrayList<MapElement> responseList = new ArrayList<>();// responselist ist die liste, die die ganzen Mapelemente enthält 
	@Override
	public String get(String key) {

		return meinehashmap.get(key);
	}

	@Override
	public void put(String key, String msg) { 
		if(meinehashmap.containsKey(key)) throw new RuntimeException();
		meinehashmap.put(key, msg);
		
//	if (allKeys().contains(key)){throw new RuntimeException();}
//		MapElement newMap = new MapElement();
//			newMap.key=(key);
//			newMap.value=(msg);
//			responseList.add(newMap);
//			//if key in use throw Exception
		}
		
	

	@Override
	public boolean contains(String key) {
			return meinehashmap.containsKey(key);
		
		
		
//		for( int i=0; i< responseList.size(); i++){
//			MapElement newMap = responseList.get(i);
//		if (newMap.equals(key)){
//		return true;}
//		
//		}
//		return false;
	}

	@Override
	public List<String> allKeys() {
		 List<String> keyliste = new ArrayList<String>();
		 keyliste.addAll(meinehashmap.keySet());
		 //return keyliste;
		 return new ArrayList<String>(meinehashmap.keySet());
		
		  //meinehashmap.keySet();
//		// Typ = Liste in Form eines Strings mit der variablen allkeys
//		List<String> keys = new ArrayList<>(); // neue Liste erzeugen als Objekt
//		for(MapElement newMap : responseList) // 
//			keys.add(newMap.key);
//		return keys;
	}

	@Override
	public int size() {
		
		return meinehashmap.size();
	}

}
