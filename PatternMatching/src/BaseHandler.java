public abstract class BaseHandler implements PatternMatch{
	protected PatternMatch next;
	public void setNextChain(PatternMatch nextHandle) {
		this.next = nextHandle;
	}
	public int headHandler(int position, String str,String pm, int pmp) {
		int index = -1;
		/*if(pm.charAt(0) == '*' || pm.charAt(0) == '.') {
			boolean res = patternMatch(0,str,pm,0);
			if(res) {
				index=0;
			}
			
		}
		else {
		for(int i=0;i<str.length();i++) {
			if(pm.charAt(0) == str.charAt(i)) {
				boolean res = patternMatch(i,str,pm,0);
				if(res) {
					index = i;
					break;
				}
				else 
					continue;
					
			}
			}
		}*/
		return index;
		
	}
}
