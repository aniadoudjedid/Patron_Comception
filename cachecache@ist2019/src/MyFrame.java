

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements MouseMotionListener, ActionListener{
	
	  private  Point point = new Point(200, 400);
	  private Cachette tabCachettes[];
	
	  private JButton exitFrame;
	  private JButton hideFrame;
	
	  private JButton backButton;	  
	  private JButton userButton;
	  private JButton settingButton;
	  private JButton aboutButton;
	  private JButton closeButton;
	  
	  private JPanel paneauCachettes;
	  private JPanel paneauLateral = new JPanel();
	  
	  private JPanel aboutPanel ;
	  private JPanel settingPanel;
	  private JPanel userPanel;
	  
	  private JLabel userIconLabel; 
	  private JLabel usernameLabel;
	  private JLabel creditLabel; 
	  
	  private JLabel usernameLabel2 ;
	  private JLabel userCreditLabel2; 
	  
	  
	
	  
	  
	  
	  /*  CONSTRUCTEUR */
	
	
	public MyFrame(Cachette tabCachettes[])
	{
		this.tabCachettes = tabCachettes;
		
		
		this.userIconLabel = new JLabel(MyImages.getUser());
		this.userIconLabel.setBounds(50, 3, 40, 40);
		this.add(this.userIconLabel);
		
		this.usernameLabel = new JLabel();
		this.usernameLabel.setBounds(95, 3, 150, 20);
		this.add(this.usernameLabel);
		
		this.creditLabel = new JLabel();
		this.creditLabel.setForeground(Color.BLUE);
		this.creditLabel.setBounds(95, 20, 150, 20);
		this.add(this.creditLabel);
		
	
		
		
		
	
		/* PROPRIETE DE LA FENETRE */
		
		this.setUndecorated(true);
		this.setLayout(null);
		this.setSize(800, 537);
		
		
		this.addMouseMotionListener(this);
		
		
		/* BOUTTON DE FERMETURE ET REDUICTION DE LA FENETRE */
		
		this.exitFrame = new JButton("");
		this.hideFrame = new JButton("");
		
		this.exitFrame.setActionCommand("exitFrame");
		this.hideFrame.setActionCommand("hideFrame");
		
		this.exitFrame.setContentAreaFilled(false);
		this.hideFrame.setContentAreaFilled(false);
		
		this.exitFrame.setFocusPainted(false);
		this.hideFrame.setFocusPainted(false);
		
		this.exitFrame.setIcon(MyImages.getExitframeicon());
		this.hideFrame.setIcon(MyImages.getHideframeicon());
		
		this.exitFrame.setRolloverEnabled(true);
		this.hideFrame.setRolloverEnabled(true);
		
		this.exitFrame.setRolloverIcon(MyImages.getHoverexitframeicon());
		this.hideFrame.setRolloverIcon(MyImages.getHoverhideframeicon());
		
		this.exitFrame.setBorder(null);
		this.hideFrame.setBorder(null);
		
		this.exitFrame.setBounds(758, 0, 42, 42);
		this.hideFrame.setBounds(715, 0, 42, 42);
		
		this.exitFrame.addActionListener(this);
		this.hideFrame.addActionListener(this);
		
		this.getContentPane().add(exitFrame);
		this.getContentPane().add(hideFrame);
		
		/* PANEAU LATTERAL DE MENU*/
		this.paneauLateral.setLayout(null);
		this.paneauLateral .setBounds(2, 2, 40, 533);
		this.paneauLateral.setBackground(new Color(164, 164, 164));
		
		
		/* BOUTTONs LATTERALES DE MENU*/
		
		 this.backButton = new JButton();
		 this.userButton = new JButton();
		 this.userButton = new JButton();
		 this.settingButton = new JButton();
		 this.closeButton = new JButton();
		 this.aboutButton = new JButton();
		 
		 this.backButton.setActionCommand("backButton");
		 this.userButton.setActionCommand("userIcon");
		 this.userButton.setActionCommand("userButton");
		 this.settingButton.setActionCommand("settingButton");
		 this.closeButton.setActionCommand("closeButton");
		 this.aboutButton.setActionCommand("aboutButton");
		 
	
		 this.backButton.setIcon(MyImages.getBackbuttonicon());
		 this.userButton.setIcon(MyImages.getUsericon());
		 this.settingButton.setIcon(MyImages.getSettingbuttonicon());
		 //this.closeButton.setIcon();
		 this.aboutButton.setIcon(MyImages.getAboutbuttonion());
		 this.closeButton.setIcon(MyImages.getExitframeicon());
		 
		 this.backButton.setRolloverEnabled(true);
		 this.userButton.setRolloverEnabled(true);
		 this.settingButton.setRolloverEnabled(true);
		 this.closeButton.setRolloverEnabled(true);
		 this.aboutButton.setRolloverEnabled(true);
		 
		 this.backButton.setContentAreaFilled(false);
		 this.userButton.setContentAreaFilled(false);
		 this.settingButton.setContentAreaFilled(false);
		 this.closeButton.setContentAreaFilled(false);
		 this.aboutButton.setContentAreaFilled(false);
		 
		 this.backButton.setFocusPainted(false);
		 this.userButton.setFocusPainted(false);
		 this.settingButton.setFocusPainted(false);
		 this.closeButton.setFocusPainted(false);
		 this.aboutButton.setFocusPainted(false);

				 
		 this.backButton.addActionListener(this);
		 this.userButton.addActionListener(this);
		 this.settingButton.addActionListener(this);
		 this.closeButton.addActionListener(this);
		 this.aboutButton.addActionListener(this);
		
		 
	     this.backButton.setBounds(2, 0, 40, 40);
	     this.userButton.setBounds(0, 40, 40, 40);
		 this.settingButton.setBounds(0, 82, 40, 40);
		 this.aboutButton.setBounds(0,124, 40, 40);
		 this.closeButton.setBounds(0, 494, 40, 40);
		 
		 
		
		 
		 
		 this.add(this.backButton);
		 this.paneauLateral.add(this.userButton);
		 this.paneauLateral.add(this.settingButton);
		 this.paneauLateral.add(this.aboutButton);
		 this.paneauLateral.add(this.closeButton);
		 
		 /* PANEAU */
		 
			//--------------------------------------
		 	
		 	this.userPanel = new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.drawImage(MyImages.getUsericon80x80().getImage(), 120, 100, null);
				}
			};
			this.userPanel.setSize(300, 534);
			this.userPanel.setLocation(1, 1);
			this.userPanel.setBackground(Color.LIGHT_GRAY);
			this.userPanel.setVisible(false);
			this.userPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(0, 120, 215)));
			this.userPanel.setLayout(null);
			
			this.usernameLabel2 = new JLabel();
			this.usernameLabel2.setFont(new Font ("serif", Font.BOLD, 20));
			this.usernameLabel2.setBounds(80, 100, 150, 200);
			this.userPanel.add(this.usernameLabel2);
			
			this.userCreditLabel2 = new JLabel();
			this.userCreditLabel2.setFont(new Font ("serif", Font.BOLD, 14));
			this.userCreditLabel2.setBounds(130, 165, 100, 100);
			this.userPanel.add(this.userCreditLabel2);
			
			
			this.add(this.userPanel);
		 
		 
		   // -------------------------------------------
			
			this.aboutPanel = new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.drawImage(MyImages.getInformation80x80().getImage(), 120, 20, null);
				}
			};
			
			
			this.aboutPanel.setSize(300, 534);
			this.aboutPanel.setLocation(1, 1);
			this.aboutPanel.setLayout(null);
			this.aboutPanel.setBackground(Color.LIGHT_GRAY);
			this.aboutPanel.setVisible(false);
			this.aboutPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(0, 120, 215)));
			
			
			JLabel aboutLabel = new JLabel("CACHE CACHE");
			aboutLabel.setFont(new Font ("serif", Font.BOLD, 20));
			aboutLabel.setBounds(80, 100, 150, 100);
			this.aboutPanel.add(aboutLabel);
			
			JLabel info = new JLabel("IST");
			info.setFont(new Font ("serif", Font.BOLD, 14));
			
			info.setBounds(130, 200, 40, 20);
			this.aboutPanel.add(info);
		
			
			JLabel info1 = new JLabel("<html>par abdoulfataohfataoh, abdoulaziz </html>");
			info.setFont(new Font ("serif", Font.BOLD, 16));
			
			info1.setBounds(15, 210, 298, 40);
			this.aboutPanel.add(info1);
		
			
			
			
			
			
			
			this.add(this.aboutPanel);
			
			//----------------------------------------------------
			this.settingPanel = new JPanel()
			{
				
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.drawImage(MyImages.getSettingicon80x80().getImage(), 120, 20, null);
				}
			};
			this.settingPanel.setSize(300, 534);
			this.settingPanel.setLayout(null);
			this.settingPanel.setLocation(1, 1);
			this.settingPanel.setBackground(Color.LIGHT_GRAY);
			this.settingPanel.setVisible(false);
			this.settingPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(0, 120, 215)));
			
			JLabel settingLabel = new JLabel("PARAMETRE");
			settingLabel.setFont(new Font ("serif", Font.BOLD, 20));
			settingLabel.setBounds(80, 100, 150, 100);
			this.settingPanel.add(settingLabel);
			
			
			this.add(this.settingPanel);
			
			
			
			//--------------------------------------
		
		
		
	     	JPanel p1 = new JPanel(){
			public void paintComponent(Graphics g)
			{
			 super.paintComponent(g);
			 g.drawImage(MyImages.watter1.getImage(),0, 0, null);
			 
			}
		};
		p1.setBounds(0, 0, 800, 537);
		p1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 120, 215)));
		
		/* PANEAU CONTENANT LES CACHETTES */
			
		this.paneauCachettes = new JPanel();
		this.paneauCachettes.setBounds(220, 30, 500, 500);
		this.paneauCachettes.setLayout(new GridLayout(3,3,10, 10));
		this.paneauCachettes.setOpaque(false);
		
		
		for(int i=0; i<tabCachettes.length; i++)
		{
			tabCachettes[i] = new Cachette(""+i, MyImages.getDefaultcachetteicon(), 40, 40, MyImages.getHovercachetteicon());
			this.paneauCachettes.add(tabCachettes[i]);
			
		}

		this.add(this.paneauCachettes);
		this.add(paneauLateral);
		this.add(p1); 
		
		/*CENTRER LA FENETRE */
		this.setLocation(MyToolKit.centerFrameOnScreenPosition(this.getSize()));
	
		
			
	}
	
	public void setUsernameLabel(String username)
	{
		this.usernameLabel.setText(username);
		this.usernameLabel2.setText(username);
	}
	
	public void setCredit(double credit)
	{
		this.creditLabel.setText("credit : "+(int)credit+" F");
		this.userCreditLabel2.setText((int)credit+" F");
	}
	
	
	
	
		
		public void mouseMoved(MouseEvent ev)
		{
			
		}
		
		public void mouseDragged(MouseEvent ev)
		{
			this.setLocation(ev.getXOnScreen() , ev.getYOnScreen());
		}
		
		public void actionPerformed(ActionEvent ev)
		{
			String actionCommande = ev.getActionCommand();
			
			
	        System.out.println(actionCommande);
			
			
			if (actionCommande.equals("exitFrame") == false && actionCommande.equals("hideFrame") == false && actionCommande.equals("backButton") == false  )
			 {
				 this.paneauLateral.setVisible(false);
				
			 }
			
			switch(actionCommande)
			{
				case "exitFrame" : System.exit(ABORT);
				break;
				
				case "hideFrame" : ;
				break;
				
				case "backButton" : this.userPanel.setVisible(false);
									this.aboutPanel.setVisible(false);
									this.settingPanel.setVisible(false);
									this.paneauLateral.setVisible(true);
									this.userIconLabel.setVisible(true);
									this.usernameLabel.setVisible(true);
									this.creditLabel.setVisible(true);
				break;
				
				case "userButton" : this.userPanel.setVisible(true);
									this.userIconLabel.setVisible(false);
									this.usernameLabel.setVisible(false);
									this.creditLabel.setVisible(false);
				break;
				
				case "settingButton" : this.settingPanel.setVisible(true);
										this.userIconLabel.setVisible(false);
										this.usernameLabel.setVisible(false);
										this.creditLabel.setVisible(false);
				break;
				
				case "aboutButton" : this.aboutPanel.setVisible(true);
										this.userIconLabel.setVisible(false);
										this.usernameLabel.setVisible(false);
										this.creditLabel.setVisible(false);
				break;
				
				case "closeButton" : System.exit(ABORT);
				
				break;
				
				
			}
			
			
		
		}

}






