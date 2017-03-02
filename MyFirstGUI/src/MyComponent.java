import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	static int counter = 0;
	
	static MutableCar theCar = new MutableCar(0,0,Color.BLACK, 10, 1);
	static Random genRand = new Random();

	public boolean carCrashed(MutableCar c) {
		if (c.getCarDirection() > 0) {
			if (c.getxPos()+60 >= this.getWidth()) {
				return true;
			}
		}
		else if (c.getCarDirection() < 0) {
			if (c.getxPos() <= 0) {
				return true;
			}			
		}
		
		return false;
		
	}
	
	public void paintComponent(Graphics g) {		
			
		theCar.draw(g);
		theCar.move(theCar.getCarSpeed()*theCar.getCarDirection(), 0);
		
		if (this.carCrashed(theCar)) {
			theCar.setCarDirection(theCar.getCarDirection()*-1);
		}
		
//		//MutableCar car2 = new MutableCar(0,40, Color.BLUE);
//		theCar.setPosition(0, 40);
//		theCar.draw(g);
		
		System.out.println("Painted " + counter++ + " times");
	}

}
