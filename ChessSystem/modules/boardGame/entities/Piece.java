package ChessSystem.modules.boardGame.entities;

public class Piece {

  protected Position position;
  private Board board;

  public Piece(final Board board) {
    this.board = board;
  }

  protected Board getBoard() {
    return board;
  }
}
