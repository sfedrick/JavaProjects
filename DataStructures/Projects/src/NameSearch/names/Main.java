package homework3.names;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Yearobject> findnames= new ArrayList<Yearobject>();
		ArrayList<String> files= new ArrayList<String>();
		NameDLL listgirl= new NameDLL();
		NameDLL listboy= new NameDLL();
		for(int i=0;i<args.length;i++) {
			if(args[i].equals("-f")) {
				Yearobject addthis= new Yearobject(true,args[i+1]);
				findnames.add(addthis);
				i++;
				
			}
			else if (args[i].equals("-m")) {
				Yearobject addthis= new Yearobject(false,args[i+1]);
				findnames.add(addthis);
				i++;
			}
			else {
				files.add(args[i]);
			}
			
		}
		for(int i=0;i<files.size();i++) {
			if(i==0) {
				Read.file(files.get(0),listgirl,listboy,i);
			}
			else {
				Read.file(files.get(i),listgirl,listboy);
			}
		}
		for(Yearobject name:findnames) {
			if (name.getGirl()) {
				Name output=listgirl.find(name.getName());
				System.out.println(output.toString(listgirl));
			}
			else {
				Name output=listboy.find(name.getName());
				System.out.println(output.toString(listgirl));
			}
			
		}
		
	}
}
