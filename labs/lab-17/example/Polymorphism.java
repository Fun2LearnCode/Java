import java.util.ArrayList;

public abstract class Polymorphism {
	public static void main(String[] args) {
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		Rectangle rectangle = new Rectangle(4, 5);
		shapeArray.add(new Circle(1));
		shapeArray.add(new Rectangle(4, 5));
		shapeArray.add(new Square(4));

		for(Shape shape : shapeArray){
			printArea(shape);
		}
	}
	public static void printArea(Shape shape) {
		System.out.println(shape.getArea());
	}
}
