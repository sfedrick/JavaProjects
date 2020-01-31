package lab2.ArrayList;

class CSStudent extends Human{
	public CSStudent(String inputname,String inputsound) {
		super("CSStudent","I love to program");
		
	}
	public String getName() {
		return "CSStudent";
	}
	public String getSound() {
		return "I love to code";
	}
	public void speak() {
		System.out.println("I love to code");
	}
}
