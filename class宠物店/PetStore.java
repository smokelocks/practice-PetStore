package class宠物店;

import java.util.ArrayList;

public class PetStore {
	private double revenue;
	private String name;
	private ArrayList<Pet> pets;

	public PetStore(String name) {
		this.name = name;
		this.pets = new ArrayList<Pet>();
		this.revenue = 0;
	}

	public String getStoreName() {
		return name;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

	public void showAllPets() {
		if (pets.isEmpty()) {
			System.out.println("现在我店没有宠物");
		} else {
			System.out.println("本店待售宠物如下:");

			for (Pet x : pets) {
				System.out.println("--------------");
				System.out.println(x.info());
			}
		}
	}

	public void sellPet(Pet pet) {
		pets.remove(pets.indexOf(pet));
		System.out.println();
		System.out.println(pet.name + "已经被你收留了。");
		revenue += pet.price;
		System.out.println("我店现在收入有￥" + revenue + "哇哈哈\n");
	}

	public void buyPet(Pet pet) {
		pets.add(pet);
		System.out.println();
		System.out.println(pet.name + "已经被我店买了。");
		revenue -= pet.price;
		System.out.println("交易完毕! 别反悔啊.");

	}
	

}
