
import java.sql.*;

public class MyDataBase {
	
	/*
	 *  IDENTIFIANTS DE L'ADMINISTRATEUR
	 */
	
		private static  String AdminUsername = "TFVBHY";
		private static  String AdminPassword = "UHNMKI";
		private static  String url  = "jdbc:mysql://localhost:3306/cache_cache";
		
		private static  Connection connection;
		private static  Statement statement;
		private static  ResultSet resulset = null;
		
		
		
		public MyDataBase()
		{
			System.out.println("construction de l'objet mydatabase");
	
			try {
				 connection = DriverManager.getConnection(url, AdminUsername, AdminPassword);
				 statement = connection.createStatement();
				 
				}  catch (SQLException e) {new MyExceptionMessage("Echec de Connection a la BASE de DONNEES"); /*e.printStackTrace();*/}
				 
			
		}
		
		
		
		public static  boolean authentification(String username, String password) throws java.lang.NullPointerException
		{
			System.out.println("authentification");
			
			String syntaxeSQL = "SELECT username, password FROM utilisateurs WHERE username  ='"+username+"' AND password = '"+password+"';";
			
			try {
					resulset = statement.executeQuery(syntaxeSQL);
					if(resulset.next() && resulset.getString(1).equals(username) && resulset.getString(2).equals(password))
					  {
						return true; 
					  }
				 
				} catch (SQLException e) {  /*new MyExceptionMessage("authentification");e.printStackTrace();*/;return false;}
			      catch(java.lang.NullPointerException e ) {System.out.println("NULL"); }
			
			return false;
					
			
		}
		

		public static String getId(String username, String password)
		{
			System.out.println("getId");
			
			String syntaxeSQL = "SELECT id FROM utilisateurs WHERE username  ='"+username+"' AND password = '"+password+"';";
			
			try {
				 resulset = statement.executeQuery(syntaxeSQL);
				 if(resulset.next())
				  {
					return resulset.getString(1);
				  }
				 
				} catch (SQLException e) { new MyExceptionMessage("Impossible d'obtenir l'id du joueur"); System.exit(-1);/*e.printStackTrace();*/}
			
			
			return null;
		}
		
		public static double getCredit(String username, String password)
		{
			
			String syntaxeSQL = "SELECT credit FROM utilisateurs WHERE username ='" +username+ "' AND password ='" +password+ "';";
			
			try {
				 resulset = statement.executeQuery(syntaxeSQL);
				 if(resulset.next())
				  {
					return resulset.getDouble(1);
				  }
				 
				 
				} catch (SQLException e) { new MyExceptionMessage("Impossible  d'obtenir lesolde du joueur");System.exit(-1); /*e.printStackTrace();*/}
			
			return 0;
		}

	
		
		public static void transaction(String username, String password, double montant)
		{
			
			System.out.println("transaction");
			
			String syntaxeSQL = "UPDATE utilisateurs SET credit = credit + "+montant+ " WHERE username = '"+username+"' AND password = '"+password+"' ;" ;
			
			
			try {
				  statement.executeUpdate(syntaxeSQL);
				} catch (SQLException e) { new MyExceptionMessage("Transaction Impossible"); System.exit(-1);/*e.printStackTrace();*/}	
		}
		
		
		
	 
}









