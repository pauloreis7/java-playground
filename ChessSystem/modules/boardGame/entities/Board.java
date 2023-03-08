package ChessSystem.modules.boardGame.entities;

import ChessSystem.modules.boardGame.errors.BoardException;

public class Board {
  private final int rows;
  private final int columns;
  private final Piece[][] pieces;

  public Board(final int rows, final int columns) {
    if (rows < 1 || columns < 1) {
      throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
    }

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
    validatePosition(row, column);

    return pieces[row][column];
  }

  public Piece piece(final Position position) {
    validatePosition(position);

    return pieces[position.getRow()][position.getColumn()];
  }

  public void placePiece(final Piece piece, final Position position) {
    if (thereIsAPiece(position)) {
      throw new BoardException("There is already a piece on position " + position);
    }

    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  private boolean positionExists(final int row, final int column) {
    final boolean isRowPositionValid = row >= 0 && row < rows;
    final boolean isColumnPositionValid = column >= 0 && column < columns;

    return isRowPositionValid && isColumnPositionValid;
  }

  private boolean positionExists(final Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  private void validatePosition(final Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }
  }

  private void validatePosition(final int row, final int column) {
    if (!positionExists(row, column)) {
      throw new BoardException("Position not on the board");
    }
  }

  private boolean thereIsAPiece(final Position position) {
    validatePosition(position);

    return piece(position) != null;
  }
}
