package Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  @author Luigi Yebra
 *  @version v1.0-alpha
 *  @since 2020-11-06
 *  
 *  
 */
final public class WordRecord {
	/*
	 * The array that will hold this particular word bank
	 */
	public WordObj[] word;
	/*
	 * The name of the word Bank
	 */
	String title;
	/*
	 * size of the word bank
	 */
	int length;
	
	/**
	 * Class constructor
	 * @param  title  is the name of the word bank
	 * @param  length  the initial size of the word bank
	 * @throws IllegalArgumnetException, if given the wrong input
	 * 
	 */
	public WordRecord( String title, int length) {
		
//		assert length > 0;
//		assert title != null;
		if(title ==null || length <= 0) throw new IllegalArgumentException();
		title.trim();
		this.word = new WordObj[length];
		this.title = title;
		this.length = length;
	}
	/*
	 * @return gives the size of array
	 */
	public int getSize() {
		return this.length;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(title + " [ <WordObj> [ ");

		for(int i =0; i < length; i++) {
			try {
				output.append(word[i].getWord());
				if(i != length-1) output.append(", ");
			}catch(NullPointerException e) {
				output.append("null");
				if(i != length-1) output.append(", ");
				continue;
			}
		}
		output.append(" ], length = " + length +"] " );
		return output.toString();
	}
	/**
	 * @return a new copy of WordRecord
	 */
	public WordRecord getCopy() {
		assert this != null;
		
		return new WordRecord(title,length);
	}
	
	/**
	 * Adds another word to the word bank
	 * @param accepts Strings
	 * 
	 */
	
	public void addWord(String addd) {
		assert addd != null;
		
		
		int curElem = this.countElements();
		int index = curElem;
		if(curElem >= (length/2)) {
			this.length += (length/2);
			WordObj[] noob = Arrays.copyOf(word, length);
			this.word = noob;
		}
		word[index] = new WordObj(addd); 
		
	}
	
	/**Counts how many elements in the word bank
	 * without counting the extra space
	 * 
	 * @return int
	 */
	public int countElements() {
		assert this != null;
		
		int count = 0;
		for(int i = 0; i<word.length; i++) {
			if(word[i] instanceof WordObj) count+=1;
		}
		return count;
	}
	
	
	/**Allows user to remove a word in the word bank
	 * @param input a String that is contained in the word bank
	 */
	public void removeWord(String wrd) {
		
		List<WordObj> tmp = new ArrayList<>(Arrays.asList(word));
		List<WordObj> tmp2 = tmp.stream()
		.filter(x -> x != null).collect(Collectors.toList());
		tmp2 = tmp2.stream()
				.filter(x -> !x.getWord().equals(wrd)).collect(Collectors.toList());
		WordObj[] tmp3;
		if(this.countElements() < length/2 ) {
			tmp3 = new WordObj[this.countElements()];
			this.length = this.countElements();
		}else {
			tmp3 = new WordObj[length];
		}
		
		tmp3 = tmp2.toArray(tmp3);
		this.word = tmp3;
	}
	
	/**
	* Shuffle the contents in the word bank
	*/
	public void shuffle() {
		assert this != null;
		
		List<WordObj> result = Arrays.asList(this.word);
		List<WordObj> temp = result.stream()
				.filter(x -> x != null)
				.collect(Collectors.toList());

		Collections.shuffle(temp);
				
		WordObj[] newLst = new WordObj[length];		
		newLst = temp.toArray(newLst);

		this.word = newLst;
	}
}
