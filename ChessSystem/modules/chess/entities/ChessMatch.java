package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.entities.pieces.King;
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

  private void initialSetup() {
    board.placePiece(new King(board, Color.BLACK), new Position(2, 4));
    board.placePiece(new King(board, Color.BLACK), new Position(2, 4));
  }
}
