package ChessSystem.modules.chess.entities.pieces;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.enums.Color;

public class Rook extends ChessPiece {

  public Rook(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "R";
  }
}
