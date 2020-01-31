package homework6.trees;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import homework6.zipcode.LookupZip;
import homework6.zipcode.PopulatedPlace;

public class Main {
	public static void main(String args[]) {
		
		ArrayList<String> files= new ArrayList<String>();
		String[] arg= {"/Applications/notes/Classes/cs206/assignments/a6/polls/dempres_20190210_2.csv","/Applications/notes/Classes/cs206/assignments/a6/polls/dempres_20190211_1.csv"};
		BinaryTree filetree= new BinaryTree();
		for(int i=0;i<arg.length;i++) {
        		filetree.insert(arg[i]);
                
            }
		String[] split= filetree.fileInOrder().split("[$]");
		for(String splitten: split) {
			if(!splitten.contentEquals(""))
				files.add(splitten);
			else {
				String garbage=splitten;
			}
		}

        

        BinaryTree tree=ReadFile.readFile(files.get(0));
        String garbarge=files.remove(0);
        ReadFile.readFile(files,tree);
		
		
		
		
		ReadFile.readFile(files,tree);
		Candidate tester=new Candidate("Abrams","Joseph R., Biden Jr.",25);
		System.out.println(tree.remove(tester));
		System.out.println("In order");
		tree.printInOrder();
		System.out.println("\n"+"Post order");
		tree.printPostOrder();
		
		System.out.println("\n"+"Pre order");
		tree.printPreOrder();
		
		System.out.println();
		
	}

}
