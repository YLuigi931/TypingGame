package Words;


class WordObj implements Comparable<WordObj> {
	
	String subject;
	
	WordObj(String subject){
		
		try {
			
			subject = subject.trim();
			this.subject = subject;
			
		}catch(NullPointerException e) {
			throw new IllegalArgumentException("Constructor failed, it needs String");
		}
		
	}

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
		if(getClass() != that.getClass()) return false;
		return false;
	}
	
}
