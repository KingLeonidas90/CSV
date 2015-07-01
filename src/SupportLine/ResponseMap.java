package SupportLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


public class ResponseMap implements ResponseMapInterface {
	private TreeMap<String, String> meinetreemap = new TreeMap<String, String>();
	//private ArrayList<MapElement> responseList = new ArrayList<>();// responselist ist die liste, die die ganzen Mapelemente enthält 
	@Override
	public String get(String key) {

		return meinetreemap.get(key);
	}

	@Override
	public void put(String key, String msg) {
		if(meinetreemap.containsKey(key)) {throw new RuntimeException();}
		meinetreemap.put(key, msg);
		
//	if (allKeys().contains(key)){throw new RuntimeException();}
//		MapElement newMap = new MapElement();
//			newMap.key=(key);
//			newMap.value=(msg);
//			responseList.add(newMap);
//			//if key in use throw Exception
		}
		
	

	@Override
	public boolean contains(String key) {
			return meinetreemap.containsKey(key);
		
		
		
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
		 keyliste.addAll(meinetreemap.keySet());
		 //return keyliste;
		 return new ArrayList<String>(meinetreemap.keySet());
		
		  //meinehashmap.keySet();
//		// Typ = Liste in Form eines Strings mit der variablen allkeys
//		List<String> keys = new ArrayList<>(); // neue Liste erzeugen als Objekt
//		for(MapElement newMap : responseList) // 
//			keys.add(newMap.key);
//		return keys;
	}

	@Override
	public int size() {
		
		return meinetreemap.size();
	}

}
