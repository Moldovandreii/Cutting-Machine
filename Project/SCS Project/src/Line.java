import java.awt.Graphics;
import java.util.ArrayList;

public class Line extends Shape{

	public Line(ArrayList<Point> points) {
		super(points);
		// TODO Auto-generated constructor stub
	}
	
	static ArrayList<Point> createLine(int startX, int startY, int endX, int endY){
		ArrayList<Point> line = new ArrayList<Point>();
		int nbPoints = 0;
		if(startX == endX)
		{
			nbPoints = Math.abs(endY - startY + 1);
			if(endY > startY)
			{
				for(int i=0; i<nbPoints; i++) {
					Point p = new Point(startX, startY + i);
					line.add(p);
				}
			}
			else
			{
				for(int i=0; i<nbPoints; i++) {
					Point p = new Point(startX, startY - i);
					line.add(p);
				}
			}
		}
		else if(startY == endY)
		{
			nbPoints = Math.abs(endX - startX + 1);
			if(endX > startX)
			{
				for(int i=0; i<nbPoints; i++) {
					Point p = new Point(startX + i, startY);
					line.add(p);
				}
			}
			else
			{
				for(int i=0; i<nbPoints; i++) {
					Point p = new Point(startX - i, startY);
					line.add(p);
				}
			}
		}
		else
		{
			nbPoints = Math.abs(endY - startY + 1);
			if(endX > startX)
			{
				if(endY > startY)
				{
					for(int i=0; i<nbPoints; i++) {
						Point p = new Point(startX + i, startY + i);
						line.add(p);
					}
				}
				else
				{
					for(int i=0; i<nbPoints; i++) {
						Point p = new Point(startX + i, startY - i);
						line.add(p);
					}
				}
			}
			else
			{
				if(endY > startY)
				{
					for(int i=0; i<nbPoints; i++) {
						Point p = new Point(startX - i, startY + i);
						line.add(p);
					}
				}
				else
				{
					for(int i=0; i<nbPoints; i++) {
						Point p = new Point(startX - i, startY - i);
						line.add(p);
					}
				}
			}
		}
		return line;
	}
	
}
