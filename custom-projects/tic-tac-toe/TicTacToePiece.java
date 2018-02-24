
public class TicTacToePiece {
	private PieceType type;

	public TicTacToePiece(PieceType type) {
		this.type = type;
	}

	public PieceType getPieceType() {
		return type;
	}

	public boolean match(TicTacToePiece... pieces) {
		for (TicTacToePiece piece : pieces) {
			if (piece.type == PieceType.BLANK || this.type != piece.getPieceType()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		switch (type) {
		case O:
			return "o";
		case X:
			return "x";
		case BLANK:
			return " ";
		default:
			return " ";
		}
	}
}
