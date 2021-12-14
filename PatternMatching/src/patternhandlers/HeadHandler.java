package patternhandlers;

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
	
	/**
	 * This is the handle method for the first object in the chain. It matches the first character
	 * in the target string and pass the target string and the location of the target string to the next object of the chain.
	 * 
	 * @param int position (location)
	 * @param String inputString (target String)
	 * @return If the match position is found, the position found by the rest of the chain will be returned
	 * Else it returns -1 as there is no match.
	 */
	
	@Override
	public int handleRequest(int position, String inputString) {
		if(currentCharacter == '*' || currentCharacter == '.') {
			return nextHandle.handleRequest(0, inputString);		
		}
		
		for(int i=0;i<inputString.length();i++) {
			if(currentCharacter == inputString.charAt(i) && nextHandle.handleRequest(i, inputString)!=-1) 
				return nextHandle.handleRequest(i, inputString);
		}
		return -1;
	}
}
