import java.util.LinkedList;
import java.util.List;

public class Match {
	
	String pattern;
	int result = -2;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	public int findFirstIn(String inputString) {
		
		char[] ch = new char[pattern.length()];
		ch = pattern.toCharArray();

		List<PatternMatch> objects = new LinkedList<>();
		
		for(int i=0; i< ch.length; i++) {
			if(ch[i] == '.') {
				PatternMatch dotObject = new WildCharacterDot(ch[i]);
				objects.add(dotObject);
				//head.setNextChain(dotObject);
			}
			else if(ch[i] == '*') {
				PatternMatch asteriskObject = new WildCharacterAsterisk(ch[i]);
				objects.add(asteriskObject);
				//dotObject.setNextChain(asteriskObject);
			}
			else {
				PatternMatch alphabetObject = new Alphabets(ch[i]);
				objects.add(alphabetObject);
				//asteriskObject.setNextChain(alphabetObject);
			}
		}
		PatternMatch dotObject = new EndHandler();
		objects.add(dotObject);
		
		PatternMatch head = new HeadHandler();
		head.setNextChain(objects.get(0));
		for(int i = 0; i<objects.size()-1; i++) {
			objects.get(i).setNextChain(objects.get(i+1));
		}
		
		result = head.handleRequest(0, inputString, pattern, 0);
		
		return result;
	}
		
}
