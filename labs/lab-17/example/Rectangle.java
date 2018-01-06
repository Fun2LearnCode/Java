
public class Rectangle implements Shape{
	private double h;
	private double w;
	public Rectangle(double h, double w) {
		this.h = h;
		this.w = w;
	}
	public double getHeight() {
		return h;
	}
	public double getWidth() {
		return w;
	}
	@Override
	public double getArea() {
		return h * w;
	}

}
