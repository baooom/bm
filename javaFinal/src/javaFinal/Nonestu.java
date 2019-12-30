package javaFinal;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Nonestu extends Student implements java.io.Serializable{

	/*
	 * inf1为去处
	 * inf2为联系方式*/
	public Nonestu(long userId, String userName, String userTle, String passWord, boolean isMale, boolean isManager,
			int career,String pos,String contactIfo,int graduatedate) {
		super(userId, userName, userTle, passWord, isMale, isManager, career,graduatedate);
		// TODO Auto-generated constructor stub
		this.setInfo1(pos);
		this.setInfo2(contactIfo);
	}
	public Nonestu(Nonestu other)
	{
		super(other);
	}
	@Override
	public void changeInf1(Scanner input, String path) {
		// TODO Auto-generated method stub
		System.out.println("原去处为"+this.getInfo1());
		System.out.println("请输入新的信息");
		this.setInfo1(input.next());
		System.out.println("修改完成");
	}
	@Override
	public void changeInf2(Scanner input, String path) {
		// TODO Auto-generated method stub
		System.out.println("原联系方式为"+this.getInfo2());
		System.out.println("请输入新的信息");
		this.setInfo2(input.next());
		System.out.println("修改完成");
	}
	public void displayOperationlist()
	{
		super.displayOperationlist();
		System.out.println("4.修改去处信息");
		System.out.println("5.修改联系方式");
	}
	/*
	 * 打印待业学生的信息标签*/
	public void displayhandle()
	{
		System.out.printf("%-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","Address","ContactInfo","Graduatedate");
	}
}
