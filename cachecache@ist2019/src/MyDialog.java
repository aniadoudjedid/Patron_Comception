
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MyDialog extends JDialog implements  MouseMotionListener, ActionListener {
	
	

	
	public MyDialog(JFrame fenetre, boolean modalite)
	{
		super(fenetre, modalite);
		this.setUndecorated(true);
		this.addMouseMotionListener(this);
		
	}
	
	public void mouseMoved(MouseEvent ev)
	{
		
	}
	
	public void mouseDragged(MouseEvent ev)
	{
		this.setLocation(ev.getXOnScreen() , ev.getYOnScreen());
	}
	
	public  void actionPerformed(ActionEvent ev)
	{
		
	}
}
