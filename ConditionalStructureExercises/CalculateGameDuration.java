package ConditionalStructureExercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculateGameDuration {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the game start hour:");

    int gameStartHour = scanner.nextInt();

    System.out.println("Type the game end hour");

    int gameEndHour = scanner.nextInt();
    scanner.close();

    int gamePeriod = gameStartHour - gameEndHour;

    if (gamePeriod < 0) {
      int positiveGamePeriod = Math.abs(gamePeriod);

      System.out.printf("GAME DURATION IS %d HOUR(S) \n", positiveGamePeriod);
      return;
    }

    int gameDuration = 24 - gamePeriod;

    System.out.printf("GAME DURATION IS %d HOUR(S) \n", gameDuration);
  }
}
