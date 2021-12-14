package main;

public class HeadHandler implements PatternMatch{
	PatternMatch nextHandle;
	char currentCharacter;
	
	@Override
	public void setCharacter(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandle) {
		this.nextHandle = nextHandle;
	}
	
	public char getCharacter() {
		return currentCharacter;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		if(currentCharacter == '*' || currentCharacter == '.') {
			return nextHandle.handleRequest(0, inputString);		
		}
		
		for(int i=0;i<inputString.length();i++) {
			if(currentCharacter == inputString.charAt(i)) {
					return nextHandle.handleRequest(i, inputString);
			}
		}
		return -1;
	}
}
