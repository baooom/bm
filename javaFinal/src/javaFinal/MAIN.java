package javaFinal;

import java.util.Scanner;
public class MAIN {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//input.nextLine();
		int opt;
		String path = new String(">>");
		System.out.println(">>>>>欢迎使用毕业生去向管理系统<<<<<");
		System.out.println(">管理员用户用户名为\'0\'\n>密码为123456\n>首次登录请主动修改密码\n");//首次登录提示信息
		System.out.println(">在用户页面，使用\'ls\'可显示操作列表\n>使用\'exit\'可退出当前目录");
		System.out.println(">使用\'help\'可显示帮助信息");
		System.out.println(">本条消息只显示一次。");
		System.out.println(">您现在可以进行的操作有:");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出");
		System.out.print("请输入对应序号执行对应操作");
		System.out.print(path);
		while(input.hasNext())
		{
			try
			{
				opt=input.nextInt();
				if(opt==1)
				{
					User now = Control.login(input,path);
					if(now!=null)
					{
						now.RUN(input,path,now.isManager());
					}else
					{
						System.out.println("登录信息有误，已退出注册");
					}
				}else if(opt==2)
				{
					User now=Control.register(input,path);
					if(now!=null)
					{
						now.RUN(input,path,now.isManager());
					}else
					{
						System.out.println("注册信息有误，已退出注册");
					}
				}else if(opt==3)
				{
					System.out.println("系统已退出");
					input.close();
					break;
				}else
				{
					System.out.println("没有这个操作");
				}
			}catch(Exception e)
			{
				System.out.println("输入不合法");
				input.nextLine();
			}
			System.out.println(">>>>>欢迎使用毕业生去向管理系统<<<<<");
			System.out.println(">您现在可以进行的操作有:");
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
			System.out.print("请输入对应序号执行对应操作");
			System.out.print(path);
		}
		return ;
	}
}

