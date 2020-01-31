package lab9.hashtables;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		String dictionary="/Users/thedude/eclipse-workspace/CS206/Labs/src/lab9/hashtables/dictionary.txt";
		String search="/Users/thedude/eclipse-workspace/CS206/Labs/src/lab9/hashtables/search.txt";
		ArrayList<String>dict= new ArrayList();
		ArrayList<String>sear= new ArrayList();
		
		dict=Read.readFile(dictionary);
		sear=Read.readFile(search);
	
		
		ProbeHashMap dicthash= new ProbeHashMap(30000);
		
		int total=0;
		for(String x:dict) {
			dicthash.put(x, x);
		}
		System.out.println(dicthash.getProbes());
		System.out.println(dicthash.getMaxProbes());
		
		
		ArrayList<ArrayList<String>>spellchecks= new ArrayList();
		for(String n: sear) {
			ArrayList<String>add= SpellCheck.check(n);
			spellchecks.add(add);
		}
		
		ArrayList<String>checks= new ArrayList();
		
		
		/*for(String n:spellchecks.get(0)) {
			System.out.print(n+" ");
		}*/
		
		
		for(ArrayList<String> n:spellchecks) {
			String addme="";
			for(String k: n) {
				if(dicthash.get(k)!=null && !(addme.contains(" "+k+","))) {
					addme=addme+k+", ";
				}
			}
			checks.add(addme);
		}
		for(String y:checks) {
			System.out.println(y);
		}
		
		System.out.println(dicthash.getProbes());
		System.out.println(dicthash.getMaxProbes());
		
	}
}
