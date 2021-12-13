
public class Alphabets extends BaseHandler{
	char currentCharacter;
	public Alphabets(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	protected PatternMatch nextHandler;
	
	public char getCharacter() {
		return this.currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
		System.out.println("Alphabets");
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		if(position+1 < inputString.length() && currentCharacter == inputString.charAt(position)) {
			int res = nextHandler.handleRequest(position+1, inputString);
			if(res!=-1)
				return position;
		}
		/*if(patternPosition+1 == pattern.length()) {
			return position;  //not really sure of this condition
		}*/	
		return -1;
	}

}
