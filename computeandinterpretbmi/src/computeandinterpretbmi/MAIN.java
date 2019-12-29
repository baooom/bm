package computeandinterpretbmi;

import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("enter weight in pounds: ");
		double weight = input.nextDouble();
		System.out.println("enter height in inches: ");
		double height = input.nextDouble();
		final double kilograms_per_pound = 0.45359237;
		final double meters_per_inch = 0.0254;
		double weightinkilograms=weight*kilograms_per_pound;
		double heightinmeters = height*meters_per_inch;
		double bmi=weightinkilograms/(heightinmeters*heightinmeters);
		System.out.println("BMI is "+bmi);
		if(bmi<18.5)
			System.out.println("underweight");
		else if(bmi<25)
			System.out.println("normal");
		else if(bmi<30)
			System.out.println("overweight");
		else
			System.out.println("boese");
	}

}
