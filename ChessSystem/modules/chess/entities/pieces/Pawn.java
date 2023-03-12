package ChessSystem.modules.chess.entities.pieces;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.entities.ChessMatch;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.enums.Color;

public class Pawn extends ChessPiece {

  private final ChessMatch chessMatch;

  public Pawn(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);

    this.chessMatch = chessMatch;
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

      // #specialmove en passant white
      if (position.getRow() == 3) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);

        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
          mat[left.getRow() - 1][left.getColumn()] = true;
        }

        Position right = new Position(position.getRow(), position.getColumn() + 1);

        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
          mat[right.getRow() - 1][right.getColumn()] = true;
        }
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

      if (position.getRow() == 4) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);

        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
          mat[left.getRow() + 1][left.getColumn()] = true;
        }

        Position right = new Position(position.getRow(), position.getColumn() + 1);

        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
          mat[right.getRow() + 1][right.getColumn()] = true;
        }
      }
    }

    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }

}
