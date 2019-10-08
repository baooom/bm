import java.util.Scanner;
public class issorted
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list:");
		int n=input.nextInt();
		int[] list=new int[n];
		for(int i=0;i<n;++i)
			list[i]=input.nextInt();
		if(isSorted(list))
			System.out.println("The list is already sorted");
		else
			System.out.println("The list is not sorted");
	}
	public static boolean isSorted(int[] list)
	{
		for(int i=1;i<list.length;++i)
		{
			if(list[i]<list[i-1])return false;
		}
		return true;
	}
}