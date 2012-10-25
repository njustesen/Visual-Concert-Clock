import java.util.ArrayList;

/**
 *  A schedule for concerts.
 *  Only works for concerts that starts after 16:00 and ends before 04:00.
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
		if (currentAct == null){
			return acts.get(0);
		} else {
    		int index = acts.indexOf(currentAct);
    		if (index < acts.size() - 1){
    			return acts.get(index+1);
    		}
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
		
		for(Act a : acts){
			
			if (hours > 4){
				
				if (a.getHour() > 4){
					
					if (a.getHour() < hours || a.getHour() == hours && a.getMinutes() <= min){
						currentAct = a;
					}
				
				}
				
			} else {
			
    			if (a.getHour() > 4){
    				
    				currentAct = a;
    				
    			} else if (a.getHour() < hours || a.getHour() == hours && a.getMinutes() <= min){
					
					currentAct = a;
					
				}
			}
		}
	}
	
}
