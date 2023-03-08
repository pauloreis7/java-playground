package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.chess.entities.pieces.King;
import ChessSystem.modules.chess.entities.pieces.Rook;
import ChessSystem.modules.chess.enums.Color;

public class ChessMatch {
  private Board board;

  public ChessMatch() {
    board = new Board(8, 8);

    initialSetup();
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] chessPieceMat = new ChessPiece[board.getRows()][board.getColumns()];

    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        chessPieceMat[i][j] = (ChessPiece) board.piece(i, j);
      }
    }

    return chessPieceMat;
  }

  private void placeNewPiece(final char column, final int row, final ChessPiece chessPiece) {
    final ChessPosition chessPosition = new ChessPosition(column, row);

    board.placePiece(chessPiece, chessPosition.toPosition());
  }

  private void initialSetup() {
    placeNewPiece('b', 6, new Rook(board, Color.WHITE));
    placeNewPiece('e', 8, new King(board, Color.BLACK));
    placeNewPiece('e', 1, new King(board, Color.WHITE));
  }
}
