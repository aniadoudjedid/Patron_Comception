
import javax.swing.*;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;



public class MyPasswordField extends JPanel implements FocusListener, ActionListener {
	

	private JPasswordField champ = new JPasswordField(20);
	private String defaultText;
	
	 
	public MyPasswordField (String defaultText)
	
	{
		
		this.defaultText = new String (defaultText);

		this.setPreferredSize(new Dimension(280, 30));
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(122,122,122)));
		this.setLayout(new BorderLayout());
		
		champ.setBorder(null);
		champ.setForeground(Color.gray);
		champ.setText(this.defaultText);
		champ.addFocusListener(this);
		champ.addActionListener(this);
		champ.setBackground(null);
		champ.setBackground(Color.WHITE);
		
		
	    this.add(champ);
    
	}
	
	
	
	///fin constructeur
	
	
	public String getText()
	{
		if (!this.champ.getText().equals(this.defaultText)) 
		{
			return this.champ.getText();	
		}
		else return "";		
	}
	
	
	public void set_Background(Color arg)
	{
		this.champ.setBackground(arg);
	}
	
	public void setForegroung(Color arg)
	{
		this.champ.setForeground(arg);
	}
	
	
	public void focusGained(FocusEvent ev)
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));
		if (this.champ.getText().equals(this.defaultText)) 
		{
			this.champ.setText("");
		}
		
	}
	
	public void focusLost(FocusEvent ev)
	{
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(122,122,122)));
		if (this.champ.getText().equals("")) 
		{
			this.champ.setText(this.defaultText);
		}
		else getText();
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
