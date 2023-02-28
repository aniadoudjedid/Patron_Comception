
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dialog extends JDialog implements ActionListener{
	
	private String commande;

	
	public Dialog(JFrame fenetreParent, boolean modal)
	{
		super(fenetreParent, modal);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		
		
		this.setLayout(null);
		
	}

	public  void actionPerformed(ActionEvent ev)
	{
		this.commande = ev.getActionCommand();
	}
	public String  getActionCommande()
	{
		if (this.commande == null) return "";
		else return this.commande;
		
	}

	public void setCommande(String commande) {
		this.commande = commande;
	}
	
}























