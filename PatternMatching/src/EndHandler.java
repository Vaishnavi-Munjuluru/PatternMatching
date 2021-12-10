
public class EndHandler implements PatternMatch{
	
	protected PatternMatch nextHandler;
	
	@Override
	public void setNextChain(PatternMatch nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public int handleRequest(int position, String str,String pm, int pmp) {
		return position;
	}
}
