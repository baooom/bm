package javaFinal;


import java.util.Scanner;

@SuppressWarnings("serial")
public class Manager extends User implements java.io.Serializable{

	/*
	 * inf1为公司信息
	 * inf2为岗位信息*/
	public Manager(long userId, String userName, String userTle, String passWord, boolean isMale, boolean isManager) {
		super(userId, userName, userTle, passWord, isMale, isManager);
		// TODO Auto-generated constructor stub
	}
	/*
	 * 用于深拷贝的构造函数*/
	public Manager(Manager other)
	{
		super(other);
	}
	/*
	 * 显示操作列表*/
	public void displayOperationlist()
	{
		super.displayOperationlist();
		System.out.println("4.查看毕业生列表");
		System.out.println("5.查看统计信息");
	}
	
	public void displayUserIfo()
	{
		System.out.printf("%-15d%-10s%-13s%-5s\n\n",this.getUserID(),this.getUserName(),this.getUserTle(),this.isMale()?"male":"female");
	}
	public boolean operator(Scanner input, String path, int opt,boolean ismanager) {
		if(opt==1)
		{
			this.changeTel(input, path);//修改电话
			return true;
		}else if(opt==2)
		{
			this.changePassword(input, path, ismanager);//修改密码
			return true;
		}else if(opt==3)
		{
			this.changeName(input, path);//修改姓名
			return true;
		}else if(opt==4)
		{
			this.stulist(input, path);//查看毕业生列表
			return true;
		}else if(opt==5)
		{
			this.dispalyinfo(input, path);//查看毕业生统计信息
			return true;
		}
		return false;
	}
	/*
	 * 查看毕业生列表*/
	private void stulist(Scanner input,String path)
	{
		path+="查看毕业生列表>>";
		while(true)
		{
			System.out.println(path);
			System.out.println("1.查看研究生列表");
			System.out.println("2.查看就业学生列表");
			System.out.println("3.查看待业学生列表");
			System.out.println("4.退出");
			try
			{
				System.out.print(">>");
				int opt=input.nextInt();
				if(opt==1)
				{
					this.dispalyGraduatestu(input, path);
				}else if(opt==2)
				{
					this.dispalyCompanystu(input, path);
				}else if(opt==3)
				{
					this.dispalyNonestu(input, path);
				}else if(opt==4)
				{
					break;
				}else
				{
					System.out.println("没有这个操作");
				}
			}catch(Exception e)
			{
				System.out.println("输入不合法!");
				input.nextLine();
			}			
		}
		return;
	}
	/*
	 * 考研学生列表*/
	private void dispalyGraduatestu(Scanner input,String path)
	{
		path+="研究生列表>>";
		while(true)
		{
			System.out.println(path);
			MyDateBase.displaygra();
			System.out.println("输入序号查看对应学生信息\n输入-1退出");
			System.out.print(">>");
			try
			{
				int opt=input.nextInt();
				if(opt==-1)
				{
					return ;
				}
				try
				{
					MyDateBase.graat(opt-1).RUN(input, path,this.isManager());
				}catch(Exception e)//如果用户输入越界，则返回错误信息
				{
					System.out.println("没有这个学生");
				}
			}catch(Exception e)
			{
				System.out.println("输入不合法");
				return;
			}
		}

	}
	/*
	 * 工作学生列表*/
	private void dispalyCompanystu(Scanner input,String path)
	{
		path+="就业学生列表>>";
		while(true)
		{
			System.out.println(path);
			MyDateBase.displaycom();
			System.out.println("输入序号查看对应学生信息\n输入-1退出");
			System.out.print(">>");
			try
			{
				int opt=input.nextInt();
				if(opt==-1)
				{
					return ;
				}
				try
				{
					MyDateBase.comat(opt-1).RUN(input, path,this.isManager());
				}catch(Exception e)//如果用户输入越界，则返回错误信息
				{
					System.out.println("没有这个学生");
				}
			}catch(Exception e)
			{
				System.out.println("输入不合法");
				return;
			}
		}

	}
	/*
	 * 待业学生列表*/
	private void dispalyNonestu(Scanner input,String path)
	{
		path+="待业学生列表>>";
		while(true)
		{
			System.out.println(path);
			MyDateBase.displaynone();
			System.out.println("输入序号查看对应学生信息\n输入-1退出");
			System.out.print(">>");
			try
			{
				int opt=input.nextInt();
				if(opt==-1)
				{
					return ;
				}
				try
				{
					MyDateBase.noneat(opt-1).RUN(input, path,this.isManager());
				}catch(Exception e)//如果用户输入越界，则返回错误信息
				{
					System.out.println("没有这个学生");
				}
			}catch(Exception e)
			{
				System.out.println("输入不合法");
				return;
			}
		}

	}
	/*
	 * 统计信息*/
	private void dispalyinfo(Scanner input,String path)
	{
		path+="统计信息>>";
		System.out.println(path);
		System.out.print("共有");
		System.out.print(+MyDateBase.totcom()+MyDateBase.totgra()+MyDateBase.totnone());
		System.out.println("名学生成功登记");
		System.out.printf("其中读研%d人，就业%d人，待业%d人\n",MyDateBase.totgra(),MyDateBase.totcom(),MyDateBase.totnone());
		int opt;
		while(true)
		{
			System.out.println(path);
			System.out.println("1.查询所有研究生");
			System.out.println("2.查询所有就业学生");
			System.out.println("3.查询所有待业学生");
			System.out.println("4.退出");
			System.out.print("请输入您的操作数>>");
			try
			{
				opt=input.nextInt();
				if(opt==4)
				{
					break;
				}else if(opt==1)
				{
					MyDateBase.grainfo(input, path);
				}else if(opt==2)
				{
					MyDateBase.cominfo(input, path);
				}else if(opt==3)
				{
					MyDateBase.noneinfo(input, path);
				}
			}catch(Exception e)
			{
				System.out.println("输入非话，请重新输入");
				input.nextLine();
			}		
		}
		return;
	}
	/*
	 * 显示信息标签*/
	public void displayhandle()
	{
		System.out.printf("%-15s%-10s%-13s%-6s\n","UserId","Name","UserTel","Sex");
	}
}
