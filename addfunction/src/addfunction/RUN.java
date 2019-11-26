package addfunction;

import java.util.Scanner;

public class RUN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Addgame game = new Addgame((int)(Math.random()*100),(int)(Math.random()*100));
		game.display();
		int ans=input.nextInt();
		while(!game.isCorrect(ans))
		{
			if(game.isVisted(ans))
			{
				System.out.println("You already entered "+ans);
			}
			game.setvis(ans);
			System.out.print("Wrong answer.Try again.");
			game.display();
			ans=input.nextInt();
		}
		System.out.println("You got it!");
	}

}
