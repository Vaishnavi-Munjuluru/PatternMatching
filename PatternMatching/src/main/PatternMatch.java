package main;

public interface PatternMatch {
	public void setNextChain(PatternMatch nextChain);
	public int handleRequest(int position, String str);
	public char getCharacter();
}
