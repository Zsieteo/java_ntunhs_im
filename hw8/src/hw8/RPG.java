package hw8;

public class RPG {

	public static void main(String[] args) {
		Warrior warrior1 = new Warrior("�ԤhA", 100, 15, 5);
		Mage mage1 = new Mage("�k�vB", 80, 10, 50);
		
		mage1.castSpell(warrior1);
		warrior1.useShield();
		warrior1.attack(mage1);
		mage1.display();
		warrior1.display();
	}
	
}
