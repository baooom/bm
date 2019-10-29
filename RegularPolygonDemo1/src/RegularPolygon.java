
public class RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	public RegularPolygon()
	{
		n=3;
		side=1.0;
		x=0.0;
		y=0.0;
	}
	public RegularPolygon(int _n,double _side)
	{
		n=_n;
		side=_side;
	}
	public RegularPolygon(int _n,double _side,double _x,double _y)
	{
		n=_n;
		side=_side;
		x=_x;
		y=_y;
	}
	public int getN()
	{
		return n;
	}
	public void setN(int _n)
	{
		n=_n;
	}
	public void setSide(double _side)
	{
		side=_side;
	}
	public double getSide()
	{
		return side;
	}
	public double getX()
	{
		return x;
	}
	public void setX(double _x)
	{
		x=_x;
	}
	public double getY()
	{
		return y;
	}
	public void setY(double _y)
	{
		y=_y;
	}
	public double getPerimeter()
	{
		return n*side;
	}
	public double getArea()
	{
		return n*side*side/4/Math.tan(Math.PI/n);
	}
}
