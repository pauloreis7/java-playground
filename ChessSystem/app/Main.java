package ChessSystem.app;

import java.util.Locale;
import java.util.Scanner;

import ChessSystem.app.view.UI;
import ChessSystem.modules.chess.entities.ChessMatch;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.entities.ChessPosition;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();

    while (true) {
      UI.printBoard(chessMatch.getPieces());

      System.out.println();
      System.out.print("Source: ");

      ChessPosition source = UI.readChessPosition(scanner);

      System.out.println();
      System.out.print("Target: ");

      ChessPosition target = UI.readChessPosition(scanner);

      ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

    }

    // scanner.close();
  }
}
