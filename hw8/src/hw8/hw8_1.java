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
			System.out.println(name+"受到"+damage+"傷害，剩餘血量："+health);
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
				System.out.println(name+"使用盾牌，防禦力增加至"+defense);
			}
			@Override
			public void display() {
			System.out.println("戰士名稱："+name+"，生命值："+health+"，攻擊力："+attackPower+"，防禦力："+defense);
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
					System.out.println(name+"施放法術，造成"+spellDamage+"傷害");	
				}
				else {
					System.out.println(name+"魔力不足");	
				}	
			}
			public void display() {
			System.out.println("法師名稱："+name+"，生命值："+health+"，攻擊力："+attackPower+"，法力值："+mana);
			}
		}
		
		public abstract void display();
	}
	
	public static void main(String[] args) {
		

	}

}


