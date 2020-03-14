import java.util.ArrayList;

public class Arc extends Shape{

	public Arc(ArrayList<Point> points) {
		super(points);
		// TODO Auto-generated constructor stub
	}
	
	static ArrayList<Point> createArc(int rectX, int rectY, int width, int length, int startAngle, int angularAngle){
		ArrayList<Point> rez = new ArrayList<Point>();
		Point p1 = new Point(rectX, rectY);
		rez.add(p1);
		Point p2 = new Point(width, length);
		rez.add(p2);
		if(angularAngle > 0)
		{
			for(int i=0; i<angularAngle-startAngle; i++) {
				Point p = new Point(startAngle, i+1);
				rez.add(p);
			}
		}
		if(angularAngle < 0)
		{
			for(int i=0; i<angularAngle * (-1); i++) {
				Point p = new Point(startAngle, 0-i-1);
				rez.add(p);
			}
		}
		return rez;
	}
	
}
