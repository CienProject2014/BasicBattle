public class Unit implements Comparable<Unit>{
	private String name;
	public String type;
	
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

	private Status status;

	public Unit(String type, String name, Status status) {
		super();
		this.type = type;
		this.name = name;
		this.status = status;
	}

	protected boolean isDie() {
		if( status.getHp() <= 0 )
			return true;
		else
			return false;
	}

	public int compareTo(Unit unit) {
		int compareVelocity = ((Unit) unit).status.getVelocity();	// 내림차순 정렬
		
		return compareVelocity - this.status.getVelocity();
	}
}
