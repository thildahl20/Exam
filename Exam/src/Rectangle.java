
public class Rectangle implements Shape{
	int id;
	String Color;
	int length;
	int width;
	double perimeter;
	double area;
	
	Rectangle(String info) {
		//Take info, and separate into its components to initialize all of its values
		setArea();
		setPerimeter();
	}

	public String toString() {
		String Rectangle = String.format("Rectangle (%d)", id);
		return Rectangle;
	}
	
	public String getKind() {
		return "Rectangle";
	}


	public String getDetailString() {
		String rectangle = String.format("Rectangle (ID# %d)\nColor: %s\nLength: %d\nWidth: %d\nArea: %d\nPerimeter: %d", id, Color, length, width, area, perimeter);
		return rectangle;
	}


	public int getID() {
	return id;
	}
	

	private void setArea() {
		area = length*width;
	}
	
	private void setPerimeter() {
		perimeter = length+length+width+width;
	}


}
