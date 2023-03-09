package ChessSystem.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import ChessSystem.app.view.UI;
import ChessSystem.modules.chess.entities.ChessMatch;
import ChessSystem.modules.chess.entities.ChessPiece;
import ChessSystem.modules.chess.entities.ChessPosition;
import ChessSystem.modules.chess.errors.ChessException;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();

    while (true) {
      try {
        UI.clearScreen();
        UI.printBoard(chessMatch.getPieces());

        System.out.println();
        System.out.print("Source: ");

        ChessPosition source = UI.readChessPosition(scanner);

        System.out.println();
        System.out.print("Target: ");

        ChessPosition target = UI.readChessPosition(scanner);

        ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
      } catch (ChessException e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
      }

    }

    // scanner.close();
  }
}
