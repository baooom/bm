package javaFinal;

import java.util.Scanner;
public class Control {
	
	/*
	 * 登录操作*/
	public static User login(Scanner input,String path)
	{
		path+="登录>>";
		System.out.print(path);
		System.out.print("请输入你的账号:");
		long userID;
		try
		{
			userID=input.nextLong();
		}catch(Exception e)
		{
			System.out.println("账号不合法");
			input.nextLine();
			return null;
		}
		User x;
		if((x = MyDateBase.contains(userID))==null)//先查看用户是否存在，不存在则直接退出登录
		{
			System.out.println("没有这个用户!");
			return null;
		}else
		{
			String password="";
			for(int i=3;i>=1;--i)//每次登录最多可以输错3次密码
			{
				System.out.print("您还可以输入"+i+"次密码，请输入密码:");
				try
				{
					password=input.next();
				}catch(Exception e)
				{
					System.out.println("输入不合法");
					input.nextLine();
					continue;
				}
				try
				{
					if(x.iscorrectPassword(password))
					{
						System.out.println("登录成功!");
						return x;
					}else
					{
						System.out.println("密码错误!");
					}					
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}
			System.out.println("请重新登录尝试!");
			return null;
		}
	}
	
	/*
	 * 注册操作*/
	public static User register(Scanner input,String path)
	{
		path+="注册>>";
		long userID;
		System.out.println(path);
		System.out.print("请输入一个不含前导零的1-10位数字用户名\n这将作为您的登录ID:");//注册提示
		try
		{
			userID=input.nextLong();			
		}catch(Exception e)
		{
			System.out.println("用户名不合法");
			input.nextLine();
			return null;
		}
		if(MyDateBase.contains(userID)!=null)
		{
			System.out.println("用户名已存在");
			return null;
		}else if(userID>9999999999l)
		{
			System.out.println("您的用户名太长了");
		}else
		{
			String password;
			System.out.print("请输入你的密码：");
			password=input.next();
			System.out.print("请再输入一次：");//密码需要二次确认，方式随便乱输入
			if(password.equals(input.next()))
			{
				int graduatedate;
				System.out.print("您的毕业年份：");
				try
				{
					graduatedate=input.nextInt();
				}catch(Exception e)
				{
					System.out.println("输入不合法！");
					input.next();
					return null;
				}
				System.out.println("您去向何处：");//按照不同类别，分开注册
				System.out.println("1.研究生");
				System.out.println("2.工作");
				System.out.println("3.还没有去处");
				int opt=input.nextInt();
				if(opt>3||opt<1)
				{
					return null;
				}
				System.out.print("您的姓名：");
				String name = input.next();
				boolean ismale=true;
				{
					System.out.println("您的性别：");
					System.out.println("1.男");
					System.out.println("2.女");
					int t=input.nextInt();
					ismale=t==1;
					if(t!=1&&t!=2)
					{
						System.out.println("对不起，我们的系统暂时不支持这个性别。");
						return null;
					}
				}
				System.out.println("您的电话：");
				String tle=input.next();
				if(opt==1)
				{
					System.out.print("您的学校：");
					String school = input.next();
					System.out.print("您的专业：");
					String major = input.next();
					Graduatestu res = new Graduatestu(userID,name,tle,password,ismale,false,opt,school,major,graduatedate);
					MyDateBase.insertgra(res);
					return res;
				}else if(opt==2)
				{
					System.out.print("您的公司：");
					String school = input.next();
					System.out.print("您的岗位：");
					String major = input.next();
					Companystu res = new Companystu(userID,name,tle,password,ismale,false,opt,school,major,graduatedate);
					MyDateBase.insertcom(res);
					return res;
				}else if(opt==3)
				{
					System.out.print("您的所在地：");
					String school = input.next();
					System.out.print("您的联系方式：");
					String major = input.next();
					Nonestu res = new Nonestu(userID,name,tle,password,ismale,false,opt,school,major,graduatedate);
					MyDateBase.insertnon(res);
					return res;
				}
			}else
			{
				System.out.println("两次密码不一致");
				return null;
			}
		}
		return null;
	}

}
