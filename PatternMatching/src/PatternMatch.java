
public interface PatternMatch {
	void setNextChain(PatternMatch nextChain);
	int handleRequest(int position, String str,String pm, int pmp);
}
