package Words;

import java.util.Arrays;

final public class WordRecord {
	
	WordObj[] word;
	String title;
	int length;
	
	public WordRecord(WordObj[] word, String title, int length) {
		assert word!= null;
		assert length > 0;
		assert title != null;
		
		this.word = new WordObj[length];
		this.title = title;
		
	
	}
	
	
	
	@Override
	public String toString() {
		return "WordRecord [word=" + Arrays.toString(word) + ", title=" + title + ", length=" + length + "]";
	}
	
	public WordRecord getCopy() {
		return new WordRecord(word,title,length);
	}

	
}
