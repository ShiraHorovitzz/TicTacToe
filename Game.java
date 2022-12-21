//Tehila Menasheof 206089195
//Shira Horovitz 302642665

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	Scanner userInput = new Scanner(System.in);

	private static int round_ = 0;

	private PlayerType[][] board_;

	private PlayerType turn_;

	public Game() {
			board_ = new PlayerType[3][3];
			resetBoard();
			round_++;
		}

	// print current game board
	public void print() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				if (board_[i][j] == PlayerType.FREE) {
					System.out.print("-");
				} else if (board_[i][j] == PlayerType.X) {
					System.out.print("X");
				} else if (board_[i][j] == PlayerType.O) {
					System.out.print("O");
				} else {
					System.out.print(board_[i][j]);
				}
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	// set cell state in game board, and update player turn
	public void setCell(int row, int col, PlayerType type) {
		if (row >= 0 && row < 3 && col >= 0 && col < 3) {
			if (board_[row][col] == PlayerType.FREE) {
				board_[row][col] = type;
				if (type == PlayerType.X)
					turn_ = PlayerType.O;
				else
					turn_ = PlayerType.X;
			} else
				throw new InvalidParameterException("tried to set occupied cell");
		} else {
			throw new InvalidParameterException("invalid index");
		}
	}
	
	public void setCell2 (PlayerType type) {
		if(this.getPlayerTurn()==PlayerType.X) {
		System.out.println("Enter two valid indexes for availble cell, row and col");
		int row= userInput.nextInt();
		int col=userInput.nextInt();
		if (row >= 0 && row < 3 && col >= 0 && col < 3) {
			if (board_[row][col] == PlayerType.FREE) {
				board_[row][col] = type;
				if (type == PlayerType.X)
					turn_ = PlayerType.O;
				else
					turn_ = PlayerType.X;
			} else
				throw new InvalidParameterException("tried to set occupied cell");
		} else {
			throw new InvalidParameterException("invalid index");
		}}
	}
	


	// get cell state from game board
	public PlayerType getCell(int row, int col) {
		if (row >= 0 && row < 3 && col >= 0 && col < 3)
			return board_[row][col];
		throw new InvalidParameterException("invalid index");
	}

	// reset all cells in game board to free
	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board_[i][j] = PlayerType.FREE;
			}
		}
		turn_ = PlayerType.X;
	}

	// get list of free cells in game board
	public ArrayList<CellCoordinates> getFreeCells() {
		ArrayList<CellCoordinates> result = new ArrayList<CellCoordinates>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board_[i][j] == PlayerType.FREE)
					result.add(new CellCoordinates(i, j));
			}
		}
		return result;
	}

	// check if board is full = no free cells
	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board_[i][j] == PlayerType.FREE)
					return false;
			}
		}
		System.out.println("The board is full");
		return true;
	}

	public PlayerType getPlayerTurn() {
		return turn_;
	}

	public static String getGameName() {
		return "TicTacToe";
	}

	// get game round. each game is considered to be 1 round
	public static int getRound() {
		return round_;
	}
	
	public boolean checkForWinner() {
		for (int i = 0; i < 3; i++) {
			if (board_[i][0] == board_[i][1] && board_[i][0] == board_[i][2]
					&& board_[i][0] != PlayerType.FREE) {
				System.out.println("The winner is: " + board_[i][0]);
				return true;
			}
		}
		for (int j = 0; j < 3; j++) {
			if (board_[0][j] == board_[1][j] && board_[0][j] == board_[2][j]
					&& board_[0][j] != PlayerType.FREE) {
				System.out.println("The winner is: " + board_[0][j]);
				return true;
			}
		}
		if (board_[0][0] == board_[1][1] && board_[0][0] == board_[2][2]
				&& board_[0][0] != PlayerType.FREE) {
			System.out.println("The winner is: " + board_[0][0]);
			return true;
		}
		if (board_[0][2] == board_[1][1] && board_[2][0] == board_[0][2]
				&& board_[2][0] != PlayerType.FREE) {
			System.out.println("The winner is: " + board_[2][0]);
			return true;
		}
		return false;
	}

}
