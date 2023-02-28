

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyLoginSystem  extends MyDialog implements ActionListener{
	
	private Joueur joueur;
		
	private JPanel paneau;
	
	/* CHAMPS DE SAISIE */

	private MyTextField usernameField;
	private MyPasswordField passwordField;
	private MyTextField oldField;
	
	/* BOUTTON VALIDER */
	
	private MyButton validate;
	
	
	
	public MyLoginSystem (Joueur joueur, JFrame parent, boolean modalite)
	{
		
		super(parent, modalite);
		this.setSize(550, 400);
		
		this.joueur = joueur;
	
		this.paneau= new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(MyImages.getUserloginfont().getImage(), 0, 0, null);
				
			}
		};
		
		this.paneau.setFocusable(true);
		this.paneau.setLayout(null);
		this.paneau.setBackground(Color.WHITE);
		this.paneau.setSize(550,450);
		this.paneau.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 120, 215)));
		
		
		/* AJOUT DES DIFFERENTS CHAMPS ET POSITIONNEMENT MANUEL*/
		
		this.usernameField = new MyTextField("username");
		this.paneau.add(this.usernameField);
		this.usernameField.setBounds(125, 190, 300, 30);
		
		
		this.passwordField = new MyPasswordField("password");
		this.paneau.add(this.passwordField);
		this.passwordField.setBounds(125, 280, 150, 30);
		this.passwordField.requestFocus();
		
		
		this.oldField = new MyTextField("old (facultatif)");
		this.paneau.add(this.oldField);
		this.oldField.setBounds(295, 280, 130, 30);
		
		
		this.validate = new MyButton("validate",MyImages.getValidatebuttonicon(), 42, 42);
		this.validate.setBorder(null);
		this.validate.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
		this.paneau.add(this.validate);
		this.validate.setBounds(480, 350, 42, 42);
		this.validate.addActionListener(this);
		
		/* CENTRER LA FENETRE */
		this.setLocation(MyToolKit.centerFrameOnScreenPosition(this.getSize()));
	
		this.getContentPane().add(this.paneau);
	}
	
	
	
		public void actionPerformed(ActionEvent ev)
		{
		
			if (ev.getActionCommand().equals("validate") == true);
			{
				
				if(this.usernameField.getText().equals(IdentifiantLocal.username) && this.passwordField.getText().equals(IdentifiantLocal.password))
				{
					
					this.joueur.setUsername(this.usernameField.getText());
					this.joueur.setPassword(this.passwordField.getText());
					this.joueur.setCredit(IdentifiantLocal.credit);
					
					this.dispose();
				}
			
				else if (MyDataBase.authentification(this.usernameField.getText(), this.passwordField.getText()) == true)
				{
					this.joueur.setUsername(this.usernameField.getText());
					this.joueur.setPassword(this.passwordField.getText());
					this.joueur.setCredit(MyDataBase.getCredit(this.joueur.getUsername(), this.joueur.getPassword()));
					
					this.dispose();
					
				
				}
				
				
				else {
					
					this.paneau.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					JLabel echec = new JLabel("echec d'authentification");
					echec.setForeground(Color.RED);
					echec.setBounds(200, 380, 200, 20);
					this.paneau.add(echec);
					
				}
			}
		
		}
		
}







