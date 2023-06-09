package ChessSystem.modules.chess.entities.pieces;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.enums.Color;

public class Knight extends ChessPiece {

  public Knight(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "N";
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p == null || p.getColor() != getColor();
  }

  @Override
  public boolean[][] possibleMoves() {
    final boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    final Position p = new Position(0, 0);

    p.setValues(position.getRow() - 1, position.getColumn() - 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() - 2, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() - 2, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() - 1, position.getColumn() + 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() + 1, position.getColumn() + 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() + 2, position.getColumn() + 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() + 2, position.getColumn() - 1);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    p.setValues(position.getRow() + 1, position.getColumn() - 2);
    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    return mat;
  }
}
