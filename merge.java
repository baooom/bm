import java.util.Scanner;
public class merge
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n,m;
		System.out.print("Enter list1:");
		n=input.nextInt();
		int[] list1 = new int[n];
		for(int i=0;i<n;++i)
			list1[i]=input.nextInt();
		System.out.print("Enter list2:");
		m=input.nextInt();
		int[] list2 = new int[m];
		for(int i=0;i<m;++i)
			list2[i]=input.nextInt();
		int[] list3=Merge(list1,list2);
		System.out.print("The merged list is ");
		for(int i=0;i<list3.length;++i)
			System.out.print(list3[i]+(i==list3.length-1?"\n":" "));
	}
	public static int[] Merge(int[] list1,int[] list2)
	{
		int[] list3= new int[list1.length+list2.length];
		int i=0,j=0,cnt=0;
		while(i<list1.length&&j<list2.length)
		{
			if(list1[i]<list2[j])
				list3[cnt++]=list1[i++];
			else
				list3[cnt++]=list2[j++];
		}
		while(i<list1.length)
			list3[cnt++]=list1[i++];
		while(j<list2.length)
			list3[cnt++]=list2[j++];
		return list3;
	}
}