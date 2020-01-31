package lab9.hashtables;
import java.util.*;
public class SpellCheck {
	public static ArrayList<String> check(String input) {
		ArrayList<String> corrected= new ArrayList();
		char[] charstring=input.toCharArray();
		for(int i=0; i< input.length();i++) {
			char letterreset=charstring[i];
			for(char j='a'; j<='z';j++) {
				char[] temp=charstring;
				temp[i]=j;
				String add= new String(temp);
				corrected.add(add);
			}
			charstring[i]=letterreset;
		}
		
		for(int i=0; i< input.length()-1;i++) {
			char letterreset1=charstring[i];
			char letterreset2=charstring[i+1];
			charstring[i]=letterreset2;
			charstring[i+1]=letterreset1;
			String add= new String(charstring);
			corrected.add(add);
			charstring[i]=letterreset1;
			charstring[i+1]=letterreset2;
		}
		
		for(int i=0; i< input.length()-1;i++) {
			char letterreset=charstring[i];
			charstring[i]=' ';
			String add= new String(charstring);
			add=add.replaceAll("\\s+","");
			corrected.add(add);
			charstring[i]=letterreset;
			
		}
		
		
		
		
		return corrected;
	}
}
