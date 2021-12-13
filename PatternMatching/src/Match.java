import java.util.LinkedList;
import java.util.List;

public class Match {
	PatternMatch head;
	String pattern;
	int result = -2;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	public int findFirstIn(String inputString) {
		
		char[] ch = new char[pattern.length()];
		ch = pattern.toCharArray();

		List<PatternMatch> objects = new LinkedList<>();
		
		PatternMatch tempObj;
		//System.out.print(ch);
		
		//Initialize 1st character (Head)
		if(ch[0] == '.') {
			tempObj = new WildCharacterDot(ch[0]);
		}
		else if(ch[0] == '*') {
			tempObj = new WildCharacterAsterisk(ch[0]);
		}
		else {
			tempObj = new Alphabets(ch[0]);
		}
		
		head = tempObj;
		//System.out.println(ch[0]);
		for(int i=1; i< ch.length; i++) {
			if(ch[i] == '.') {
				//System.out.println(ch[i]);
				PatternMatch dotObject = new WildCharacterDot(ch[i]);
				objects.add(dotObject);
				tempObj.setNextChain(dotObject);
				tempObj = dotObject;
			}
			else if(ch[i] == '*') {
				//System.out.println(ch[i]);
				PatternMatch asteriskObject = new WildCharacterAsterisk(ch[i]);
				objects.add(asteriskObject);
				tempObj.setNextChain(asteriskObject);
				tempObj = asteriskObject;
			}
			else {
				//System.out.println(ch[i]);
				PatternMatch alphabetObject = new Alphabets(ch[i]);
				objects.add(alphabetObject);
				tempObj.setNextChain(alphabetObject);
				tempObj = alphabetObject;
			}
		}
		/*PatternMatch dotObject = new EndHandler();
		objects.add(dotObject);
		
		PatternMatch head = new HeadHandler(ch[0]);
		head.setNextChain(objects.get(0));
		for(int i = 0; i<objects.size()-1; i++) {
			objects.get(i).setNextChain(objects.get(i+1));
		}
		*/
		
		result = head.handleRequest(0, inputString);
		
		return result;
	}
		
}
