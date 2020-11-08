package Words;

/*
 *  @author Luigi Yebra
 *  @version v1.0-alpha
 *  @since 2020-11-06
 *  
 *  
 */
public class WordObj implements Comparable<WordObj> {
	
	/*
	 * word of the Object
	 */
	String subject;
		
	
	 WordObj(String subject){
		
		try {
			subject = subject.toLowerCase();
			subject = subject.trim();
			this.subject = subject;
			
		}catch(NullPointerException e) {
			throw new IllegalArgumentException("Constructor failed, it needs String");
		}
		
	}
	 
	 /*
	  * @return Word given to the Object
	  */
	public String getWord(){
		return subject;
	}
	
	
	@Override
	public int compareTo(WordObj o) {
		int result =  this.compareTo(o);
		//assert
		if(result == 0) {
			assert this.equals(o) :
				this.getClass().getSimpleName() + ": compareTo inconsistent with Equals.";
		}	
		return result;
	}
	
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.getWord().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		if(that == null) return false;
		WordObj test = (WordObj)that;
		if(this.getWord() != test.getWord()) return false;
		if(getClass() != that.getClass()) return false;
		return true;
	}
	
//	public static void main(String[] args) {
//		WordObj steve = new WordObj("");
//		WordObj erwin = new WordObj("");
//		System.out.println(steve.equals(erwin));
//	}
}
