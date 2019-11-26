package squar;

public class Prime {
	private static boolean[] notPrime = new boolean[100000];
	private static int[] Prime = new int[100000];
	private static int cnt;
	public static int totPrime()
	{
		return cnt;
	}
	public static void init()
	{
		notPrime[0]=notPrime[1]=true;
		for(int i=2;i<notPrime.length;++i)
		{
			if(!notPrime[i])
			{
				Prime[cnt++]=i;
			}
			for(int j=0;j<cnt&&1l*i*Prime[j]<notPrime.length;++j)
			{
				notPrime[i*Prime[j]]=true;
				if(i%Prime[j]==0)break;
			}
		}
	}
	public static boolean isPrime(int x)
	{
		return !notPrime[x];
	}
	public static int kthPrime(int k)
	{
		return Prime[k-1];
	}
}
