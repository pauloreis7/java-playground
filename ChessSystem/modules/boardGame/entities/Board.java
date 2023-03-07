package ChessSystem.modules.boardGame.entities;

public class Board {
  private final int rows;
  private final int columns;
  private final Piece[][] pieces;

  public Board(final int rows, final int columns) {
    this.rows = rows;
    this.columns = columns;
    this.pieces = new Piece[rows][columns];
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public Piece piece(final int row, final int column) {
    return pieces[row][column];
  }

  public Piece piece(final Position position) {
    return pieces[position.getRow()][position.getColumn()];
  }
}
