import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeBoard {
	private TicTacToePiece board[][];
	private int turn;

	public TicTacToeBoard() {
		board = new TicTacToePiece[3][3];
		for (TicTacToePiece[] row : board) {
			Arrays.fill(row, new TicTacToePiece(PieceType.BLANK));
		}
		turn = 1;
	}

	private boolean placePiece(int row, int column, TicTacToePiece piece) {
		try {
			if (board[--row][--column].getPieceType() == PieceType.BLANK) {
				board[row][column] = piece;
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("That spot is not on the board");
			return false;
		}
		System.out.println("That spot is taken");
		return false;
	}

	private boolean checkForWinner() {
		for (int x = 0; x < 3; x++) {
			if (board[x][0].match(board[x][1], board[x][2]) || board[0][x].match(board[1][x], board[2][x])) {
				return true;
			}
		}
		if (board[0][0].match(board[1][1], board[2][2]) || board[2][0].match(board[1][1], board[0][2])) {
			return true;
		}
		return false;
	}

	public void startGame() {
		Scanner in = new Scanner(System.in);
		String playerOne;
		String playerTwo;
		int row;
		int column;
		System.out.println("Enter Player one's name: ");
		playerOne = in.next();
		System.out.println("Enter Player Two's name: ");
		playerTwo = in.next();
		while (true) {
			System.out.println((turn % 2 == 1 ? playerOne : playerTwo) + " turn");
			System.out.println("Enter the row: ");
			row = in.nextInt();
			System.out.println("Enter the column: ");
			column = in.nextInt();
			if (placePiece(row, column, new TicTacToePiece((turn % 2 == 1 ? PieceType.X : PieceType.O)))) {
				if (checkForWinner()) {
					System.out.println((turn % 2 == 1 ? playerOne : playerTwo) + " has won the game!");
					break;
				} else if (turn == 9) {
					System.out.println("It's a Draw!");
					break;
				}
				System.out.println(this);
				turn++;
			}
		}
		in.close();
	}

	@Override
	public String toString() {
		for (TicTacToePiece[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		return "";
	}

}
