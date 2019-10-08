import java.util.Scanner;
public class Partition
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list:");
		int n=input.nextInt();
		int[] list = new int[n];
		for(int i=0;i<n;++i)
			list[i]=input.nextInt();
		partition(list);
		System.out.print("After the partition. the list is ");
		for(int i=0;i<list.length;++i)
			System.out.print(list[i]+(i==list.length-1?"\n":" "));
	}
	public static int partition(int[] list)
	{
		int cnt=0;
		for(int i=1;i<list.length;++i)
		{
			if(list[i]<list[0])swap(list,++cnt,i);
		}
		swap(list,0,cnt);
		return cnt;
	}
	public static void swap(int[] a,int idx1,int idx2)
	{
		int temp=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=temp;
	}
}