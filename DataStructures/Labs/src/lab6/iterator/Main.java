package lab6.iterator;
import java.util.Iterator;
public class Main {
	public static void main(String[] args) {
		System.out.println("testing the hasnext,hasprev,prev, and next methods");
		ArrayList<Integer> test=new ArrayList(15);
		for(int i=0; i<15;i++) {
			test.set(i, i+1);
		}
		MyIterator testa=test.MyListIterator(16);
		while(testa.hasPrevious()){
			System.out.print(testa.previous()+" ");
			int current=(int)testa.current();
			
		}
		System.out.println(" ");
		
		while(testa.hasNext()){
			System.out.print(testa.next()+" ");
		}
		System.out.println("");
		System.out.println("testing the set method");
		
		while(testa.hasPrevious()){
			
			int current=(int)testa.current();
			testa.set(current*2);
			testa.previous();
		}
		int current=(int)testa.current();
		testa.set(current*2);
		System.out.print(testa.current());
		System.out.print(" ");
		
		while(testa.hasNext()){
			System.out.print(testa.next()+" ");
		}
		System.out.println("");
		System.out.println("testing the remove method");
		while(testa.hasPrevious()){
			testa.previous();
			testa.remove();
			
		}
		testa.remove();
		System.out.println(test.size());
		
		ArrayList<Integer> L= new ArrayList(15);
		ArrayList<Integer> P= new ArrayList(15);
		
		for(int i=0; i<15;i++) {
			L.set(i, i);
		}
		for(int i=0; i<15;i++) {
			System.out.print(L.get(i)+" ");
		}
		System.out.println(" ");
		for(int i=0; i<6;i++) {
			P.set(i, i*2);
		}
		for(int i=0; i<6;i++) {
			System.out.print(P.get(i)+" ");
		}
		System.out.println();
		System.out.println("testing removePositions");
		
		ArrayList.removepositions(L,P);
		
		
		for(int num: L) {
			
			System.out.print(num+" ");
		}
		
		
		
	}
}
