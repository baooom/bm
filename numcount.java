import java.util.Scanner;
public class numcount
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the integers between 1 and 100:");
		int[] cnt = new int[101];
		while(input.hasNext())
		{
			++cnt[input.nextInt()];
		}
		for(int i=0;i<cnt.length;++i)
		{
			if(cnt[i]>0)
				System.out.println(i+" occurs "+cnt[i]+(cnt[i]>1?" times":" time"));
		}
	}
}