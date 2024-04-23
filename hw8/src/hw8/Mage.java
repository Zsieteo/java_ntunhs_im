package hw8;

public class Mage extends Character{
	private int mana;
	public Mage(String name, int health, int attackPower, int mana){
		super(name,health,attackPower);
		this.mana = mana;
	}
	public void castSpell(Character other) {
		if(mana >= 20) {
			int spellDamage = attackPower*2;
			other.takeDamage(spellDamage);
			mana -= 20;
			System.out.println(name+"�I��k�N�A�y��"+spellDamage+"�ˮ`");	
		}
		else {
			System.out.println(name+"�]�O����");	
		}	
	}
	public void display() {
	System.out.println("�k�v�W�١G"+name+"�A�ͩR�ȡG"+health+"�A�����O�G"+attackPower+"�A�k�O�ȡG"+mana);
	}
}
