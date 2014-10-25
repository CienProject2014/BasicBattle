public class Unit implements Comparable<Unit>{
	private String name;
	private Status status;
	public String type;
	private boolean alive;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Unit(String type, String name, Status status) {
		super();
		this.type = type;
		this.name = name;
		this.status = status;
		this.alive = true;
	}

	protected boolean isDie() {
		if(alive) {
			if( status.getHp() <= 0 ) {
				alive = false;
			}
		}
		
		return !alive;
	}



	public int compareTo(Unit unit) {
		int compareVelocity = ((Unit) unit).status.getVelocity();	// 내림차순 정렬
		
		return compareVelocity - this.status.getVelocity();
	}
}
