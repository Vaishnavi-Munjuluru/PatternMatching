package main;

public class Alphabets implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public Alphabets(char currentCharacter) {
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
		if(currentCharacter == inputString.charAt(position) && nextHandler == null) {
			return position;
		}
		if(position+1 < inputString.length() && currentCharacter == inputString.charAt(position)) {
			if(nextHandler==null) {
				return position;
			}
			else {
				int	res = nextHandler.handleRequest(position+1, inputString);
				if(res!=-1)
					return position;
			}
		}
		return -1;
	}

}
