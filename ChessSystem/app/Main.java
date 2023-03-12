package ChessSystem.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
    final List<ChessPiece> captured = new ArrayList<>();

    while (!chessMatch.getCheckMate()) {
      try {
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);

        System.out.println();
        System.out.print("Source: ");

        ChessPosition source = UI.readChessPosition(scanner);

        boolean[][] possibleMoves = chessMatch.possibleMoves(source);
        UI.clearScreen();
        UI.printBoard(chessMatch.getPieces(), possibleMoves);

        System.out.println();
        System.out.print("Target: ");

        ChessPosition target = UI.readChessPosition(scanner);

        ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        if (capturedPiece != null) {
          captured.add(capturedPiece);
        }

        if (chessMatch.getPromoted() != null) {
          System.out.print("Enter piece for promotion (B/N/R/Q): ");
          String type = scanner.nextLine();

          chessMatch.replacePromotedPiece(type);
        }
      } catch (ChessException e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
      }
    }

    System.out.println();

    UI.clearScreen();
    UI.printMatch(chessMatch, captured);

    scanner.close();
  }
}
