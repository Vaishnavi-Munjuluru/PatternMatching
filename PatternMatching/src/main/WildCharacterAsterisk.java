package main;

public class WildCharacterAsterisk implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	@Override
	public void setCharacter(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public char getCharacter() {
		return currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		int temp = position;
		if(nextHandler == null)
			return position;
		
		while(position < inputString.length()) {
			if(inputString.charAt(position) == nextHandler.getCharacter() && nextHandler.handleRequest(position,inputString)!=-1)
				return temp;
			position++;
			if(position == inputString.length())
				return -1;
		}
		return -1;
	}

}
