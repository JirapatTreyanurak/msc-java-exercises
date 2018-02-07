import javax.swing.JFrame;

/**
 * We build the JFrame here using the Model and the View
 */
public class MainFrame {
	
	public static void main (String[] a) {
		//Model model = new Model("words");
		Model model = new Model("/usr/share/dict/words");
		JFrame application = new JFrame();
		
		application.setTitle("Simple Predictive Text");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setResizable(false);
		application.add(new View(model));
		application.pack();
		application.setVisible(true);
	}
	
}