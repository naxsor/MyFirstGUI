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

	private static int counter = 0;

	private static MutableCar theCars[];
	
	private static Random genRand = new Random();
	
	private boolean someCarWon = false;
	
	public static final int laneHeight = 30;
	
	public boolean getSomeCarWon(){return someCarWon;}
	
	public MyComponent(int numCars){
		theCars = new MutableCar[numCars];
		for(int i =0; i<numCars; i++){
			int laneY= i * laneHeight;
			theCars[i]=new MutableCar(0, laneY, Color.BLUE, 0, 1);
		}
	}

	public boolean carBumped(MutableCar c) {
		return ((c.getCarDirection() > 0) && (c.getxPos()+60 >= this.getWidth()) 
				|| 
				(c.getxPos() <= 0));
	}

	public boolean carReachedTopOrBottom(MutableCar c) {
		if (c.getCarDirectionY() > 0) {
			return (c.getyPos() + 30 > this.getHeight());
		}
		else {
			return (c.getyPos() - 30 < 0);
		}
	}


	public void paintComponent(Graphics g) {	
		
		int iMax = 1;
		for(int i=0; i < theCars.length; i++){
			theCars[i].draw(g);
			theCars[i].move(genRand.nextInt(10),0);
			theCars[i].setColor(Color.BLUE);		
			if(theCars[iMax].getxPos() < theCars[i].getxPos()){
				iMax=i;	
				
			}
			if (this.carBumped(theCars[iMax])) {
				this.someCarWon=true;
			}	
		}
		theCars[iMax].setColor(Color.RED);
		System.out.println("Painted " + counter++ + " times");
	}

}
