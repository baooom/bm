import java.util.Scanner;
public class strsort
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str=input.next();
		str=sort(str);
		System.out.println(str);
	}
	public static String sort(String s)
	{
		char[] res=s.toCharArray();
		for(int i=res.length-1;i>=0;--i)
		{
			for(int j=0;j<i;++j)
			{
				if(res[j]>res[j+1])
				{
					char c=res[j];
					res[j]=res[j+1];
					res[j+1]=c;
				}
			}
		}
		s=String.valueOf(res);
		return s;
	}
}