package patternhandlers;

public interface PatternMatch {
	public void setNextChain(PatternMatch nextChain);
	public int handleRequest(int position, String inputString);
}
