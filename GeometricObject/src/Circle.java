
public class Circle extends GeometricObject {
	private double radius;
	public Circle() {}
	public Circle(double radius)
	{
		this.setRadius(radius);
	}
	public Circle(double radius,String color,boolean filled)
	{
		this.setRadius(radius);
		//setColor(color);
		setColor(color);
		setFilled(filled);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea()
	{
		return this.radius*this.radius*Math.PI;
	}
	public double getDiameter()
	{
		return 2*this.radius;
	}
	public double getPerimeter()
	{
		return 2*radius*Math.PI;
	}
	public void printCircle()
	{
		System.out.println("The circle is created "+this.getDateCreated()+" and the radius is "+this.radius);
	}
	public String toString()
	{
		return "on "+this.getDateCreated()+"\ncolor: "+this.getColor()+" and filled: "+this.isFilled();
	}
}
