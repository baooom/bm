import java.util.Scanner;
public class distnum
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] vis = new int[11];
		int cnt=0;
		System.out.print("Enter ten numbers:");
		for(int i=0;i<10;++i)
		{
			int v=input.nextInt();
			boolean found=false;
			for(int j=0;j<cnt;++j)
			{
				if(vis[j]==v)
				{
					found=true;
				}				
			}
			if(!found)
				vis[cnt++]=v;
		}
		System.out.println("The number of distinct number is "+cnt);
		System.out.print("The distinct numbers are:");
		for(int i=0;i<cnt;++i)
			System.out.print(vis[i]+(i==cnt-1?"\n":" "));
	}
}