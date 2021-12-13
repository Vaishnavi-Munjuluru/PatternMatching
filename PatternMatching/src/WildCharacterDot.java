
public class WildCharacterDot extends BaseHandler{
	char currentCharacter;
	public WildCharacterDot(char currentCharacter) {
		this.currentCharacter = currentCharacter;
		System.out.println("WildCharacterDot");
	}
	protected PatternMatch nextHandler;
	
	@Override
	public char getCharacter() {
		// TODO Auto-generated method stub
		return currentCharacter;
	}
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String inputString) {
		if(currentCharacter == '.') {
			int res = nextHandler.handleRequest(position+1,inputString);
			if(res!=-1)
				return position;
		}
		return -1;
	}

	
}
