package ChessSystem.modules.chess.entities;

import ChessSystem.modules.boardGame.entities.Position;
import ChessSystem.modules.chess.errors.ChessException;

public class ChessPosition {

  private final int row;
  private final char column;

  public ChessPosition(final char column, final int row) {
    if (column < 'a' || column > 'h' || row < 1 || row > 8) {
      throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
    }

    this.column = column;
    this.row = row;
  }

  protected Position toPosition() {
    return new Position(8 - row, column - 'a');
  }

  protected static ChessPosition fromPosition(Position position) {
    return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
  }

  @Override
  public String toString() {
    return "" + column + row;
  }
}
