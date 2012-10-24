import java.util.ArrayList;

/**
 *  A schedule for concerts.
 */
public class ConcertSchedule{
	
	private ArrayList<Act> acts;
	private Act currentAct;
	
	public ConcertSchedule(){
		acts = new ArrayList<Act>();
	}

	public ArrayList<Act> getActs() {
		return acts;
	}

	public void setActs(ArrayList<Act> acts) {
		this.acts = acts;
	}
	
	public void addAct(Act act) {
		this.acts.add(act);
	}

	public Act getCurrentAct() {
		return currentAct;
	}
	
	public Act getNextAct() {
		int index = acts.indexOf(currentAct);
		if (index < acts.size() - 1){
			return acts.get(index+1);
		}
		return null;
	}
	
	/**
	 * Updates the current act in the schedule.
	 * 
	 * @param hours
	 * @param min
	 */
	public void update(int hours, int min){
		if (currentAct == null && acts.size() > 0){
			currentAct = acts.get(0);
		}
		if (getNextAct() != null){
			if (getNextAct().getHour() > hours){
				
				setNextActToPlay();
				
			} else if (getNextAct().getHour() == hours){
				if (getNextAct().getMinutes() >= min){
					
					setNextActToPlay();
					
				}
			}
		}
	}

	private void setNextActToPlay() {
		currentAct = getNextAct();
	}
	
}
