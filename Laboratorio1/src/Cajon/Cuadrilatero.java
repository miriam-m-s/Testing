package Cajon;

public class Cuadrilatero {

	private Point p1, p2, p3, p4;
	private Line l1, l2, l3, l4;
	
	Cuadrilatero(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.l1 = new Line(p1, p2);
		this.l2 = new Line(p2, p3);
		this.l3 = new Line(p3, p4);
		this.l4 = new Line(p4, p1);
	}
	
	public Boolean isRectangulo() {
		Vector2D v1 = l1.getVector();
		Vector2D v2 = l2.getVector();
		Vector2D v3 = l3.getVector();
		Vector2D v4 = l4.getVector();
		
		return (v1.esOrtogonalA(v2) &&
				v2.esOrtogonalA(v3) &&
				v3.esOrtogonalA(v4) &&
				v4.esOrtogonalA(v1));
	}
	
	public Boolean isSquare() {
		return (isRectangulo() &&
				l1.igualLongitud(l2));
	}

}
