
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Partie implements ActionListener{
	
	private Joueur joueur; 
	private MyFrame fenetrePrincipale;
	private int nClic;
	
	/* LES DIFFERENTES CACHETTES  */
	Cachette tabCachettes[];
	
	/* VARIABLE DES VALEURS ALEATOIRES  */
	private int elue1;
	private int elue2;
	
	/* ETIQUETTE DE `SOLDE INSUFFISSANT` */
	 private JLabel soldeInsuffissanteLabel;
	
	
	
/***********************************************************************************************************
 * 	CONSTRUCTEUR
 ***********************************************************************************************************/
	
	Partie(Joueur joueur, Cachette tabCachettes[], MyFrame fenetrePrincipale)
	{
		this.joueur = joueur;
		this.tabCachettes = tabCachettes;
		this.fenetrePrincipale = fenetrePrincipale;
	

		
		
		
		this.soldeInsuffissanteLabel = new JLabel("SOLDE INSUFFISANT");
		this.soldeInsuffissanteLabel.setLocation(1, 1);
		this.soldeInsuffissanteLabel.setForeground(Color.RED);
		this.soldeInsuffissanteLabel.setFont( new Font ("Serif", Font.BOLD, 16));
		this.soldeInsuffissanteLabel.setBounds(120, 90, 180, 40);
		
		this.fenetrePrincipale.setUsernameLabel(this.joueur.getUsername());
		this.fenetrePrincipale.setCredit(this.joueur.getCredit());
		
		
		/* AJOUT DES ECOUTEURS D'EVENEMENTS DES CACHETTES */

		for(int i=0; i<tabCachettes.length; i++)
		{
			this.tabCachettes[i].addActionListener(this);
			this.tabCachettes[i].setEnabled(false);
		}
		
		
		
		
		
		/* APPEL DE LA METHODE INITIALISATION D'UNE PARTIE*/
		
		this.initialisation();
		
		
	}
	
	
/***********************************************************************************************************
*  LA METHODE INITIALISATION DE PARTIE
***********************************************************************************************************/
	
	private void  initialisation()
	{
		this.nClic = 0;
		
		
		
		// APPEL DE LA FENETRE DIALOGUE QUI RETOURNE UNE CHAINE DE COMMANDE
		
		if(this.fenetreDialogue().equals("jouer"))
		{
			// MISE 
			
			
			if (this.joueur.getUsername().equals(IdentifiantLocal.username) && this.joueur.getPassword().equals(IdentifiantLocal.password))
			{
				this.joueur.setCredit(this.joueur.getCredit() - 100);
				this.fenetrePrincipale.setCredit(this.joueur.getCredit());
			}
			else {
				MyDataBase.transaction(this.joueur.getUsername(), this.joueur.getPassword(), - 100);
				this.joueur.setCredit(this.joueur.getCredit() - 100);
				this.fenetrePrincipale.setCredit(this.joueur.getCredit());
				
			}
			
			
			/* 		GENERATION DE VALEURS ALEATOIRES DIFFERENTES		  */
			
			while ((this.elue1 = aleatoire()) == (this.elue2 = aleatoire()))
			{	
			}
		
			/*	ACTIVATION DES CACHETTES */
		
			for(int i=0; i<this.tabCachettes.length; i++)
			{
				this.tabCachettes[i].setEnabled(true);
				this.tabCachettes[i].setIcon(MyImages.getDefaultcachetteicon());
			}
			System.out.println("cachettes gagnants : "+(this.elue1+1)+" "+(this.elue2+1));
		}
		
	}
	
	
	/***********************************************************************************************************
	* GESTION DES CLIC SUR LES CACHETTES ET REGLES DU JEU
	***********************************************************************************************************/
	
	public void actionPerformed(ActionEvent ev)
	{
		this.nClic++;
		int i = Integer.parseInt(ev.getActionCommand());
		if(i == this.elue1  || i == this.elue2)
		{
			this.tabCachettes[i].setDisabledIcon(MyImages.getWincachetteicon());
			this.tabCachettes[i].setEnabled(false);
			System.out.println("Gagne");
			
			
			//ecriture dans la base de donne
		
			if (this.joueur.getUsername().equals(IdentifiantLocal.username) && this.joueur.getPassword().equals(IdentifiantLocal.password))
			{
				this.joueur.setCredit(this.joueur.getCredit() + 100);
				this.fenetrePrincipale.setCredit(this.joueur.getCredit());
			}
			else {
				
					MyDataBase.transaction(joueur.getUsername(), joueur.getPassword(), + 100);
					this.joueur.setCredit(this.joueur.getCredit() + 100);
					this.fenetrePrincipale.setCredit(this.joueur.getCredit());
					
				
				
			}

		}
		else {
			
			this.tabCachettes[i].setDisabledIcon(MyImages.getLosecachetteicon());
			this.tabCachettes[i].setEnabled(false);
			System.out.println("perdu");
		
			
			
		}
		
		System.out.println("solde :"+this.joueur.getCredit());//log
		
		if(this.nClic == 2)
		{
			this.initialisation();	
		}	
		
	}
	
	
/***********************************************************************************************************
 *   METHODE DE DIALOGUE (QUITTER / JOUEUR) verifier aussi le solde du joueur
 ***********************************************************************************************************/
	
	private String fenetreDialogue()
	{
		Dialog d = new Dialog(this.fenetrePrincipale, true) {
			
			public void actionPerformed(ActionEvent ev)
			{
			
				this.setVisible(false);
				if(ev.getActionCommand().equals("quitter")) { System.out.println("QUITTER"); System.exit(ABORT);}
				else super.setCommande(ev.getActionCommand());
			}
		};
		
		JPanel panneau = new JPanel() {
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(MyImages.getFont1().getImage(), 0, 0, null);
			}
		};
		panneau.setBounds(0, 0, 400, 200);
		panneau.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 120, 215)));
		panneau.setBackground(Color.white);
		panneau.setLayout(null);
		
		
		
		d.setLocation(this.fenetrePrincipale.getLocationOnScreen().x + 0, this.fenetrePrincipale.getLocationOnScreen().y + 150);
		
		JButton jouer = new JButton("jouer");
		jouer.setBackground(Color.green);
		jouer.addActionListener(d);
		jouer.setBounds(325, 165, 70, 30);
		jouer.setContentAreaFilled(false);
		jouer.setFocusPainted(false);
		jouer.setFont(new Font ("serif", Font.PLAIN, 10));
		
		
		JButton quitter = new JButton("quitter");
		quitter.addActionListener(d);
		quitter.setBounds(250, 165, 70, 30);
		quitter.setBackground(Color.ORANGE);
		quitter.setContentAreaFilled(false);
		quitter.setFocusPainted(false);
		quitter.setFont(new Font ("serif", Font.PLAIN, 10));
		
		
		d.getContentPane().add(quitter);
		d.getContentPane().add(jouer);
		
			
		/* VERIFICATION DU SOLDE */
				
		
		if(this.joueur.getUsername().equals(IdentifiantLocal.username) && this.joueur.getPassword().equals(IdentifiantLocal.password) )
		{	
			System.out.println(this.joueur.getCredit()); //log
			
			if (this.joueur.getCredit() <  100) 
			{
			 jouer.setEnabled(false);
			 d.getContentPane().add(this.soldeInsuffissanteLabel);
			 
			}
			
		}
		else if (MyDataBase.getCredit(this.joueur.getUsername(), this.joueur.getPassword()) < 100)
		{
			jouer.setEnabled(false);
			d.getContentPane().add(this.soldeInsuffissanteLabel);
			
		}
		
		
		
			
		
		d.getContentPane().add(panneau);
		d.setSize(400, 200);
		d.setVisible(true);
	
		
		
	//	condition
		return d.getActionCommande();	
	}
	
/***********************************************************************************************************
 *  LA METHODE aleatoire retourne une valeur aleatoire
 ***********************************************************************************************************/
	
	private int aleatoire()
	{
		//Min + (int)(Math.random() * ((Max - Min) + 1));
		return 0 + (int)(Math.random() * ((8 - 0) + 1));
	}
	
	


}























