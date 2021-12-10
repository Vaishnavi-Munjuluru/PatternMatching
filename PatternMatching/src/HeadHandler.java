
public class HeadHandler extends BaseHandler{
	protected PatternMatch nextHandle;
	public void setNextChain(PatternMatch nextHandle) {
		this.nextHandle = nextHandle;
	}
	
	@Override
	public int handleRequest(int position, String inputString, String pattern, int patternPosition) {
		int result = -1;
		if(pattern.charAt(0) == '*' || pattern.charAt(0) == '.') {
			result = nextHandle.handleRequest(0, inputString, pattern, 0);		
		}
		else {
			for(int i=0;i<inputString.length();i++) {
				if(pattern.charAt(0) == inputString.charAt(i)) {
					result = nextHandle.handleRequest(i, inputString, pattern, 0);
				}
			}
		}
		
		return result;
	}
}
