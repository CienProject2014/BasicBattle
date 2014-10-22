import java.util.ArrayList;

public class Main {
	public static void main(String[] args) { 
		Hero hero1 = new Hero("Hero", "hero1",
				new Status(100, 10, 10, 10, 10, 0, "normal", 1));
		Hero hero2 = new Hero("Hero", "hero2", 
				new Status(100, 10, 10, 10, 10, 0, "normal", 3));
		Hero hero3 = new Hero("Hero", "hero3", 
				new Status(100, 10, 10, 10, 10, 0, "normal", 6));
		Monster monster1 = new Monster("Monster", "Monster1",
				new Status(100, 10, 10, 10, 10, 0, "normal", 2));
		Monster monster2 = new Monster("Monster", "Monster2",
				new Status(100, 10, 10, 10, 10, 0, "normal", 4));
		Monster monster3 = new Monster("Monster", "Monster3",
				new Status(100, 10, 10, 10, 10, 0, "normal", 5));
		
		ArrayList<Hero> heros = new ArrayList<Hero>();
		heros.add(hero1);
		heros.add(hero2);
		heros.add(hero3);
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add(monster1);
		monsters.add(monster2);
		monsters.add(monster3);
		
		Party party = new Party(heros);
		
		Battle battle = new Battle();
		battle.set(party, monsters);
		
		battle.start();
	}
}
