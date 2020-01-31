package lab4.Interface;

public class Drink implements MenuItem {
	String name;
	double price;
	public Drink(String name, double price) {
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
