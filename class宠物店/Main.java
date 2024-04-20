package class宠物店;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 创建一个名为 `PetStore` 的类，并设计其能够管理的宠物类型（如猫、狗等）。
		// 任务：
		// a. 为宠物商店定义属性，如商店名称、宠物列表等。
		// b.
		// 实现几种宠物类，每个宠物具有名称、年龄、品种等属性，和吃（eat）、玩（play）等行为。
		// c. 在 `PetStore` 类中定义方法来添加新宠物、售卖宠物和列出所有宠物。
		// d. 在主函数中创建 `PetStore` 对象，并实例化一些宠物，演示添加和售卖宠物的过程。

		// 造一个所有宠物对应序号的字典 方便用户购买选择
		HashMap<Integer, Pet> petsMap = new HashMap<>();

//		//造一个商店
		Scanner scanner = new Scanner(System.in);
		PetStore myShop = new PetStore("溜溜球宠物店");
//		
//		//狗子的操作
		Dog dog1 = new Dog("普吉", 1, "雪瑞纳", 2499);
		Dog dog2 = new Dog("查隆", 3, "哈士奇", 4355);
		Dog dog3 = new Dog("阿祖尔", 1, "萨摩耶", 6599);

//		//猫子的操作
		Cat cat1 = new Cat("清风", 1, "布偶", 7000);
		Cat cat2 = new Cat("细雨", 5, "金渐层", 3999);
		Cat cat3 = new Cat("润物", 2, "短毛", 2388);
		Cat cat4 = new Cat("无声", 1, "布偶", 12000);
		myShop.addPet(dog1);
		myShop.addPet(dog2);
		myShop.addPet(dog3);
		myShop.addPet(cat1);
		myShop.addPet(cat2);
		myShop.addPet(cat3);
		myShop.addPet(cat4);
		petsMap.put(1, dog1);
		petsMap.put(2, dog2);
		petsMap.put(3, dog3);
		petsMap.put(4, cat1);
		petsMap.put(5, cat2);
		petsMap.put(6, cat3);
		petsMap.put(7, cat4);

		System.out.printf("欢迎光临%s! 请通过如下编号进行选择:\n", myShop.getStoreName());

		String userChoice = "";
		while (!"q".equals(userChoice)) {
			System.out.println("----------------");
			System.out.println("" + "\t1. 查看本店待售宠物\n" + "\t2. 购买宠物\n" + "\t3. 把你的宠物卖给本店\n" + "\tq. 退出");
			System.out.println("----------------\n");

			userChoice = scanner.next();

			switch (userChoice) {
			case "1":
				myShop.showAllPets();
				break;
			case "2":
				System.out.println("你想买哪只？输入序号就行");
				for (int key : petsMap.keySet()) {
					System.out.printf("%d: %s\n", key, petsMap.get(key).name);
				}
				int pickPetNo = scanner.nextInt();
				// 我需要一个和用户交互的数组列表 根据序号决定pet是谁 然后传入下面的sellPet()
				myShop.sellPet(petsMap.get(pickPetNo));
				break;
			case "3":
				System.out.println("请问宠物的种类?");
				String type = scanner.next();
				System.out.println("请问它的名字是?");
				String name = scanner.next();
				System.out.println("请问" + name + "多大了？");
				int age = scanner.nextInt();
				System.out.println("你想卖多少钱？");
				int price = scanner.nextInt();
				if (price >= 1000) {
					System.out.println("太它奶奶的贵了，你还不如坐着" + name + "上天给玉皇大帝当宠物呢！");
					double barginPrice = Math.ceil(Math.random() * 20 * 100);
					System.out.println("我店只付这么多钱：" + barginPrice + " 交易吗？ (y/n)");
					String yes = scanner.next();
					if ("y".equals(yes)) {
						OtherPet petFromCustomer = new OtherPet(name, age, type, barginPrice);
						myShop.buyPet(petFromCustomer);
					} else {
						break;
					}
				} else if (price > 0 && price < 1000) {
					OtherPet petFromCustomer = new OtherPet(name, age, type, price);
					myShop.buyPet(petFromCustomer);
					System.out.println("成交!");
				}

			case "q":
				break;
			}

		}

		System.out.println("谢谢惠顾 大怨种");

		scanner.close();

	}
}
