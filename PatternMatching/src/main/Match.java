package main;

import patternhandlers.*;

/**
 * 
 * @author Vaishnavi Munjuluru
 * RED ID: 827140386
 * Assignment 4
 *
 */
public class Match {
	
	String pattern;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * It creates objects for the characters of pattern with respective handler type and maps the previous character handler 
	 * to the next character handler starting from the Head Handler to create the chain of objects.
	 * It passes the first index and the target string to the handleRequest method of head to perform pattern matching as per the chain.
	 * 
	 * @param inputString
	 * @return returns the index of the first pattern occurrence there is a match. 
	 * Else it returns -1 as if there is no match
	 */
	public int findFirstIn(String inputString) {
		
		char[] inputCharacters = new char[pattern.length()];
		PatternMatch headHandler;
		PatternMatch previousHandler;
		PatternMatch currentHandler;
		
		inputCharacters = pattern.toCharArray();
		headHandler = new HeadHandler(inputCharacters[0]);
		previousHandler = headHandler;

		for(int i=0; i< inputCharacters.length; i++) {
			if(inputCharacters[i] == '*') {
				currentHandler = new AsteriskHandler(inputCharacters[i]);
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
			else if(inputCharacters[i] == '.') {
				currentHandler = new DotHandler(inputCharacters[i]);
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
			else {
				currentHandler = new AlphabetsHandler(inputCharacters[i]);
				previousHandler.setNextChain(currentHandler);
				previousHandler = currentHandler;
			}
		}
		return headHandler.handleRequest(0, inputString);
	}	
}
