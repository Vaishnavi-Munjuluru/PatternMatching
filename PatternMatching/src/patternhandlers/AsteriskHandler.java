package patternhandlers;

public class AsteriskHandler implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public AsteriskHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	/**
	 * The character Asterisk should contain zero or more characters in place of it in the given pattern string.
	 * This handle method iterates till the end of target string and finds if the pattern exist. 
	 * 
	 * @param int position (location)
	 * @param String inputString (target String)
	 * @return If it finds the match, it returns the position (success)
	 * Else it returns -1 (failure)
	 */
	@Override
	public int handleRequest(int position, String inputString) {
		int currentPosition = position;
		if(nextHandler == null)
			return position;
		position++;
		while(position < inputString.length()) {
			if(nextHandler.handleRequest(position,inputString)!=-1)
				return currentPosition;
			position++;
		}
		return -1;
	}
}
