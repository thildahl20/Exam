import java.util.Scanner;

public class Circle implements Shape{
	int id;
	String Color;
	int radius;
	double perimeter;
	double area;

	Circle(String info) {
		//Take info, and separate into its components to initialize all of its values
		setArea();
		setPerimeter();
	}
	
	public String toString() {
		String circle = String.format("Circle (%d)", id);
		return circle;
	}
	
	public String getKind() {
		return "Circle";
	}


	public String getDetailString() {
		String circle = String.format("Circle (ID# %d)\nColor: %s\nRadius: %d\nArea: %d\nPerimeter: %d", id, Color, radius, area, perimeter);
		return circle;
	}

	public int getID() {
		return id;
	}
	
	private void setArea() {
		area = 3.14159265*radius*radius;
	}
	
	private void setPerimeter() {
		perimeter = 3.14159265*2*radius;
	}

}
