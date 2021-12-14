package main;

public class Alphabets implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	@Override
	public void setCharacter(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public char getCharacter() {
		return this.currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		if(currentCharacter == inputString.charAt(position) && nextHandler == null) 
			return position;
		
		if(position+1 < inputString.length() && currentCharacter == inputString.charAt(position) && 
				nextHandler.handleRequest(position+1, inputString)!=-1) 
			return position;
			
		return -1;
	}

}
