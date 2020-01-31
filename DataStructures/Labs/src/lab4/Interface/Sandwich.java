package lab4.Interface;

public class Sandwich implements MenuItem {
		String name;
		double price;
		public Sandwich(String name, double price) {
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



