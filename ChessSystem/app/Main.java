package ChessSystem.app;

import ChessSystem.app.view.UI;
import ChessSystem.modules.chess.entities.ChessMatch;

public class Main {

  public static void main(String[] args) {
    ChessMatch chessMatch = new ChessMatch();

    UI.printBoard(chessMatch.getPieces());
  }
}
