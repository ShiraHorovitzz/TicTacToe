//Tehila Menasheof 206089195
//Shira Horovitz 302642665

import java.util.ArrayList;

public class UserGame extends Game {

	public synchronized void setCell2( PlayerType type) {
		try {
			while (type != getPlayerTurn())
				wait();
		} catch (InterruptedException e) {
			return;
		}
		super.setCell2(type);
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