public class Match {
	public static void main(String args[]) {
		String exp = "c.t";
		String fullExp = "cacacat";
		char[] ch = new char[exp.length()];
		ch = exp.toCharArray();
		for(int i=0; i< ch.length; i++) {
			
			if(ch[i] == '.') {
				PatternMatch obj = new WildCharacterDot();
				obj.setNextChain(obj);
			}
			else if(ch[i] == '*') {
				PatternMatch obj = new WildCharacterAsterisk();
			}
			else {
				PatternMatch obj = new Alphabets();
			}
		}
	}
}
