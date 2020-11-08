package Words;

import java.util.HashMap;
import java.util.Map;

/*
 *  @author Luigi Yebra
 *  @version v1.0-alpha
 *  @since 2020-11-06
 *  
 *  
 */
final class SetRecord {
	
	private final Map <String, WordRecord> data = new HashMap<String,WordRecord>();
	
	SetRecord(){ }
	
	/**
	 * @return the size of the data base of word banks
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Gets the a new copy of a specific word bank within the database
	 * @param accepts String
	 */
	public WordRecord get(String t) {
		return data.get(t).getCopy();
	}
	
	/**
	 * Accepts already made word banks in the database
	 * @param  ppp  is a WordBank object 
	 */
	public void addWordRecord(WordRecord ppp ) {
		assert ppp != null;
		data.put(ppp.title, ppp);
	}
	
	/**
	 * Removes a specific word bank
	 * @param  t  accepts String
	 */
	public void removeWordRecord(String t) {
		assert data.containsKey(t);
		data.remove(t);
	}
	
	
}
