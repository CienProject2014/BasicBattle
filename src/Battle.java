import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class Battle {
	private Party party;
	private ArrayList<Monster> monsters;
	CQueue<Unit> ordered;
	
	private boolean isSet;
	private boolean isEnd=false;
	
	public Battle() {
		
	}
	
	public void set(Party party) {
		this.party = party;
	}
	
	public void set(Party party, ArrayList<Monster> monsters) {
		this.set(party);
		this.monsters = monsters;
		calcOrder();
		isSet = true;
	}
	
	public void start() {
		if( isSet ) {
			battleLoop();
		} else {
			System.out.println("Oh no. Battle is not set");
		}
	}
	
	private void checkEnd() {
		if(party.allDie())
			isEnd = true;
		else
			isEnd = false;
	}
	
	private void calcOrder() {
		int size = party.getHeros().size() + monsters.size();
		Unit[] units = new Unit[size];
		int index = 0;
		for (int i = 0; i < party.getHeros().size(); i++) {
			units[index++] = party.getHeros().get(i);
		}
		for (int i = 0; i < monsters.size(); i++) {
			units[index++] = monsters.get(i);
		}
		
		Arrays.sort(units);
		
		ordered = new CQueue<Unit>(size);
		for (int i = 0; i < units.length; i++) {
			ordered.push(units[i]);
		}
	}
	
	public void battleLoop() {
		while( !isEnd ) {
			Unit present = ordered.get();
			
			if(present.type == "Hero")
				System.out.println("Hero "+present.getName());
			else if(present.type == "Monster")
				System.out.println("Monster "+present.getName());

			ordered.push(present);
			checkEnd();
		}
	}
}
