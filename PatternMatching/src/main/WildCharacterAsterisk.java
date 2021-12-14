package main;

public class WildCharacterAsterisk implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public WildCharacterAsterisk(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	public char getCharacter() {
		return this.currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		int temp = position;
		if(nextHandler == null) {
			return position;
		}
		
		while(position < inputString.length()) {
			if(inputString.charAt(position) == nextHandler.getCharacter()) {
				int res = nextHandler.handleRequest(position,inputString);	
				if(res!=-1)
					return temp;
			}
			position++;
			if(position == inputString.length())
				return -1;
		}
		return -1;
	}

}
