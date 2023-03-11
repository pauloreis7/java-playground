package ChessSystem.modules.chess.entities.pieces;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.enums.Color;

public class Pawn extends ChessPiece {

  public Pawn(Board board, Color color) {
    super(board, color);
  }

  @Override
  public boolean[][] possibleMoves() {
    final boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    final Position p = new Position(0, 0);

    if (getColor() == Color.WHITE) {
      p.setValues(position.getRow() - 1, position.getColumn());

      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() - 2, position.getColumn());

      Position p2 = new Position(position.getRow() - 1, position.getColumn());

      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() - 1, position.getColumn() - 1);

      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() - 1, position.getColumn() + 1);

      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
    } else {
      p.setValues(position.getRow() + 1, position.getColumn());

      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() + 2, position.getColumn());

      Position p2 = new Position(position.getRow() + 1, position.getColumn());

      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() + 1, position.getColumn() - 1);

      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() + 1, position.getColumn() + 1);

      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
    }
    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }

}
