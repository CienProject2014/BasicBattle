
public class Status {
	private float hp;
	private float atk;	// attack
	private float def;	// defense
	private float cri;	// critical
	private float eva;	// evasion
	private float hit;	// hit
	private float exp;	// experience
	private String condition;
	private int velocity;
	

	
	public Status(float hp, float atk, float def, float cri, float eva,
			float hit, float exp, String condition, int velocity) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		
		this.cri = cri;
		this.eva = eva;
		this.hit = hit;
		
		this.exp = exp;
		this.condition = condition;
		this.velocity = velocity;
	}
	public float getAtk() {
		return atk;
	}
	public void setAtk(float atk) {
		this.atk = atk;
	}
	public float getHp() {
		return hp;
	}
	public void setHp(float hp) {
		this.hp = hp;
	}
	public float getDef() {
		return def;
	}
	public void setDef(float def) {
		this.def = def;
	}
	public float getCri() {
		return cri;
	}
	public void setCri(float cri) {
		this.cri = cri;
	}
	public float getEva() {
		return eva;
	}
	public void setEva(float eva) {
		this.eva = eva;
	}
	public float getHit() {
		return hit;
	}
	public void setHit(float hit) {
		this.hit = hit;
	}
	public float getExp() {
		return exp;
	}
	public void setExp(float exp) {
		this.exp = exp;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
}
