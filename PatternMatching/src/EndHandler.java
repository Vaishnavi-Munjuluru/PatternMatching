
public class EndHandler implements PatternMatch{
	
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public char getCharacter() {
		return Character.MIN_VALUE;
	}
	
	@Override
	public int handleRequest(int position, String str) {
		return position;
	}
}
