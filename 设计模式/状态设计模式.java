package eight;

//State design pattern
//状态设计模式

class AlertStatus {
	public String getStatus() {
		return "None";
	}
}

class RedAlertStatus extends AlertStatus {
	public String getStatus() {
		return "Red";
	}
}

class YellowAlertStatus extends AlertStatus {
	public String getStatus() {
		return "Yellow";
	}
}

class GreenAlertStatus extends AlertStatus {
	public String getStatus() {
		return "Green";
	}
}

public class Starship {
	
	
	private AlertStatus status = new GreenAlertStatus();
	
	public void setStatus(AlertStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Starship [status=" + status.getStatus() + "]";
	}

	public static void main(String[] args) {
		Starship starship = new Starship();
		System.out.println(starship);
		starship.setStatus(new YellowAlertStatus());
		System.out.println(starship);
		starship.setStatus(new RedAlertStatus());
		System.out.println(starship);
		starship.setStatus(new GreenAlertStatus());
		System.out.println(starship);
		
	}
}