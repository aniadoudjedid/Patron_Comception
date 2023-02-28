import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;



public class MyToolKit {
	
	private static Dimension screenMiddle;
	private static Dimension screenSize;
	
	
	public MyToolKit()
	{
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMiddle = new Dimension(screenSize.width / 2, screenSize.height / 2);
	}
	
	
	public static Dimension getScreenSize() {
		return screenSize;
	}


	public static Dimension getScreenMiddle() {
		return screenMiddle;
	}
	public static Point centerFrameOnScreenPosition(int width, int height)
	{
		return new Point(screenMiddle.width - (width / 2), screenMiddle.height - (height / 2));
	}
	
	public static Point centerFrameOnScreenPosition(Dimension d)
	{
		return new Point(screenMiddle.width - (d.width / 2), screenMiddle.height - (d.height / 2));
	}
	
	

	
	
		

}






