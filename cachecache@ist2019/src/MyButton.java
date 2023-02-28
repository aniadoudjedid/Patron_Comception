

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	
	
	
	public MyButton(String actionCommade, ImageIcon defaultButtonIcon) {
		

		super.setActionCommand(actionCommade);
		super.setIcon(defaultButtonIcon);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		
	}
	
	public MyButton(String actionCommade, ImageIcon defaultButtonIcon, int largeur, int hauteur )
	{
		
		super.setActionCommand(actionCommade);
		super.setIcon(defaultButtonIcon);
		super.setSize(largeur, hauteur);

		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

		
	}
	
}

	
	
	
	
	
	
	