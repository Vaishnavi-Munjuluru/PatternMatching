package main;

public class Match {
	
	String pattern;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	public int findFirstIn(String inputString) {
		
		char[] characterArray = new char[pattern.length()];
		PatternMatch head;
		PatternMatch previousHandler;
		PatternMatch currentHandler;
		
		characterArray = pattern.toCharArray();
		head = new HeadHandler();
		head.setCharacter(characterArray[0]);
		previousHandler = head;

		for(int i=0; i< characterArray.length; i++) {
			if(characterArray[i] == '*') {
				currentHandler = new WildCharacterAsterisk();
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
			else if(characterArray[i] == '.') {
				currentHandler = new WildCharacterDot();
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
			else {
				currentHandler = new Alphabets();
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
			currentHandler.setCharacter(characterArray[i]);
		}
		return head.handleRequest(0, inputString);
	}
		
}
