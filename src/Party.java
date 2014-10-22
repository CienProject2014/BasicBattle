import java.util.ArrayList;

public class Party {
	ArrayList<Hero> heros;
	
	public Party() {
		
	}
	public Party(ArrayList<Hero> heros) {
		this();
		this.heros = heros;
	}
	
	public ArrayList<Hero> getHeros() {
		return heros;
	}
	public void setHeros(ArrayList<Hero> heros) {
		this.heros = heros;
	}
	
	public boolean allDie() {
		boolean result=true;
		for (int i = 0; i < heros.size(); i++) {
			result = result && heros.get(i).isDie();
		}
		
		return result;
	}

}
