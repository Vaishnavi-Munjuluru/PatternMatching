
public class WildCharacterAsterisk implements PatternMatch{

	char currentCharacter;
	public WildCharacterAsterisk(char currentCharacter) {
		this.currentCharacter = currentCharacter;
		System.out.println("WildCharacterAsterisk");
	}
	
	public char getCharacter() {
		return this.currentCharacter;
	}
	
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		int temp = position;
			/*if(pattern.length() == patternPosition+1)
				return position;*/   //this end case should be written in the endhandler. all the end condtions should be collectively written in endhandler
		if(nextHandler == null) {
			return position;
		}
		
		while(position < inputString.length()) {
				if(nextHandler!=null) {
					if(inputString.charAt(position) == nextHandler.getCharacter()) {
					int res = nextHandler.handleRequest(position,inputString);	
					if(res!=-1)
						return temp;
				}
				position++;
			
			if(position == inputString.length())
				return -1;
				}
		}
		return -1;
	}

}
