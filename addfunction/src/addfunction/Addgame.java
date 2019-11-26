package addfunction;

public class Addgame {
	private int a;
	private int b;
	private int ans;
	private boolean[] vis;
	Addgame(int _a,int _b)
	{
		this.setA(_a);
		this.setB(_b);
		this.setAns(_a+_b);
		vis = new boolean[200];
	}
	public boolean isVisted(int x)
	{
		return vis[x];
	}
	
	public void setvis(int x)
	{
		this.vis[x]=true;
		return;
	}
	
	public void display()
	{
		System.out.print("What is "+this.getA()+" + "+this.getB()+"?");
		return;
	}
	
	public boolean isCorrect(int input)
	{
		return input==ans;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
}
