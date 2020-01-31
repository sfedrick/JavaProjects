package lab4.Interface;

public class Salad implements MenuItem {
	String name;
	double price;
	public Salad(String name, double price) {
		this.name= name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

}
