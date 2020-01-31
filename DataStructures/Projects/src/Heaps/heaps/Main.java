package homework7.heaps;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import homework3.names.Yearobject;



public class Main {
	public static void main(String arg[]) {
		
		ArrayList<String> files= new ArrayList<String>();
		ArrayList<String> remove= new ArrayList<String>();
		String[] args= {"/Applications/notes/Classes/cs206/assignments/a6/polls/dempres_20190210_2.csv","/Applications/notes/Classes/cs206/assignments/a6/polls/dempres_20190211_1.csv","-r","Biden"};
		ArrayHeap filetree= new ArrayHeap();
		int peek=5;
		
		for(int i=0;i<args.length;i++) {
			if(args[i].equals("-n")) {
				peek=Integer.parseInt(args[i+1]);
				
			}
			else if (args[i].equals("-r")) {
				while(i+1<args.length && !args[i+1].contains("dempres")) {
					remove.add(args[i+1]);
					i++;
				}
					
			}
			else {
				files.add(args[i]);
			}
			
		}

		
		for(int i=0;i<files.size();i++) {
        		filetree.insert(files.get(i));
         }
		files=filetree.peekTopN(files.size());
		
		
	

        ArrayBinaryTree tree=ReadFile.readFile(files.get(0));
        ArrayHeap heap=ReadFileHeap.readFile(files.get(0));
        String garbarge=files.remove(0);
        ReadFile.readFile(files,tree);
        ReadFileHeap.readFile(files,heap);
        ArrayList lister=heap.peekTopN(peek);
        
        for(Object x: lister) {
        	System.out.println(x);
        }
        for(String x: remove) {
			Candidate ousted=new Candidate(x,x,-1);
			heap.remove(ousted);
        }
		 
		 System.out.println(heap);
		
		 
	}

}


