package javaFinal;
import java.util.Scanner;
import java.util.Vector;

public class MyDateBase {
	private static Vector<Graduatestu> grastu = new Vector<Graduatestu>();//用于存放研究生
	private static Vector<Companystu> comstu = new Vector<Companystu>();//用于存放工作学生
	private static Vector<Nonestu> nonestu = new Vector<Nonestu>();//用于存放待业学生
	private static Manager Manusr = new Manager(0,"admin","none","123456",true,true);//用于存放管理员用户
	
	/*
	 * 插入研究生*/
	public static void insertgra(Graduatestu x)
	{
		if(grastu.size()==0)
		{
			grastu.add(x);
			return;
		}
		int l=0,r=grastu.size();
		while(l<=r)//二分查询需要插入的位置
		{
			int mid=l+r>>1;
			if(grastu.elementAt(mid).getUserID()>=x.getUserID())
				r=mid-1;
			else
				l=mid+1;
		}
		if(grastu.elementAt(l).getUserID()==x.getUserID())//如果已经存在，输出错误信息，否则插入
		{
			System.out.println("!!用户已存在");
		}else
		{
			grastu.insertElementAt(x, l);
		}
	}
	/*
	 * 插入找工作的学生*/
	public static void insertcom(Companystu x)
	{
		if(comstu.size()==0)
		{
			comstu.add(x);
			return;
		}
		int l=0,r=comstu.size();
		while(l<=r)//二分查询需要插入的位置
		{
			int mid=l+r>>1;
			if(comstu.elementAt(mid).getUserID()>=x.getUserID())
				r=mid-1;
			else
				l=mid+1;
		}
		if(comstu.elementAt(l).getUserID()==x.getUserID())//如果已经存在，输出错误信息，否则插入
		{
			System.out.println("!!用户已存在");
		}else
		{
			comstu.insertElementAt(x, l);
		}
	}
	/*
	 * 插入待业学生*/
	public static void insertnon(Nonestu x)
	{
		if(nonestu.size()==0)
		{
			nonestu.add(x);
			return;
		}
		int l=0,r=nonestu.size();
		while(l<=r)//二分查询需要插入的位置
		{
			int mid=l+r>>1;
			if(nonestu.elementAt(mid).getUserID()>=x.getUserID())
				r=mid-1;
			else
				l=mid+1;
		}
		if(nonestu.elementAt(l).getUserID()==x.getUserID())//如果已经存在，输出错误信息，否则插入
		{
			System.out.println("!!用户已存在");
		}else
		{
			nonestu.insertElementAt(x, l);
		}
	}

	/*
	 * 判断是否存在该用户，存在返回用户对象引用，不存在返回null*/
	public static User contains(long x)
	{
		if(Manusr.getUserID()==x)return Manusr;
		for(User v:grastu)
			if(v.getUserID()==x)return v;
		for(User v:comstu)
			if(v.getUserID()==x)return v;
		for(User v:nonestu)
			if(v.getUserID()==x)return v;
		return null;
	}

	/*
	 * 打印研究生列表*/
	public static void displaygra()
	{
		System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
		int idx=1;
		for(Graduatestu x:grastu)
		{
			System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
			++idx;
		}
	}
	/*
	 * 打印就业学生列表*/
	public static void displaycom()
	{
		System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Company","Post","Graduatedate");
		int idx=1;
		for(Companystu x:comstu)
		{
			System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
			++idx;
		}
	}
	/*
	 * 打印待业学生*/
	public static void displaynone()
	{
		System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Address","ContactInfo","Graduatedate");
		int idx=1;
		for(Nonestu x:nonestu)
		{
			System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
			++idx;
		}
	}

	public static int totgra()
	{
		return grastu.size();
	}
	
	public static int totcom()
	{
		return comstu.size();
	}
	
	public static int totnone()
	{
		return nonestu.size();
	}
	/*
	 * 返回第idx个学生*/
	public static User graat(int idx) throws IndexOutOfBoundsException
	{
		return grastu.elementAt(idx);
	}

	public static User comat(int idx) throws IndexOutOfBoundsException
	{
		return comstu.elementAt(idx);
	}
	
	public static User noneat(int idx) throws IndexOutOfBoundsException
	{
		return nonestu.elementAt(idx);
	}

	/*
	 * 男性研究生总人数*/
	public static int totmaleingra()
	{
		int res=0;
		for(User x:grastu)
		{
			res+=x.isMale()?1:0;
		}
		return res;
	}
	/*
	 * 男性就业学生总人数*/
	public static int totmaleincom()
	{
		int res=0;
		for(User x:comstu)
		{
			res+=x.isMale()?1:0;
		}
		return res;
	}
	/*
	 * 男性待业学生总人数*/
	public static int totmaleinnone()
	{
		int res=0;
		for(User x:nonestu)
		{
			res+=x.isMale()?1:0;
		}
		return res;
	}
	/*
	 * 研究生统计信息*/
	public static void grainfo(Scanner input,String path)
	{
		path+="研究生信息查询>>";
		int opt;
		while(true)
		{
			System.out.println(path);
			System.out.println("1.按学校查询");
			System.out.println("2.按专业查询");
			System.out.println("3.性别比例");
			System.out.println("4.按毕业年份查询");
			System.out.println("5.退出");
			System.out.print("请输入您的操作数<<");
			try
			{
				opt=input.nextInt();
				if(opt==5)
				{
					break;
				}else if(opt==1)
				{
					System.out.println(path+"按学校查询>>");
					System.out.print("请输入想要查询的学校>>");
					String info=input.next();
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
					int idx=1;
					for(Student x:grastu)
					{
						if(x.getInfo1().equals(info))
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}else if(opt==2)
				{
					System.out.println(path+"按专业查询>>");
					System.out.print("请输入想要查询的专业>>");
					String info=input.next();
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
					int idx=1;
					for(Student x:grastu)
					{
						if(x.getInfo2().equals(info))
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}else if(opt==3)
				{
					System.out.printf("共有%d位考研学生，其中男生%d人，女生%d人\n",MyDateBase.totgra(),MyDateBase.totmaleingra(),MyDateBase.totgra()-MyDateBase.totmaleingra());
				}else if(opt==4)
				{
					System.out.println(path+"按毕业年份查询>>");
					System.out.print("请输入想要查询的毕业年份>>");
					int info;
					try
					{
						info=input.nextInt();						
					}catch(Exception e)
					{
						System.out.println("非法输入！");
						input.next();
						continue;
					}
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
					int idx=1;
					for(Student x:grastu)
					{
						if(x.getGraduatedate()==info)
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}
				else
				{
					System.out.println("没有这个选项");
				}
			}catch(Exception e)
			{
				System.out.println("输入非法！");
				input.nextLine();
				break;
			}
		}
		return;
	}
	/*
	 * 就业学生统计信息*/
	public static void cominfo(Scanner input,String path)
	{
		path+="就业学生信息查询>>";
		int opt;
		while(true)
		{
			System.out.println(path);
			System.out.println("1.按公司查询");
			System.out.println("2.按岗位查询");
			System.out.println("3.性别比例");
			System.out.println("4.按毕业年份查询");
			System.out.println("5.退出");
			System.out.print("请输入您的操作数<<");
			try
			{
				opt=input.nextInt();
				if(opt==5)
				{
					break;
				}else if(opt==1)
				{
					System.out.println(path+"按公司查询>>");
					System.out.print("请输入想要查询的公司>>");
					String info=input.next();
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Company","Post","Graduatedate");
					int idx=1;
					for(Student x:comstu)
					{
						if(x.getInfo1().equals(info))
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}else if(opt==2)
				{
					System.out.println(path+"按岗位查询>>");
					System.out.print("请输入想要查询的岗位>>");
					String info=input.next();
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Company","Post","Graduatedate");
					int idx=1;
					for(Student x:comstu)
					{
						if(x.getInfo2().equals(info))
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}else if(opt==3)
				{
					System.out.printf("共有%d位工作学生，其中男生%d人，女生%d人\n",MyDateBase.totcom(),MyDateBase.totmaleincom(),MyDateBase.totcom()-MyDateBase.totmaleincom());
				}else if(opt==4)
				{
					System.out.println(path+"按毕业年份查询>>");
					System.out.print("请输入想要查询的毕业年份>>");
					int info;
					try
					{
						info=input.nextInt();						
					}catch(Exception e)
					{
						System.out.println("非法输入！");
						input.next();
						continue;
					}
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
					int idx=1;
					for(Student x:comstu)
					{
						if(x.getGraduatedate()==info)
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}
				else
				{
					System.out.println("没有这个选项");
				}
			}catch(Exception e)
			{
				System.out.println("输入非法！");
				input.nextLine();
				break;
			}
		}
		return;
	}
	/*
	 * 待业学生统计信息*/
	public static void noneinfo(Scanner input,String path)
	{
		path+="待业学生信息查询>>";
		int opt;
		while(true)
		{
			System.out.println(path);
			System.out.println("1.按去处查询");
			System.out.println("2.性别比例");
			System.out.println("3.按毕业年份查询");
			System.out.println("4.退出");
			System.out.print("请输入您的操作数<<");
			try
			{
				opt=input.nextInt();
				if(opt==4)
				{
					break;
				}else if(opt==1)
				{
					System.out.println(path+"按去处查询>>");
					System.out.print("请输入想要查询的信息>>");
					String info=input.next();
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Address","ContactInfo","Graduatedate");
					int idx=1;
					for(Student x:nonestu)
					{
						if(x.getInfo1().equals(info))
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}else if(opt==2)
				{
					System.out.printf("共有%d位工作学生，其中男生%d人，女生%d人\n",MyDateBase.totnone(),MyDateBase.totmaleinnone(),MyDateBase.totnone()-MyDateBase.totmaleinnone());
				}else if(opt==3)
				{
					System.out.println(path+"按毕业年份查询>>");
					System.out.print("请输入想要查询的毕业年份>>");
					int info;
					try
					{
						info=input.nextInt();						
					}catch(Exception e)
					{
						System.out.println("非法输入！");
						input.next();
						continue;
					}
					System.out.printf("No.  %-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
					int idx=1;
					for(Student x:nonestu)
					{
						if(x.getGraduatedate()==info)
						{
							System.out.printf("%-3d: %-15d%-10s%-13s%-6s%-10s%-10s%-15d\n",idx,x.getUserID(),x.getUserName(),x.getUserTle(),x.isMale()?"male":"femal",x.getInfo1(),x.getInfo2(),x.getGraduatedate());
							++idx;
						}
					}
					if(idx==1)
					{
						System.out.println("没有您想要的信息");
					}
				}
				else
				{
					System.out.println("没有这个选项");
				}
			}catch(Exception e)
			{
				System.out.println("输入非法！");
				input.nextLine();
				break;
			}
		}
		return;
	}
}
