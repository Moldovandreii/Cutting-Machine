import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Shape {
	private ArrayList<Point> points = new ArrayList<Point>();
	
	public Shape(ArrayList<Point> points) {
		this.points = points;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		String callerClassName = getClass().getSimpleName();
		int pause = 10;
		if(callerClassName.equals("Line"))
		{
			g2.setColor(Color.BLACK);
			for(int i=0; i<points.size(); i++) {
				try {
					g2.drawLine(points.get(i).getX(), points.get(i).getY(), points.get(i).getX(), points.get(i).getY());
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(callerClassName.equals("Figure"))
		{
			g2.setColor(Color.BLUE);
			int xPoints[] = new int[10];
			int yPoints[] = new int[10];
			int nPoints = points.size();
			for(int i=0; i<points.size(); i++) {
				xPoints[i] = points.get(i).getX();
				yPoints[i] = points.get(i).getY();
			}
			g2.fillPolygon(xPoints, yPoints, nPoints);
		}
		if(callerClassName.equals("Arc"))
		{
			g2.setColor(Color.BLACK);
			int angle = points.get(points.size()-1).getY();
			int x = points.get(0).getX();
			int y = points.get(0).getY();
			if(angle == 45)
			{
				x = points.get(0).getX() - 97;
				y = points.get(0).getY() - 15;
			}
			if(angle == -45)
			{
				x = points.get(0).getX() - 120;
				y = points.get(0).getY() - 50;
			}
			if(angle == 90)
			{
				x = points.get(0).getX() - 50;
				y = points.get(0).getY();
			}
			if(angle == -90)
			{
				x = points.get(0).getX() - 120;
				y = points.get(0).getY() - 50;
			}
			if(angle == -180)
			{
				x = points.get(0).getX();
				y = points.get(0).getY() - 50;
			}
			if(angle == 180)
			{
				x = points.get(0).getX();
				y = points.get(0).getY() - 60;
			}
			if(angle == 360)
			{
				x = points.get(0).getX();
				y = points.get(0).getY() - 60;
			}
			if(angle == -360)
			{
				x = points.get(0).getX();
				y = points.get(0).getY() - 60;
			}
			int width = points.get(1).getX();
			int height = points.get(1).getY();
			for(int i=2; i<points.size(); i++) {
				try {
					g2.drawArc(x, y, width, height, points.get(i).getX(), points.get(i).getY());
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*public void drawLine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLACK);
		for(int i=0; i<points.size(); i++) {
			try {
				g2.drawLine(points.get(i).getX(), points.get(i).getY(), points.get(i).getX(), points.get(i).getY());
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void drawFigure(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLUE);
		int xPoints[] = new int[10];
		int yPoints[] = new int[10];
		int nPoints = points.size();
		for(int i=0; i<points.size(); i++) {
			xPoints[i] = points.get(i).getX();
			yPoints[i] = points.get(i).getY();
		}
		g2.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	public void drawArc(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLACK);
		int angle = points.get(points.size()-1).getY();
		//System.out.println(angle);
		int x = points.get(0).getX();
		int y = points.get(0).getY();
		if(angle == 45)
		{
			x = points.get(0).getX() - 97;
			y = points.get(0).getY() - 15;
		}
		if(angle == -45)
		{
			x = points.get(0).getX() - 120;
			y = points.get(0).getY() - 50;
		}
		if(angle == 90)
		{
			x = points.get(0).getX() - 50;
			y = points.get(0).getY();
		}
		if(angle == -90)
		{
			x = points.get(0).getX() - 120;
			y = points.get(0).getY() - 50;
		}
		if(angle == -180)
		{
			x = points.get(0).getX();
			y = points.get(0).getY() - 50;
		}
		if(angle == 180)
		{
			x = points.get(0).getX();
			y = points.get(0).getY() - 60;
		}
		if(angle == 360)
		{
			x = points.get(0).getX();
			y = points.get(0).getY() - 60;
		}
		if(angle == -360)
		{
			x = points.get(0).getX();
			y = points.get(0).getY() - 60;
		}
		int width = points.get(1).getX();
		int height = points.get(1).getY();
		for(int i=2; i<points.size(); i++) {
			try {
				g2.drawArc(x, y, width, height, points.get(i).getX(), points.get(i).getY());
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	static void drawTest(Graphics g, QuadCurve2D curve) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.draw(curve);
	} */
	
	static ArrayList<Shape> getShapesCoordFromFile() {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		try {
			File file = new File("C:\\Users\\Andrei\\Desktop\\An3\\SCS\\Project\\SCS Project\\coordinates.txt");
			Scanner s = new Scanner(file);
			while(s.hasNextLine()) {
				String text = s.nextLine();
				if(text.charAt(0) == 'L')
				{
					int coords[] = new int[5];
					int pos = 0;
					for(int i=0; i<text.length(); i++) {
						if(Character.isDigit(text.charAt(i)))
						{
							if(Character.isDigit(text.charAt(i+1)))
							{
								if(Character.isDigit(text.charAt(i+2)))
								{
									coords[pos] = (text.charAt(i) - '0') * 100 + (text.charAt(i+1) - '0') * 10 + (text.charAt(i+2) - '0');
									pos++;
									i=i+2;
								}
								else
								{
									coords[pos] = (text.charAt(i) - '0') * 10 + (text.charAt(i+1) - '0');
									pos++;
									i=i+1;
								}
							}
							else
							{
								coords[pos] = text.charAt(i) - '0';
								pos++;
							}
						}
					}
					ArrayList<Point> line = Line.createLine(coords[0], coords[1], coords[2], coords[3]);
					Shape s1 = new Line(line);
					shapes.add(s1);
				}
				if(text.charAt(0) == 'A')
				{
					int coords[] = new int[8];
					int pos = 0;
					int aux = 0;
					for(int i=0; i<text.length(); i++) {
						if(Character.isDigit(text.charAt(i)))
						{
							if(text.charAt(i-1) == '-')
							{
								aux = 1;
							}
							if(Character.isDigit(text.charAt(i+1)))
							{
								if(Character.isDigit(text.charAt(i+2)))
								{
									coords[pos] = (text.charAt(i) - '0') * 100 + (text.charAt(i+1) - '0') * 10 + (text.charAt(i+2) - '0');
									if(aux == 1)
									{
										coords[pos] = coords[pos] * (-1);
										aux = 0;
									}
									pos++;
									i=i+2;
								}
								else
								{
									coords[pos] = (text.charAt(i) - '0') * 10 + (text.charAt(i+1) - '0');
									if(aux == 1)
									{
										coords[pos] = coords[pos] * (-1);
										aux = 0;
									}
									pos++;
									i=i+1;
								}
							}
							else
							{
								coords[pos] = text.charAt(i) - '0';
								if(aux == 1)
								{
									coords[pos] = coords[pos] * (-1);
									aux = 0;
								}
								pos++;
							}
						}
					}
					ArrayList<Point> arc = Arc.createArc(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
					Shape s1 = new Arc(arc);
					shapes.add(s1);
				}
				if(text.charAt(0) == 'S')
				{
					ArrayList<Integer> points = new ArrayList<Integer>();
					int coords[] = new int[50];
					int pos = 0;
					for(int i=0; i<text.length(); i++) {
						if(Character.isDigit(text.charAt(i)))
						{
							if(Character.isDigit(text.charAt(i+1)))
							{
								if(Character.isDigit(text.charAt(i+2)))
								{
									coords[pos] = (text.charAt(i) - '0') * 100 + (text.charAt(i+1) - '0') * 10 + (text.charAt(i+2) - '0');
									points.add(coords[pos]);
									pos++;
									i=i+2;
								}
								else
								{
									coords[pos] = (text.charAt(i) - '0') * 10 + (text.charAt(i+1) - '0');
									points.add(coords[pos]);
									pos++;
									i=i+1;
								}
							}
							else
							{
								coords[pos] = text.charAt(i) - '0';
								points.add(coords[pos]);
								pos++;
							}
						}
					}
					ArrayList<Point> figure = Figure.createFigure(points);
					Shape s1 = new Figure(figure);
					shapes.add(s1);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shapes;
	}
	
	
	
	/*public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes = Shape.getShapesCoordFromFile();
	}*/
}
