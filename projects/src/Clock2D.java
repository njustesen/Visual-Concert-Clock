import javax.swing.*;
import java.lang.String;

public class Clock2D extends JApplet {
	
	/*
	 * WHY??
	private int hour = Calendar.getInstance().get(Calendar.HOUR);
	private int min = Calendar.getInstance().get(Calendar.MINUTE);
	private int sec = Calendar.getInstance().get(Calendar.SECOND);
    */
	
	private ConcertSchedule schedule; 
    
	public static void main(String s[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new Clock2D();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
	}
    
	public void init() {
		ClockPanel panel = new ClockPanel();
        getContentPane().add(panel);
        
        // Setup schedule
        schedule = new ConcertSchedule();
        schedule.addAct(new Act("Rammstein", 19, 0));
        schedule.addAct(new Act("Rage Against the Machine", 20, 30));
        schedule.addAct(new Act("Jakob Med K", 21, 45));
        schedule.addAct(new Act("Justin Bieber", 23, 45));
        schedule.addAct(new Act("Justin Bieber, Again!", 0, 50));
        schedule.addAct(new Act("Jakob Med K", 1, 30));
        
        panel.setSchedule(schedule);
        
	}
	
}

