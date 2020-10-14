
public class Car {
	
	int weight; 
	String color;
	String name;

	public Car() {
		this.weight = 500;
		this.color = "White";
		this.name = "Fride";
	}

	public Car(String name) {
		this.weight = 500;
		this.color = "White";
		this.name = name;
	}
	
	public Car(String name, String color) {
		this.weight = 500;
		this.color = color;
		this.name = name;
	}
	
}
