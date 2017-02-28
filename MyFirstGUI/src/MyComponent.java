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
	
	static MutableCar theCar = new MutableCar(0,0,Color.BLACK);

	public void paintComponent(Graphics g) {

		theCar.setPosition(0, 0);
		theCar.draw(g);
		
		//MutableCar car2 = new MutableCar(0,40, Color.BLUE);
		theCar.setPosition(0, 40);
		theCar.draw(g);
		
		System.out.println("Painted " + counter++ + " times");
	}

}
