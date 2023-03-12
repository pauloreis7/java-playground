package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Piece;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.enums.Color;

public abstract class ChessPiece extends Piece {

  private final Color color;
  private int moveCount;

  public ChessPiece(final Board board, final Color color) {
    super(board);

    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public int getMoveCount() {
    return moveCount;
  }

  protected void increaseMoveCount() {
    moveCount++;
  }

  protected void decreaseMoveCount() {
    moveCount--;
  }

  public ChessPosition getChessPosition() {
    return ChessPosition.fromPosition(position);
  }

  protected boolean isThereOpponentPiece(final Position position) {
    ChessPiece piece = (ChessPiece) getBoard().piece(position);

    return piece != null && piece.getColor() != color;
  }
}
