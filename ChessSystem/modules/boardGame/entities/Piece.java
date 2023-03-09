package ChessSystem.modules.boardGame.entities;

public abstract class Piece {

  protected Position position;
  private Board board;

  public Piece(final Board board) {
    this.board = board;
  }

  protected Board getBoard() {
    return board;
  }

  public abstract boolean[][] possibleMoves();

  public boolean possibleMove(final Position position) {
    final boolean[][] mat = possibleMoves();

    return mat[position.getRow()][position.getColumn()];
  }

  public boolean isThereAnyPossibleMove() {
    final boolean[][] mat = possibleMoves();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat.length; j++) {
        if (mat[i][j]) {
          return true;
        }
      }
    }

    return false;
  }
}
