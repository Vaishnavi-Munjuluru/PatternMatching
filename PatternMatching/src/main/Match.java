package main;

public class Match {
	
	String pattern;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	public int findFirstIn(String inputString) {
		PatternMatch head;
		PatternMatch tempObj;
		
		char[] ch = new char[pattern.length()];
		ch = pattern.toCharArray();
		
		head = new HeadHandler(ch[0]);
		tempObj = head;

		for(int i=0; i< ch.length; i++) {
			if(ch[i] == '.') {
				PatternMatch dotObject = new WildCharacterDot(ch[i]);
				tempObj.setNextChain(dotObject);
				tempObj = dotObject;
			}
			else if(ch[i] == '*') {
				PatternMatch asteriskObject = new WildCharacterAsterisk(ch[i]);
				tempObj.setNextChain(asteriskObject);
				tempObj = asteriskObject;
			}
			else {
				PatternMatch alphabetObject = new Alphabets(ch[i]);
				tempObj.setNextChain(alphabetObject);
				tempObj = alphabetObject;
			}
		}
		
		return head.handleRequest(0, inputString);
	}
		
}
