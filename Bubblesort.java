import java.util.Scanner;
public class Bubblesort
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] sorted=new double[10];
		System.out.print("Enter ten real numbers:");
		for(int i=0;i<10;++i)
		{
			sorted[i]=input.nextDouble();
		}
		for(int i=9;i>=0;--i)
		{
			for(int j=0;j<i;++j)
			{
				if(sorted[j]>sorted[j+1])
					swap(sorted,j,j+1);
			}
		}
		System.out.print("After sort the list is:");
		for(int i=0;i<10;++i)
			System.out.print(sorted[i]+(i==9?"\n":" "));

	}
	public static void swap(double[] a,int idx1,int idx2)
	{
		double temp=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=temp;
	}
}