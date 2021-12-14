package main;

public class WildCharacterDot implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public WildCharacterDot(char currentCharacter) {
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
		if(nextHandler==null) {
			return position;
		}
		else {
			int res = nextHandler.handleRequest(position+1,inputString);
			if(res!=-1)
				return position;
		}
		return -1;
	}

	
}
