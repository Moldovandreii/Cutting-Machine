import java.util.ArrayList;

public class Figure extends Shape{

	public Figure(ArrayList<Point> points) {
		super(points);
		// TODO Auto-generated constructor stub
	}
	
	static ArrayList<Point> createFigure(ArrayList<Integer> coords){
		ArrayList<Point> points = new ArrayList<Point>();
		for(int i=0; i<coords.size(); i++) {
			Point p = new Point(coords.get(i), coords.get(i+1));
			points.add(p);
			i++;
		}
		return points;
	}

}
