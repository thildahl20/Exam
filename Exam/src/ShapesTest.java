import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapesTest extends JComponent implements ActionListener{

	JFrame frame;
	JLabel photo;
	JPanel left, right, center; 
	JTextArea info;
	ImageIcon shapeCircle;
	ImageIcon shapeSquare;
	ImageIcon shapeRectangle;
	ImageIcon shapeTriangle;
	
	ShapesTest() {
		frame = new JFrame("Shapes");
		frame.setLayout(new BorderLayout());
		
		left = new JPanel(); right = new JPanel(); center = new JPanel();
		
		//This text area is for the information on the 
		info = new JTextArea("    ");
		right.add(info);
		
		//This will set up the 4 different shape image icons, so they can be changed out during the program
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		URL circleURL = getClass().getResource("/resources/circle.png");
		Image circle = toolkit.createImage(circleURL);
		circle = circle.getScaledInstance(150, 150,  Image.SCALE_SMOOTH);
		shapeCircle = new ImageIcon(circle);
		
		URL squareURL = getClass().getResource("/resources/square.png");
		Image square = toolkit.createImage(squareURL);
		square = square.getScaledInstance(150, 150,  Image.SCALE_SMOOTH);
		shapeSquare = new ImageIcon(square);
		
		URL rectangleURL = getClass().getResource("/resources/rectangle.png");
		Image rectangle = toolkit.createImage(rectangleURL);
		rectangle = rectangle.getScaledInstance(150, 150,  Image.SCALE_SMOOTH);
		shapeRectangle = new ImageIcon(rectangle);
		
		URL triangleURL = getClass().getResource("/resources/triangle.png");
		Image triangle = toolkit.createImage(triangleURL);
		triangle = triangle.getScaledInstance(150, 150,  Image.SCALE_SMOOTH);
		shapeTriangle = new ImageIcon(triangle);
		
		//This JLabel will contain the image icon
		photo = new JLabel();
		center.add(photo);
		
		frame.add(left, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);
		frame.add(right, BorderLayout.EAST);


	}
	
	public static void main(String[] args) {
		
		ShapesTest window = new ShapesTest();
		
		ArrayList<String> shapeinfo = new ArrayList<String>();
		ArrayList<Shape> shapes = new ArrayList<Shape>();

			try (FileInputStream is = new FileInputStream("C:\\Users\\thildahl20\\workspace\\Exam\\src\\shapes.txt")) {
				InputStreamReader ir = new InputStreamReader(is);
				BufferedReader rdr = new BufferedReader(ir);
				String line;
				
				do { 
					//Go through each line of the code, and create a shape based on the line
					line = rdr.readLine();

					if (line != null){
						if (line.contains("circle")){
							Circle i = new Circle(line);
							shapes.add(i);
							JButton button = new JButton(i.toString());
							button.addActionListener(this);
							window.left.add(button);
						}
						else if (line.contains("square")){
							Square i = new Square(line);
							shapes.add(i);
							JButton button = new JButton(i.toString());
							button.addActionListener(this);
							window.left.add(button);
						}
						else if (line.contains("rectangle")) {
							Rectangle i = new Rectangle(line);
							shapes.add(i);
							JButton button = new JButton(i.toString());
							button.addActionListener(this);
							window.left.add(button);
						}
						else if (line.contains("triangle")){
							Triangle i = new Triangle(line);
							shapes.add(i);
							JButton button = new JButton(i.toString());
							button.addActionListener(this);
							window.left.add(button);
						}
						else 
							System.out.printf("There is no valid shape here");
							
						shapeinfo.add(line);
					}
				}while (line != null);
			}
			catch (Exception ex) { System.out.printf("Failed");}
			
			window.repaint();
			window.revalidate();			
			
			window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.frame.setBounds(100, 100, 500, 500);
			window.frame.setVisible(true);
	}

	//Depending on which button is pressed, change the photo to the right shape and change the text to information about the shape
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof Circle){
			photo.setIcon(shapeCircle);
			info.setText(((Circle) e.getSource()).getDetailString());
		}
		else if (e.getSource() instanceof Square){
			photo.setIcon(shapeSquare);
			info.setText(((Square) e.getSource()).getDetailString());
		}
		else if (e.getSource() instanceof Rectangle){
			photo.setIcon(shapeRectangle);
			info.setText(((Rectangle) e.getSource()).getDetailString());
		}
		else if (e.getSource() instanceof Triangle){
			photo.setIcon(shapeTriangle);
			info.setText(((Triangle) e.getSource()).getDetailString());
		}
		repaint();
	}
	
}


