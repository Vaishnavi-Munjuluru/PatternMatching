
public interface PatternMatch {
	void setNextChain(PatternMatch nextChain);
	void handleRequest();
}
