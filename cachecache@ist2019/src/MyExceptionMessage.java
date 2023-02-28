import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class MyExceptionMessage extends JFrame{
	
	
	public MyExceptionMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "ERREUR", JOptionPane.ERROR_MESSAGE);

	}
	
	
}