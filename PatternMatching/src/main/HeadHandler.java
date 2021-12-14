package main;

public class HeadHandler implements PatternMatch{
	PatternMatch nextHandle;
	char currentCharacter;
	
	public HeadHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandle) {
		this.nextHandle = nextHandle;
	}
	
	public char getCharacter() {
		return this.currentCharacter;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		int result = -1;
		if(currentCharacter == '*' || currentCharacter == '.') {
			result = nextHandle.handleRequest(0, inputString);		
		}
		else {
			for(int i=0;i<inputString.length();i++) {
				if(currentCharacter == inputString.charAt(i)) {
					result = nextHandle.handleRequest(i, inputString);
					if(result != -1)
						return result;
				}
			}
		}
		return result;
	}
}
