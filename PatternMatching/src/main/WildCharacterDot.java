package main;

public class WildCharacterDot implements PatternMatch{
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
		if(nextHandler==null) 
			return position;
		
		if(nextHandler.handleRequest(position+1,inputString)!=-1)
			return position;
		
		return -1;
	}
	
}
