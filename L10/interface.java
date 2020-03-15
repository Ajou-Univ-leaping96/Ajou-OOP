package interfaces;

interface AbleToCry {
	void cry();
}
abstract class Animal {
	int animal_id;

	public Animal() {
	}
}
 class Dog extends Animal implements AbleToCry{
		int Dog_id;
		
		public Dog(int Dog_id) {
			super();
			animal_id = 1;
			this.Dog_id = Dog_id;
		}

		@Override
		public void cry() {
			System.out.println("멍멍멍!! 왈왈!!");
		}

	}
class Pig extends Animal implements AbleToCry {
	//Pig 클래스는 Animal 추상클래스의 자손이며 AbleToCry 인터페이스를 구현
	int Pig_id;

	public Pig(int Pig_id) {
		super();
		this.animal_id = 3;
		this.Pig_id = Pig_id;
	}

	@Override
	public void cry() {
		System.out.println("꿀꿀 오잉오잉! 꿀꿀 오잉오잉!");
	}

}
class Duck extends Animal implements AbleToCry {
	//Duck 클래스는 Animal 추상클래스의 자손이며 AbleToCry 인터페이스를 구현
	int Duck_id;

	public Duck(int Duck_id) {
		super();
		this.animal_id = 2;
		this.Duck_id = Duck_id;
	}

	@Override
	public void cry() {
		System.out.println("꽉꽉~~ 꽉꽉~~");
	}
}

class Tree implements AbleToCry {
	//Tree 클래스는 Animal 추상클래스의 자손이 아니지만 AbleToCry 인터페이스를 구현
	int Tree_id;

	public Tree(int Tree_id) {
		this.Tree_id = Tree_id;
	}

	@Override
	public void cry() {
		System.out.println("소나무 사이로 지나가는 바람은 솨 쌀쌀하게 들리고….≪육정수, 송뢰금≫");
	}
}

public class CryTest {
	public static void main(String[] args) {
		AbleToCry[] cry = new AbleToCry[4];
		cry[0] = new Dog(1);
		cry[1] = new Pig(1);
		cry[2] = new Duck(1);
		cry[3] = new Tree(1);

		for (AbleToCry current : cry) {
			current.cry();
		}

	}

}
