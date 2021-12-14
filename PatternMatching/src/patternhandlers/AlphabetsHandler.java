package patternhandlers;

public class AlphabetsHandler implements PatternMatch{
	PatternMatch nextHandler;
	char currentCharacter;
	
	public AlphabetsHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}

	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	/**
	 * This handle method matches the alphabet character till the end of the inputString. 
	 * @param int position (location)
	 * @param String inputString (target String)
	 * @return  If the match is found, it returns the position (success)
	 * Else it returns -1 (failure)
	 */
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
