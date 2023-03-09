package ChessSystem.modules.chess.errors;

import ChessSystem.modules.boardGame.errors.BoardException;

public class ChessException extends BoardException {
  public ChessException(final String message) {
    super(message);
  }
}
