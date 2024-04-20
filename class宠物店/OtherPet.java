package class宠物店;

public class OtherPet extends Pet {
	OtherPet(String name, Integer age, String type, double price) {
		super(name, age, type, price);
	}

	@Override
	public void hello() {
		System.out.printf("[%s]向你问好!，它露出肚皮.并且哎哎了%d声", name, age);

	}
}
