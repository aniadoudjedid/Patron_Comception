


import javax.swing.ImageIcon;

public class Cachette extends MyButton{
	
	
	public Cachette(String actionCommade, ImageIcon defaultButtonIcon, int largeur, int hauteur, ImageIcon hoverButtonIcon) {
		
		super(actionCommade, defaultButtonIcon, largeur, hauteur);

		this.setRolloverEnabled(true);
		this.setRolloverIcon(hoverButtonIcon);
		
		
	}
	
	
}