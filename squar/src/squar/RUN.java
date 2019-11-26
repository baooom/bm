package squar;

import java.util.Scanner;

public class RUN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Prime.init();
		System.out.print("Enter an integer m:");
		int m=input.nextInt();
		int n=m;
		int ans=1;
		for(int i=1;i<=Prime.totPrime();++i)if(m>1)
		{
			int cnt=0;
			while(m%Prime.kthPrime(i)==0)
			{
				++cnt;
				m/=Prime.kthPrime(i);
			}
			if((cnt&1)==1)ans*=Prime.kthPrime(i);
		}
		System.out.println("The smallest number n for m*n to be a perfect square is "+ans);
		System.out.println("m*n is "+ans*n);
	}

}
