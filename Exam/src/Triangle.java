
public class Triangle implements Shape{
	int id;
	String Color;
	int side1;
	int side2;
	int side3;
	double perimeter;
	double area;
	
	Triangle(String info) {
		//Take info, and separate into its components to initialize all of its values
		setArea();
		setPerimeter();
	}

	public String toString() {
		String triangle = String.format("Triangle (%d)", id);
		return triangle;
	}
	
	public String getKind() {
		return "Triangle";
	}


	public String getDetailString() {
		String triangle = String.format("Rectangle (ID# %d)\nColor: %s\nSide 1: %d\nSide 2: %d\nSide 3: %d\nArea: %d\nPerimeter: %d", id, Color, side1, side2, side3, area, perimeter);
		return triangle;
	}


	public int getID() {
		return id;
	}
	

	private void setArea() {
		double s = .5*(side1 + side2 + side3);
		area = Math.sqrt((s*(s-side1)*(s-side2)*(s-side3)));
	}
	
	private void setPerimeter() {
		perimeter = side1 + side2 + side3;
	}

	

}
