package javaFinal;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Companystu extends Student implements java.io.Serializable {

	/*
	 * inf1为公司信息
	 * inf2为岗位信息*/
	public Companystu(long userId, String userName, String userTle, String passWord, boolean isMale,
			boolean isManager, int career,String Company,String works,int graduatedate) {
		super(userId, userName, userTle, passWord, isMale, isManager, career,graduatedate);
		// TODO Auto-generated constructor stub
		this.setInfo1(Company);
		this.setInfo2(works);
	}
	/*
	 * 用于深拷贝的构造函数*/
	public Companystu(Companystu other)
	{
		super(other);
	}
	@Override
	public void changeInf1(Scanner input, String path) {
		// TODO Auto-generated method stub
		System.out.println("原公司为"+this.getInfo1());
		System.out.println("请输入新的信息");
		this.setInfo1(input.next());
		System.out.println("修改完成");
	}
	@Override
	public void changeInf2(Scanner input, String path) {
		// TODO Auto-generated method stub
		System.out.println("原岗位为"+this.getInfo2());
		System.out.println("请输入新的信息");
		this.setInfo2(input.next());
		System.out.println("修改完成");
	}
	public void displayOperationlist()
	{
		super.displayOperationlist();
		System.out.println("4.修改公司信息");
		System.out.println("5.修改岗位信息");
	}	
	/*
	 * 打印就业学生的信息标签*/
	public void displayhandle()
	{
		System.out.printf("%-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Company","Post","Graduatedate");
	}
}

