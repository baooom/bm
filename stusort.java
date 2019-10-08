import java.util.Scanner;
public class stusort
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the numbers of student:");
		int n=input.nextInt();
		int[] grade = new int[n];
		String[] name = new String[n];
		for(int i=0;i<n;++i)
		{
			System.out.print("The name of student "+(i+1)+" is:");
			name[i]=input.next();
			System.out.print("The grade of student "+(i+1)+" is:");
			grade[i]=input.nextInt();
		}
		for(int i=n-1;i>=0;--i)
		{
			for(int j=0;j<i;++j)
			{
				if(grade[j]<grade[j+1])
					swap(grade,name,j,j+1);
			}
		}
		System.out.println("The ranklist of students is:");
		for(int i=0;i<n;++i)
			System.out.println(name[i]);
	}
	public static void swap(int[] a,String[] b,int idx1,int idx2)
	{
		int Itemp=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=Itemp;
		String Stemp=b[idx1];
		b[idx1]=b[idx2];
		b[idx2]=Stemp;
	}
}