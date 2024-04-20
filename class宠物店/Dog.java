package class宠物店;

public class Dog extends Pet {
		
	Dog(String name, Integer age, String type, double price) {
		super(name, age, type, price);
	}
	
	@Override
	public void hello() {
		System.out.printf("你在和%s玩的时候，它撒尿了.并且叫了%d声",name, age);
	}
}
