package hw8;

public class hw8_1 {
	
	public abstract class Character{
		
		protected String name;
		protected int health;
		protected int attackPower;
		
		public Character(String name, int health, int attackPower) {
			this.name = name;
			this.health = health;
			this.attackPower = attackPower;
			
		}
		public void attack(Character other) {
			other.takeDamage(attackPower);
		}
		public void takeDamage(int damage) {
			health -= damage;
			System.out.println(name+"����"+damage+"�ˮ`�A�Ѿl��q�G"+health);
		}
		public abstract class warrior extends Character{
			private int defense;
			public warrior(String name, int health, int attackPower, int defense){
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
			@Override
			public void display() {
			System.out.println("�Ԥh�W�١G"+name+"�A�ͩR�ȡG"+health+"�A�����O�G"+attackPower+"�A���m�O�G"+defense);
			}
		}
		public abstract class mage extends Character{
			private int mana;
			public mage(String name, int health, int attackPower, int mana){
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
		
		public abstract void display();
	}
	
	public static void main(String[] args) {
		

	}

}


