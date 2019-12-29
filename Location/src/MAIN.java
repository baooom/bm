
public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static Location locateLargest(double[][] a)
	{
		Location res = new Location();
		res.setX(0);
		res.setY(0);
		res.setMaxvalue(a[0][0]);
		for(int i=0;i<a.length;++i)
		{
			for(int j=0;j<a[i].length;++j)
			{
				if(a[i][j]>a[res.getX()][res.getY()]);
				{
					res.setX(i);
					res.setY(j);
				}
			}
		}
		return res;
	}
}

class Location
{
	private int x,y;
	private double maxvalue;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getMaxvalue() {
		return maxvalue;
	}

	public void setMaxvalue(double maxvalue) {
		this.maxvalue = maxvalue;
	}
	
}
