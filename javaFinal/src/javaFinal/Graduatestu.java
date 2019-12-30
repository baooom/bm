package javaFinal;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Graduatestu extends Student implements java.io.Serializable {

	/*
	 * inf1为学校信息
	 * inf2为专业信息*/
	
	public Graduatestu(long userId, String userName, String userTle, String passWord, boolean isMale,
			boolean isManager, int career,String school,String major,int graduatedate) {
		super(userId, userName, userTle, passWord, isMale, isManager, career,graduatedate);
		this.setInfo1(school);
		this.setInfo2(major);
		// TODO Auto-generated constructor stub
	}
	/*
	 * 用于深拷贝的构造函数*/
	public Graduatestu(Graduatestu other)
	{
		super(other);
	}
	@Override
	public void changeInf1(Scanner input, String path) {
		// TODO Auto-generated method stub
		path+="修改学校信息>>";
		System.out.println(path);
		System.out.println("原学校为 "+this.getInfo1());
		System.out.println("请输入新的信息");
		this.setInfo1(input.next());
		System.out.println("修改完成");
	}
	@Override
	public void changeInf2(Scanner input, String path) {
		// TODO Auto-generated method stub
		path+="修改专业信息>>";
		System.out.println(path);
		System.out.println("原专业为 "+this.getInfo2());
		System.out.println("请输入新的信息");
		this.setInfo2(input.next());
		System.out.println("修改完成");
	}
	public void displayOperationlist()
	{
		super.displayOperationlist();
		System.out.println("4.修改学校信息");
		System.out.println("5.修改专业信息");
	}
	/*
	 * 打印考研学生的信息标签*/
	public void displayhandle()
	{
		System.out.printf("%-15s%-10s%-13s%-6s%-10s%-10s%-15s\n","UserId","Name","UserTel","Sex","School","Major","Graduatedate");
	}
}

