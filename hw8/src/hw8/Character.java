package hw8;

public class Character {
	
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
			System.out.println(name+"¨ü¨ì"+damage+"¶Ë®`¡A³Ñ¾l¦å¶q¡G"+health);
		}
		
	}

