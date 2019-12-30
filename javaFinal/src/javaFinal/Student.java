package javaFinal;

import java.util.Scanner;

@SuppressWarnings("serial")
public abstract class Student extends User implements java.io.Serializable {

	private String info1;
	private String info2;
	private int graduatedate;
	private int career;
	/*
	 * 0：考研
	 * 1：就业
	 * 2：待业*/
	public Student(long userId, String userName, String userTle, String passWord, boolean isMale, boolean isManager,int career,int graduatedate) {
		super(userId, userName, userTle, passWord, isMale, isManager);
		this.setCareer(career);
		this.setInfo1("");
		this.setInfo2("");
		this.setGraduatedate(graduatedate);
		// TODO Auto-generated constructor stub
	}
	/*
	 * 用于深拷贝的构造函数*/
	public Student(Student other)
	{
		super(other);
		this.setCareer(other.getCareer());
		this.setInfo1(other.getInfo1());
		this.setInfo2(other.getInfo2());
		this.setGraduatedate(other.getGraduatedate());
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	
	/*
	 * 修改用户信息，对于不同类型用户，info1和info2不相同*/
	public abstract void changeInf1(Scanner input,String path);
	public abstract void changeInf2(Scanner input,String path);
	public String getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
	public void displayUserIfo()
	{
		System.out.printf("%-15d%-10s%-13s%-6s%-10s%-10s%-15d\n\n",this.getUserID(),this.getUserName(),this.getUserTle(),this.isMale()?"male":"female",this.getInfo1(),this.getInfo2(),this.getGraduatedate());
	}
	public boolean operator(Scanner input, String path, int opt,boolean ismanager) {
		// TODO Auto-generated method stub
		if(opt==1)
		{
			this.changeTel(input, path);
			return true;
		}else if(opt==2)
		{
			this.changePassword(input, path, ismanager);
			return true;
		}else if(opt==3)
		{
			this.changeName(input, path);
			return true;
		}else if(opt==4)
		{
			this.changeInf1(input, path);
			return true;
		}else if(opt==5)
		{
			this.changeInf2(input, path);
			return true;
		}
		return false;
	}
	public int getGraduatedate() {
		return graduatedate;
	}
	public void setGraduatedate(int graduatedate) {
		this.graduatedate = graduatedate;
	}
}