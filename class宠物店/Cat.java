package class宠物店;

public class Cat extends Pet {
		
	Cat(String name, Integer age, String type,double price) {
		super(name, age, type, price);
	}
	
	@Override
	public void hello() {
		System.out.printf("[%s]向你问好'meow meow~'，它露出肚皮.并且purrr了%d声",name, age);
		
	}
}
