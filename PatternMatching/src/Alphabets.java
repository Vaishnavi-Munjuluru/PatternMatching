
public class Alphabets extends BaseHandler{
	char currentCharacter;
	public Alphabets(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString,String pattern, int patternPosition) {
		if(position+1 <inputString.length() && patternPosition+1<pattern.length()) {
			int res = nextHandler.handleRequest(position+1, inputString, pattern, patternPosition+1);
			if(res!=-1)
				return position;
		}
		if(patternPosition+1 == pattern.length()) {
			return position;
		}	
		return -1;
	}

}
