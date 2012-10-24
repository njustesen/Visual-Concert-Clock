import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

class ClockPanel extends JPanel implements ActionListener{
	
    private AffineTransform rotH = new AffineTransform();
    private AffineTransform rotM = new AffineTransform();
    private AffineTransform rotS = new AffineTransform();
  
    private ConcertSchedule schedule;
    
    public ClockPanel() {
    	setPreferredSize(new Dimension(640, 480));
    	setBackground(Color.white);
    	Timer timer = new Timer(500, this);
    	timer.start();
    }
      
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(320,240);
        
        // clock face
        Paint paint = new GradientPaint(-150,-150,Color.white,150,150,Color.gray);
        g2.setPaint(paint);
        g2.fillOval(-190, -190, 380, 380);
        g2.setColor(Color.gray);
    	// g2.drawString("Java 2D", -20, 80);
        Stroke stroke = new BasicStroke(3);
        g2.setStroke(stroke);
        g2.drawOval(-190, -190, 380, 380);
        
        for (int i = 0; i < 12; i++) {
          g2.rotate(2*Math.PI/12);
          g2.fill3DRect(-3, -180, 6, 30, true);
        }
        
        // clock hands
        Shape hour = new Line2D.Double(0, 0, 0, -80);
        hour = rotH.createTransformedShape(hour);
        Shape minute = new Line2D.Double(0, 0, 0, -120);
        minute = rotM.createTransformedShape(minute);
        Shape second = new Line2D.Double(0, 0, 0, -120);
        second = rotS.createTransformedShape(second);
       
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        
        g2.draw(hour);
        g2.draw(minute);
        g2.setStroke(new BasicStroke(2));
        g2.draw(second);
        
        // Draw schedule
        Act currentAct = schedule.getCurrentAct();
        Act nextAct = schedule.getNextAct();
        
        //currentAct.getName();
        //nextAct.getName();
        
        // DRAW
        
    }
  
	public void actionPerformed(ActionEvent e) {

        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
        int sec = Calendar.getInstance().get(Calendar.SECOND);
        rotH.setToRotation(Math.PI * (hour+min/60.0)/6.0);
        rotM.setToRotation(Math.PI * min /30.0);
        rotS.setToRotation(Math.PI * sec /30.0);
        schedule.update(hour, min);
        
        repaint();
	}

	public ConcertSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(ConcertSchedule schedule) {
		this.schedule = schedule;
		int hour = Calendar.getInstance().get(Calendar.HOUR);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
        schedule.update(hour, min);
	}
	
}