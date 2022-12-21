//Tehila Menasheof 206089195
//Shira Horovitz 302642665

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("Would you like a selfGame (0) or UserGame? (1)");
		int answer= userInput.nextInt();
		
		if (answer==0) {
		SelfGame game = new SelfGame();
		SelfPlayer p1 = new SelfPlayer(PlayerType.X, game);
		SelfPlayer p2 = new SelfPlayer(PlayerType.O, game);
		System.out.println(Game.getGameName() + " " + Game.getRound());
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();
		}
		
		if (answer==1) {
		System.out.println("Lets play together!");
		UserGame game1 = new UserGame();
		game1.print();
		UserPlayer p3 = new UserPlayer(PlayerType.X, game1);
		UserPlayer p4 = new UserPlayer(PlayerType.O, game1);
		System.out.println(Game.getGameName() + " " + Game.getRound());
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		t3.start();
		t4.start();
		}
	}
}