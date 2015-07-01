package SupportLine;

import java.util.ArrayList;
import java.util.List;


public class ResponseMapArrayList implements ResponseMapInterface {
	private ArrayList<MapElement> responseList = new ArrayList<>();// responselist ist die liste, die die ganzen Mapelemente enthält 
	@Override
	public String get(String key) {
		for( MapElement ergebnisse : responseList  )
			if(ergebnisse.equals(key)){
		
		return ergebnisse.value;
			}
		return null;
	}

	@Override
	public void put(String key, String msg) {
		if (allKeys().contains(key)){throw new RuntimeException();}
		MapElement newMap = new MapElement(msg, msg);
			newMap.key=(key);
			newMap.value=(msg);
			responseList.add(newMap);
			//if key in use throw Exception
		}
		
	

	@Override
	public boolean contains(String key) {
		for( int i=0; i< responseList.size(); i++){
			MapElement newMap = responseList.get(i);
		if (newMap.equals(key)){
		return true;}
		
		}
		return false;
	}

	@Override
	public List<String> allKeys() {	// Typ = Liste in Form eines Strings mit der variablen allkeys
		List<String> keys = new ArrayList<>(); // neue Liste erzeugen als Objekt
		for(MapElement newMap : responseList) // 
			keys.add(newMap.key);
		return keys;
	}

	@Override
	public int size() {
		
		return responseList.size();
	}

}
