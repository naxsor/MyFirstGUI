import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) throws InterruptedException {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(800, 600);
		mainFrame.setTitle("Master Race");
		
		int numCars = mainFrame.getHeight() / MyComponent.laneHeight;
		
		MyComponent theComponent = new MyComponent(numCars);
		mainFrame.add(theComponent);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (!theComponent.getSomeCarWon()) {
			mainFrame.repaint();
			Thread.sleep(100);
		}
	}
}
