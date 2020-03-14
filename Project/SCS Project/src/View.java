import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*; 

public class View extends javax.swing.JFrame{
	
	
	public View() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes = Shape.getShapesCoordFromFile();
		for(int i=0; i<shapes.size(); i++) {
			shapes.get(i).draw(g);
		}
		/*shapes.get(0).drawFigure(g);
		shapes.get(1).drawLine(g);
		shapes.get(2).drawArc(g);
		shapes.get(3).drawArc(g);*/
		
		/*int[] p1 = {300,100};
		int[] center = {450,10};
		int[] p3 = {400,200};
		double x = (center[0] - Math.pow(0.5, 2) * p1[0] - Math.pow(0.5, 2) * p3[0] ) / (2*(0.5) * 0.5);
		double y = (center[1] - Math.pow(0.5, 2) * p1[1] - Math.pow(0.5, 2) * p3[1] ) / (2*(0.5) * 0.5);
		QuadCurve2D curve = new QuadCurve2D.Double(p1[0], p1[1], x, y, p3[0], p3[1]);
		Shape.drawTest(g, curve);*/
		
		/*g.drawArc(300, 100, 120, 120, 0, -90);
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//g.drawArc(300, 30, 120, 120, 0, -90); 
	}
	
	public static void main(String args[]) {
		View view = new View();
		
	}
}
  