import java.util.Scanner;
public class LinearEquationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		double x1,x2,x3,x4;
		double y1,y2,y3,y4;
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		x4=input.nextDouble();
		y4=input.nextDouble();
		double a,b,c,d,e,f;
		a=(y1-y2);b=-(x1-x2);e=(y1-y2)*x1-(x1-x2)*y1;
		c=(y3-y4);d=-(x3-x4);f=(y3-y4)*x3-(x3-x4)*y3;
		LinearEquation ans= new LinearEquation(a,b,c,d,e,f);
		System.out.println("The intersecting point is at ("+ans.getX()+", "+ans.getY()+")");
	}

}
