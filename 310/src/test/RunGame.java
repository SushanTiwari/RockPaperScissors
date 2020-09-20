package test;

import java.util.Scanner;

public class RunGame {
	static int noRounds; //give number of rounds
	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
					System.out.println("Enter number of rounds: ");
					noRounds = in.nextInt();
					int numberOfPlayers=2; //defining number of players
		         	Round round=new Round(noRounds,numberOfPlayers,true);
	          	
		         	Player player1=new Player(1,round,true);
		         	Player player2=new Player(2,round,true);
		         	
		          	player1.start();
			         player2.start();
		         	
		             while(player1.isAlive()||player2.isAlive()) {
		              	Thread.yield();
		          	}
		             BarGraph.Run();

	}

	public int getnoRounds() {
		// TODO Auto-generated method stub
		return noRounds;
	}

}
