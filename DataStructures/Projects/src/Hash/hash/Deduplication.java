package homework8.hash;
import java.util.*;




public class Deduplication<E>{
	private ArrayList<Comparable <E>> input;
	private int allpairscopy=0;
	private int hashlincopy=0;
	private int hashdoublecopy=0;
	private int hdavgprobes=0;
	private int hdmaxprobes=0;
	private int builtincopies=0;
	public Deduplication(ArrayList<Comparable<E>>input) {
		this.input=input;
		
	}
	
	public ArrayList<Comparable<E>> allPairsDeduplication(ArrayList<Comparable<E>> newarray){
		
		for(Comparable x: newarray) {
			int i=0;
			boolean remove=false;
			for(Comparable <E> y: newarray) {
				if(y!=null && x!=null) {
					if(x.compareTo(y)==0 && remove) {
						newarray.set(i,null);
						allpairscopy=allpairscopy+1;		
					}
					else if(x.compareTo(y)==0) {
						remove=true;
					}
				}
				i=i+1;
			}
		}
		return newarray;
		
	}
	
	
	
	public ArrayList<E> hashLinearDeduplication(ArrayList<Comparable<E>> newarray){
		ProbeHashMap hash= new ProbeHashMap(2000000,2000003);
		ArrayList<E> hasharray= new ArrayList();
		for(Comparable x: newarray) {
			
			if(hash.get(x)!= null) {
				hashlincopy=hashlincopy+1;
			}
			else {
				hash.put(x,x);
			}
		}
		Iterable<E> hashiterate= hash.keySet();
		for(E x: hashiterate) {
			hasharray.add(x);
			
		}
		System.out.println("Average numer of probes: "+ hash.getavgProbes());
		System.out.println("Max number of probes: "+ hash.getMaxProbes());
		System.out.println("load: "+ ((float)hash.getSize()/(float)hash.getCap()));	
		return hasharray;
		
	}
	public ArrayList<E> hashDoubleDeduplication(ArrayList<Comparable<E>> newarray){
		DoubleHashMap hash= new DoubleHashMap(2000000,2000003);
		ArrayList<E> hasharray= new ArrayList();
		for(Comparable x: newarray) {
			
			if(hash.get(x)!= null) {
				hashdoublecopy=hashdoublecopy+1;
			}
			else {
				hash.put(x,x);
			}
		}
		Iterable<E> hashiterate= hash.keySet();
		for(E x: hashiterate) {
			hasharray.add(x);
			
		}
		System.out.println("Average numer of probes: "+ hash.getavgProbes());
		System.out.println("Max number of probes: "+ hash.getMaxProbes());
		System.out.println("load: "+ ((float)hash.getSize()/(float)hash.getCap()));
		return hasharray;
		
	}
	public ArrayList<E> quicksortDeduplication(ArrayList<Comparable<E>> newarray){
		int n = input.size(); 
        QuickSort quick= new QuickSort(newarray); 
        quick.sort();
        return quick.getArray();
	}
	
	
	public ArrayList<person> builtinSortDeduplication(ArrayList<person> newarray){
		int n = input.size(); 
       
        Collections.sort(newarray);
        ArrayList<person> finalarray= new ArrayList();
        finalarray.add(newarray.get(0));
        for (int i = 1; i < newarray.size(); i++) {
			if(newarray.get(i-1).compareTo((newarray.get(i)))!=0){
				finalarray.add(newarray.get(i));
			}
			else {
				builtincopies=builtincopies+1;
			}
			
		}
        
        return finalarray;
        
        
	}
	
	public int getBuiltCopies() {
		return builtincopies;
	}
	
	public String toString(){
		String value="all pair copies";
		int i=0;
		for(Comparable <E> y: input) {
			value=value+"person"+i+": "+y+"\n";
			 i=i+1;
		}
		return value;
		
	}

}
