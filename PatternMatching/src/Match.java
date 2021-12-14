import java.util.LinkedList;
import java.util.List;

public class Match {
	
	String pattern;
	int result = -2;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	public int findFirstIn(String inputString) {
		PatternMatch head, tempObj;
		char[] ch = new char[pattern.length()];
		ch = pattern.toCharArray();
		head = new HeadHandler(ch[0]);
		//Initialize 1st character (Head)
		/*if(ch[0] == '.') {
			head = new WildCharacterDot(ch[0]);
		}
		else if(ch[0] == '*') {
			head = new WildCharacterAsterisk(ch[0]);
		}
		else {
			head = new Alphabets(ch[0]);
		}*/
		
		tempObj = head;
		//System.out.println(ch[0]);
		for(int i=0; i< ch.length; i++) {
			if(ch[i] == '.') {
				System.out.println(ch[i]);
				PatternMatch dotObject = new WildCharacterDot(ch[i]);
				tempObj.setNextChain(dotObject);
				tempObj = dotObject;
			}
			else if(ch[i] == '*') {
				System.out.println(ch[i]);
				PatternMatch asteriskObject = new WildCharacterAsterisk(ch[i]);
				tempObj.setNextChain(asteriskObject);
				tempObj = asteriskObject;
			}
			else {
				System.out.println(ch[i]);
				PatternMatch alphabetObject = new Alphabets(ch[i]);
				tempObj.setNextChain(alphabetObject);
				tempObj = alphabetObject;
			}
		}
		
		result = head.handleRequest(0, inputString);
		
		return result;
	}
		
}
