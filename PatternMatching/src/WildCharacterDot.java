
public class WildCharacterDot extends BaseHandler{
	char currentCharacter;
	public WildCharacterDot(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString,String pattern, int patternPosition) {
		if(pattern.charAt(patternPosition) == '.') {
			int res = nextHandler.handleRequest(position+1,inputString,pattern,patternPosition+1);
			if(res!=-1)
				return position;
		}
		return -1;
	}
}
