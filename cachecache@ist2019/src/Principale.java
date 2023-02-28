

public class Principale{      
	
	
	public static void main(String args[])
	{
		new MyToolKit();
		
		//Intanciation des objets
		
	    Joueur	 joueur = new Joueur();
		Cachette[] tabCachettes = new Cachette[9];
		MyFrame fenetrePrincipale = new MyFrame(tabCachettes);
		
		new MyDataBase();
		
		MyLoginSystem fenetreDeconnexion = new MyLoginSystem(joueur, fenetrePrincipale, true);
		fenetreDeconnexion.setVisible(true);
		fenetrePrincipale.setVisible(true);	
		new Partie(joueur, tabCachettes , fenetrePrincipale);
	
	
		

		
			
	}
}





















