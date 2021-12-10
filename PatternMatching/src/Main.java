
public class Main {
	public static void main(String args[]) {
		
		
		String str = "cacacat";
		String pm = "c*t";
		
		Match match = new Match("ca*");
		int index = match.findFirstIn("bobcat");
		System.out.print(index);
	}
	
		/*
		if(pm.charAt(0) == '*' || pm.charAt(0) == '.') {
			boolean res = patternMatch(0,str,pm,0);
			if(res) {
				System.out.println(0);
			}
			
		}
		else {
		for(int i=0;i<str.length();i++) {
			if(pm.charAt(0) == str.charAt(i)) {
				//System.out.println(i);
				boolean res = patternMatch(i,str,pm,0);
				if(res) {
					System.out.println(i);
					break;
				}
				else 
					continue;
					
			}
			}
		}
		
	}
	
	public static boolean patternMatch(int position, String str,String pm, int pmp) {
		
		if(pm.charAt(pmp) == '.') {
			System.out.println(".,    "+ pmp);
			boolean res = patternMatch(position+1,str,pm,pmp+1);
			
			if(res == true)
				return true;
			
		}
			
		
		else if(pm.charAt(pmp) == '*') {
			//System.out.println("*");
			
			if(pm.length() == pmp+1)
				return true;
			
			
			while(position < str.length()) {
				if(str.charAt(position) == pm.charAt(pmp+1)) {
					boolean res = patternMatch(position,str,pm,pmp+1);	
					if(res == true)
						return true;
				}
					
				position++;
			}
			if(position == str.length())
				return false;
			//System.out.println("posss    "+ position);
			
		}
		
		else if(pm.charAt(pmp) == str.charAt(position)) {
			//System.out.println("alpha    "+pmp);
			if(position+1 <str.length() && pmp+1<pm.length()) {
				boolean res = patternMatch(position+1, str, pm, pmp+1);
				if(res == true)
					return true;
			}
			if(pmp+1 == pm.length()) {
				return true;
			}
		}
			
		
		return false;
	}
	
		*/
}
