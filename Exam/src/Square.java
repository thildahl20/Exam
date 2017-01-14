
public class Square implements Shape{
	int id;
	String Color;
	int side;
	double perimeter;
	double area;

	Square(String info) {
		//Take info, and separate into its components to initialize all of its values
		setArea();
		setPerimeter();
	}
	
	public String toString() {
		String square = String.format("Square (%d)", id);
		return square;
	}
	
	public String getKind() {
		return "Square";
	}


	public String getDetailString() {
		String square = String.format("Square (ID# %d)\nColor: %s\nLength: %d\nArea: %d\nPerimeter: %d", id, Color, side, area, perimeter);
		return square;
	}

	public int getID() {
		return id;
	}
	
	private void setArea() {
		area = side*side;
	}
	
	private void setPerimeter() {
		perimeter = 4*side;
	}

}
