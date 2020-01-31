package lab4.Interface;
import java.util.*;
public class Trio implements MenuItem {
Sandwich mainitem;
Salad sideitem;
Drink drinkitem;
String name;
double price;
	public Trio(Sandwich mainitem,Salad sideitem,Drink drinkitem){
		this.mainitem=mainitem;
		this.sideitem=sideitem;
		this.drinkitem=drinkitem;
		this.name= mainitem.getName()+"/"+sideitem.getName()+"/"+drinkitem.getName();
		setPrice(mainitem,sideitem,drinkitem);
	}
	public Trio(Sandwich mainitem,Salad sideitem,Drink drinkitem,Boolean sort){
		this.mainitem=mainitem;
		this.sideitem=sideitem;
		this.drinkitem=drinkitem;
		this.name= nameSort( mainitem,sideitem,drinkitem);
		setPrice(mainitem,sideitem,drinkitem);
	}
	public String getName(){
	return name;
	}
	public double getPrice(){
	return price;
	}
	private String nameSort(Sandwich mainitem,Salad sideitem,Drink drinkitem){
		double a=mainitem.getPrice();
		double b=sideitem.getPrice();
		double c=drinkitem.getPrice();
		MenuItem[] sortme = {mainitem,sideitem,drinkitem};

		Boolean append=false;
		String answer="";
		for(int i=0; i<sortme.length;i++) {
			for(int j=i; j<sortme.length;j++) {
				if(sortme[i].getPrice()>sortme[j].getPrice()) {
					MenuItem stored=sortme[i];
					MenuItem smallest=sortme[j];
					sortme[i]=smallest;
					sortme[j]=stored;
					
				}
			}
			
		}
		
		for(MenuItem x: sortme) {
			answer=answer+x.getName()+"/";
		}
		
		return answer;
		
	}
	private void setPrice(Sandwich item1,Salad item2,Drink item3) {
		double a=item1.getPrice();
		double b=item2.getPrice();
		double c=item3.getPrice();
		
		if((a+b)>(b+c)&&(a+b)>(c+a)) {
			price=a+b;
		}
		else if((b+c)>(a+b)&&(b+c)>(c+a)) {
			price=b+c;
		}
		else if((b+c)==(a+b)&&(b+c)==(c+a)) {
			
			try {
				throw new IllegalTrioException("can't have all equal items"); 
				}
				 catch(IllegalTrioException e) 
		        {
					 
					 System.out.println(e); // rethrowing the exception 
					 
		        } 
		}
		else {
			price=b+c;
		}
	}
	
	
}
