package Words;

import java.util.HashMap;
import java.util.Map;

final class SetRecord {
	
	private final Map <String, WordRecord> data = new HashMap<String,WordRecord>();
	
	SetRecord(){ }
	
	
	public int size() {
		return data.size();
	}
	
	public WordRecord get(String t) {
		return data.get(t).getCopy();
	}
	
	public void addWordRecord(WordRecord ppp ) {
		assert ppp != null;
		data.put(ppp.title, ppp);
	}
	
	public void removeWordRecord(String t) {
		assert data.containsKey(t);
		
		data.remove(t);
	}
	
	
}
