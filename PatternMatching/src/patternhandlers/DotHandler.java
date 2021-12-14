package patternhandlers;

public class DotHandler implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public DotHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	/**
	 * The character dot should contain any single character in place of it in the given pattern string.
	 * This handle method finds the next character of the given position and matches with the character of the target string.
	 * 
	 * @param int position (location)
	 * @param String inputString (target String)
	 * @return If there is a match (success) it returns the position value. 
	 * Else it returns -1 (failure).
	 */
	@Override
	public int handleRequest(int position, String inputString) {
		if(nextHandler==null) 
			return position;
		
		if(nextHandler.handleRequest(position+1,inputString)!=-1)
			return position;
		
		return -1;
	}
	
}
