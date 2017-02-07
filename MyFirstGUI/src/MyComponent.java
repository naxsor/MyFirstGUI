import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	static int counter = 0;

	public void paintComponent(Graphics g) {

		Car car1 = new Car(0,0, Color.RED);
		Car car2 = new Car(0,40, Color.BLUE);
		
		car1.draw(g);
		car2.draw(g);
		
		System.out.println("Painted " + counter++ + " times");
	}

}
