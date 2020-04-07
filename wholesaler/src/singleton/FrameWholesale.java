package singleton;
import javax.swing.JFrame;
public class FrameWholesale {
	private static JFrame frame;
	private static FrameWholesale single = new FrameWholesale();
	private FrameWholesale() {
		try {
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		catch (Exception e2) {
			e2.printStackTrace();
		}
	};
	public static JFrame getObj(){
		if (single==null)
		{
			single = new FrameWholesale();
		}
		return frame;
	}

}
//frame.getObj().setVisible(true); code a utilisé lors de l'action performed 

