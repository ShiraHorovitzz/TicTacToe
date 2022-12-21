//Tehila Menasheof 206089195
//Shira Horovitz 302642665
import java.util.ArrayList;
import java.util.Random;

public class SelfPlayer extends Player implements Runnable {
	
	Random random = new Random();
	PlayerType player;
	SelfGame game;

	public SelfPlayer(PlayerType player, SelfGame game) {
		this.player=player;
		this.game = game;
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(500);
				if (this.player == game.getPlayerTurn())
					if (!game.isBoardFull() && !game.checkForWinner()) {
						ArrayList<CellCoordinates> freeCells = game.getFreeCells(); // get list of free cells
						int i = random.nextInt(freeCells.size());
						game.setCell(freeCells.get(i).getRow(), freeCells.get(i).getCol(), this.player);
						game.print();
					} else {
						//System.out.println("Board is full");
						return;
					}
				if (game.isBoardFull()) {
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}