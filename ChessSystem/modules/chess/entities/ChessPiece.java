package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Piece;
import ChessSystem.modules.chess.enums.Color;

public class ChessPiece extends Piece {

  private final Color color;

  public ChessPiece(final Board board, final Color color) {
    super(board);

    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
