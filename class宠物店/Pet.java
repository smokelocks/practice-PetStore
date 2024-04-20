package class宠物店;

public abstract class Pet {
	protected String name;
	protected int age;
	protected double price;
	protected String type;

	public Pet(String name, int age, String type, double price) {
		this.name = name;
		this.age = age;
		this.price = price;
		this.type = type;
	}

	public void hello() {}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public String info() {
		return 	"type: " + "\t" + type + "\n" + 
				"name: " + "\t" + name + "\n" +
				"age: " + "\t" + age + "\n" +
				"price: " + "\t" + price + "\n";
	}

}
