package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Board;
import ChessSystem.modules.boardGame.entities.Piece;
import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.entities.pieces.King;
import ChessSystem.modules.chess.entities.pieces.Rook;
import ChessSystem.modules.chess.enums.Color;
import ChessSystem.modules.chess.errors.ChessException;

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

  public ChessPiece performChessMove(final ChessPosition sourcePosition, final ChessPosition targetPosition) {
    Position source = sourcePosition.toPosition();
    Position target = targetPosition.toPosition();

    validateSourcePosition(source);
    Piece capturedPiece = makeMove(source, target);

    return (ChessPiece) capturedPiece;
  }

  private Piece makeMove(Position source, Position target) {
    Piece pieceToMove = board.removePiece(source);
    Piece capturedPiece = board.removePiece(target);

    board.placePiece(pieceToMove, target);

    return capturedPiece;
  }

  private void validateSourcePosition(Position position) {
    if (!board.thereIsAPiece(position)) {
      throw new ChessException("There is no piece on source position");
    }
  }

  private void placeNewPiece(final char column, final int row, final ChessPiece chessPiece) {
    final ChessPosition chessPosition = new ChessPosition(column, row);

    board.placePiece(chessPiece, chessPosition.toPosition());
  }

  private void initialSetup() {
    placeNewPiece('c', 1, new Rook(board, Color.WHITE));
    placeNewPiece('c', 2, new Rook(board, Color.WHITE));
    placeNewPiece('d', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    placeNewPiece('d', 1, new King(board, Color.WHITE));

    placeNewPiece('c', 7, new Rook(board, Color.BLACK));
    placeNewPiece('c', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 8, new King(board, Color.BLACK));
  }
}
