package javaFinal;
import java.util.Scanner;
@SuppressWarnings("serial")
public abstract class User implements java.io.Serializable {
	private long userID;
	private String userName;
	private String userTle;
	private String passWord;
	private boolean isMale;
	private boolean isManager;
	/*
	 * setter & getter*/
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getUserTle() {

		return userTle;
	}

	public void setUserTle(String userTle) {

		this.userTle = userTle;
	}

	public String getPassWord() {

		return passWord;
	}

	public void setPassWord(String passWord) {

		this.passWord = passWord;
	}
	
	public boolean iscorrectPassword(String password)
	{
		return this.getPassWord().equals(password);
	}
	
	public boolean isMale() {

		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean isManager() {

		return isManager;
	}

	public void setManager(boolean isManager) {

		this.isManager = isManager;
	}
	public User(long userId,String userName,String userTle,String passWord,boolean isMale,boolean isManager)
	{
		this.setUserTle(userTle);
		this.setUserName(userName);
		this.setUserID(userId);
		this.setPassWord(passWord);
		this.setMale(isMale);
		this.setManager(isManager);
	}
	/*
	 * 用于深拷贝的构造函数*/
	public User(User other)
	{
		this.setMale(other.isMale());
		this.setManager(other.isManager());
		this.setPassWord(other.getPassWord());
		this.setUserID(other.getUserID());
		this.setUserName(other.getUserName());
		this.setUserTle(other.getUserTle());
	}
	/*
	 * 显示操作列表*/
	public void displayOperationlist()
	{
		System.out.println("1.修改电话");
		System.out.println("2.修改密码");
		System.out.println("3.修改姓名");
	}
	/*
	 * 显示用户信息*/
	public abstract void displayUserIfo();
	public abstract void displayhandle();
	/*
	 * 修改密码*/
	public void changePassword(Scanner input,String path,boolean ismanager)
	{
		path+="修改密码>>";
		
		System.out.println(path);
		String oldpassword;
		if(this.isManager()||ismanager)
		{
			System.out.print("输入旧密码：");
			oldpassword=input.next();	
		}else
		{
			oldpassword=this.getPassWord();
		}
		if(this.iscorrectPassword(oldpassword))
		{
			System.out.print("输入新密码：");
			String newpassword=input.next();
			System.out.print("再次输入新密码：");
			if(newpassword.equals(input.next()))
			{
				this.setPassWord(newpassword);
				System.out.println("修改成功");
			}else
			{
				System.out.println("密码错误!");
			}
		}else
		{
			System.out.println("密码错误!");
		}
		return;
	}

	/*
	 * 用户的主操作界面*/
	public void RUN(Scanner input,String path,boolean ismanager)
	{
		
		path+=this.getUserName()+">>";
		while(true)
		{
			System.out.println(path);
			String opt=input.next();
			
			if(opt.equals("ls"))//显示用户的操作列表
			{
				this.displayOperationlist();
				System.out.print(">>");
				try
				{
					int oper=input.nextInt();//获取用户的操作数，并判断是否合法
					if(!this.operator(input, path,oper,this.isManager()))
					{
						System.out.println("无效操作!");
					}
				}catch(Exception e)
				{
					opt=input.next();
					if(opt.equals("exit"))//退出当前目录
					{
						continue;
					}
					System.out.println("输入不合法!");
					input.nextLine();
				}
			}else if(opt.equals("exit"))//退出当前目录
			{
				return;
			}else if(opt.equals("info"))//显示用户信息
			{
				this.displayhandle();
				this.displayUserIfo();
			}else if(opt.equals("help"))
			{
				System.out.println("ls 获取操作列表");
				System.out.println("exit 登出当前账户");
				System.out.println("info 获取当前账户信息");
			}
			else
			{
				System.out.println("您可以输入help获取操作列表");//提示用户输入help查看操作
			}
				
			/*if(opt.equals("password"))
			{
				x.changePassword(input,path);
			}*/
		}
	
	}

	public abstract boolean operator(Scanner input,String path,int opt,boolean ismanager);
	
	public void changeTel(Scanner input,String path)
	{
		path+="修改电话信息>>";
		System.out.println(path);
		System.out.println("原电话为 "+this.getUserTle());
		System.out.println("请输入新的信息");
		this.setUserTle(input.next());
		System.out.println("修改完成");
		
	}
	public void changeName(Scanner input,String path)
	{
		path+="修改姓名>>";
		System.out.println(path);
		System.out.println("原姓名为 "+this.getUserName());
		System.out.println("请输入新的信息");
		this.setUserName(input.next());
		System.out.println("修改完成\n修改将在下一次登录时生效");
	}
}