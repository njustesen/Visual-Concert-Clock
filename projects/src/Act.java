
public class Act {
	
	private String name;
	private int hour, minutes;
	
	public Act(String name, int hour, int minutes){
		this.name = name;
		this.hour = hour;
		this.minutes = minutes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
