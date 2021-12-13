
public interface PatternMatch {
	void setNextChain(PatternMatch nextChain);
	int handleRequest(int position, String str);
	char getCharacter();
}
