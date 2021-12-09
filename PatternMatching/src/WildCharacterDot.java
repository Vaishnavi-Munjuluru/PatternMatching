
public class WildCharacterDot implements PatternMatch{

	
	@Override
	public void setNextChain(PatternMatch nextChain) {
		// TODO Auto-generated method stub
		PatternMatch p = new Alphabets();
		setNextChain(p);
	}

	@Override
	public void handleRequest() {
		
		
	}

}
