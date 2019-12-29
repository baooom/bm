package subtractionquiz;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = (int)(Math.random()*10);
		int number2 = (int)(Math.random()*10);
		if(number1 < number2)
		{
			int temp=number1;
			number1=number2;
			number2=temp;
		}
		Scanner input = new Scanner(System.in);
		System.out.println("What is "+number1 + " - "+number2+"? ");
		int ans=input.nextInt();
		if(number1-number2==ans)
		{
			System.out.println("You are correct!");
		}else
		{
			System.out.println("Your answer is wrong");
			System.out.println(number1+" - "+number2+" is "+(number1-number2));
		}
		
	}

}
