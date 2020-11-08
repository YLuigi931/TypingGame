package Words;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

final public class WordRecord {
	
	WordObj[] word;
	String title;
	int length;
	
	public WordRecord( String title, int length) {
		
		assert length > 0;
		assert title != null;
		
		this.word = new WordObj[length];
		this.title = title;
		this.length = length;
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
	
	public WordRecord getCopy() {
		assert this != null;
		
		return new WordRecord(title,length);
	}
	
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
	
	public int countElements() {
		assert this != null;
		
		int count = 0;
		for(int i = 0; i<word.length; i++) {
			if(word[i] instanceof WordObj) count+=1;
		}
		return count;
	}
	
	public void removeWord(String wrd) {
		
		
	}
	
	/**
	* Registers the text to display in a tool tip.   The text 
	* displays when the cursor lingers over the component.
	*
	* @param text Shuffles the word Bank 
	* 
	*/
	public void shuffle() {
		assert this != null;
		
		
		List<WordObj> result = Arrays.asList(this.word);
		List<WordObj> temp = result.stream()
				.filter(x -> x != null)
				.collect(Collectors.toList());
		
//		temp.stream().forEach((WordObj) -> {
//			System.out.println(WordObj.getWord());
//		});
		
		Collections.shuffle(temp);
		
//		temp.stream().forEach((WordObj) -> {
//			System.out.println(WordObj.getWord());
//		});
				
		WordObj[] newLst = new WordObj[length];		
		newLst = temp.toArray(newLst);

		this.word = newLst;
		
//		assertFalse(Arrays.equals(this.word, newLst));

	}
	
	public static void main(String[] args) {
		WordRecord steve = new WordRecord("LOTR", 5);
		steve.word[0] = new WordObj("Gold");
//		steve.word[1] = new WordObj("NerF");
//		steve.word[2] = new WordObj("silver");
//		steve.word[3] = new WordObj("GOOGLE");
//		steve.word[4] = new WordObj("the      ");
		
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord(" Teen   ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord("Boat ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord(" Sponge   ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord("Waifu");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord(" NERF ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord("silver ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord(" THE   ");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.addWord("google");
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		steve.shuffle();
		System.out.println(steve.toString());
		System.out.println(steve.countElements());
		
	}
	
}
