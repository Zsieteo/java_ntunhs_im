package hw8;

public class Warrior extends Character{
	private int defense;
	public Warrior(String name, int health, int attackPower, int defense){
		super(name,health,attackPower);
		this.defense = defense;
	}
	@Override
	public void takeDamage(int damage) {
		int reduceDamage = Math.max(damage - defense, 0);
		super.takeDamage(reduceDamage);
	}
	public void useShield() {
		defense += 10;
		System.out.println(name+"�ϥά޵P�A���m�O�W�[��"+defense);
	}
	public void display() {
	System.out.println("�Ԥh�W�١G"+name+"�A�ͩR�ȡG"+health+"�A�����O�G"+attackPower+"�A���m�O�G"+defense);
	}
}
