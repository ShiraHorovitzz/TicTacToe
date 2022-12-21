//Tehila Menasheof 206089195
//Shira Horovitz 302642665

import java.util.ArrayList;

public class SelfGame extends Game {

	public synchronized void setCell(int row, int col, PlayerType type) {
		try {
			while (type != getPlayerTurn())
				wait();
		} catch (InterruptedException e) {
			return;
		}
		super.setCell(row, col, type);
		this.notifyAll();
	}

	public synchronized void print() {
		super.print();
	}

	public synchronized ArrayList<CellCoordinates> getFreeCells() {
		return super.getFreeCells();
	}

	public synchronized PlayerType getPlayerTurn() {
		return super.getPlayerTurn();
	}

}