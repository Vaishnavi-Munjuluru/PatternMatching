package main;

public interface PatternMatch {
	public void setNextChain(PatternMatch nextChain);
	public int handleRequest(int position, String inputString);
	public void setCharacter(char currentCharacter);
	public char getCharacter();
}
