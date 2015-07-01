package SupportLine;
import java.util.ArrayList;
import java.util.Random;


public class Responder {
	private ResponseHashMap responseMap;
	private ArrayList<String> defaultList;
	private Random randomGenerator = new Random();
	
	public Responder() {
		responseMap = new ResponseHashMap();
		fillResponseMap();
		defaultList = new ArrayList<String>();
		fillDefaultList();
	}
	private void fillDefaultList() {
		defaultList.add("was ist das Problem?");
		defaultList.add("was verstehst du daran nicht?");
		
	}
	private void fillResponseMap() {
		responseMap.put("slow", "Hierbei handelt es sich wahrscheinlich um ein Hardware Problem." + "Ein Hardware Upgrade sollte das Problem beheben");
		responseMap.put("bug", "Danke für die Meldung dieses Fehlers" + "Unser Entwicklungsteam arbeitet bereits an einer Lösung!");
		responseMap.put("slow", "Hierbei handelt es sich wahrscheinlich um ein Hardware Problem." + "Ein Hardware Upgrade sollte das Problem beheben");
	}
	public String generateResponse(String keyword) {
		String response = responseMap.get(keyword);
		if (response != null) return response;
		return pickDefaultResponse();
	}
	private String pickDefaultResponse() {
		int nextindex = randomGenerator.nextInt(defaultList.size());
		return defaultList.get(nextindex);
	}
}
