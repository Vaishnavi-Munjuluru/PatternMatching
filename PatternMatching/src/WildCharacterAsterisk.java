
public class WildCharacterAsterisk extends BaseHandler{

	char currentCharacter;
	public WildCharacterAsterisk(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString,String pattern, int patternPosition) {
		if(pattern.charAt(patternPosition) == '*') {
			if(pattern.length() == patternPosition+1)
				return position;
			while(position < inputString.length()) {
				if(inputString.charAt(position) == pattern.charAt(patternPosition+1)) {
					int res = nextHandler.handleRequest(position,inputString,pattern,patternPosition+1);	
					if(res!=-1)
						return position;
				}
				position++;
			}
			if(position == inputString.length())
				return -1;
		}
		return -1;
	}

}
