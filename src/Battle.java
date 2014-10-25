import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Battle {
	private Party party;
	private ArrayList<Monster> monsters;
	CQueue<Unit> ordered;
	
	private boolean isSet = false;
	private boolean isEnd = false;
	
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
			System.out.println("배틀이 설정되지 않았습니다.");
		}
	}
	
	private void checkEnd() {
		if(party.allDie()) {
			isEnd = true;
			System.out.println("모든 영웅이 사망했습니다.");
		}
		else {
			boolean monsterDie = true;
			for (int i = 0; i < monsters.size(); i++) {
				monsterDie = monsterDie & monsters.get(i).isDie();
			}
			isEnd = monsterDie;
			if(isEnd) 
				System.out.println("모든 몬스터가 죽었습니다.");
		}
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
		
		ordered = new CQueue<Unit>(size+1);
		for (int i = 0; i < units.length; i++) {
			ordered.enqueue(units[i]);
		}
	}
	
	public void battleLoop() {
		while( !isEnd ) {
			Unit present = ordered.dequeue();
			
			if(present.getType() == "Hero")
				System.out.println(present.getName()+"의 차례입니다.");
			
			action(present);

			ordered.enqueue(present);
			checkEnd();
		}
	}
	
	private void action(Unit unit) {
		if(unit.type == "Hero") {
			Scanner scan1 = new Scanner(System.in);
			System.out.print("공격 유형을 선택하세요(1:그냥공격, 2:스킬공격): ");
			int sel=0;
			sel = scan1.nextInt();
			

			switch(sel) {
			case 1: // plain attack
				printMonsters();
				System.out.print("공격할 몬스터를 선택하세요: ");
				int target = scan1.nextInt();
				plainAttack(unit, monsters.get(target));
				break;
			case 2: // skill attack
				break;
			}
		}
		else {
			//System.out.println("몬스터는 공격 안함");
		}
	}
	
	// a attack b
	private void plainAttack(Unit a, Unit b) {
		Random random = new Random();
		int[] dice = new int[3];
		boolean evasion = false,
				critical = false,
				atksuccess = false;
		float damage=0;
		
		for(int i=0; i<3; i++) {
			dice[i] = random.nextInt() % 100;
		}
		
		if(dice[0] < b.getStatus().getEva())
			evasion = true;
		if(dice[1] < a.getStatus().getCri())
			critical = true;
		if(dice[2] < a.getStatus().getHit())
			atksuccess = true;
		
		if( atksuccess && !evasion) {
			damage = (
					a.getStatus().getAtk()+
					a.getStatus().getCri()+
					a.getStatus().getHit()
				);
			if(critical)
				damage *= 2;
			
			damage -= b.getStatus().getDef();
		}
		
		float newHp = b.getStatus().getHp() - damage;
		
		System.out.println(b.getName()+"가 "+a.getName()+"에게 "+damage+"만큼의 데미지를 입고 "+
						"체력이 "+b.getStatus().getHp()+"에서 ");
		b.getStatus().setHp(newHp);
		System.out.println(b.getStatus().getHp()+"이 되었습니다.");
		
		if(b.isDie()) {
			System.out.println(b.getName() + "가 죽었습니다.");
			monsters.remove(b);
			
		}
	}
	
	// a attack b using skill 
	private void skillAttack(Unit a, Unit b, String skill) {
		
	}
	
	void printMonsters() {
		for(int i=0; i<monsters.size(); i++) {
			System.out.println((i) + "th: " + monsters.get(i).getName());
		}
	}
}
